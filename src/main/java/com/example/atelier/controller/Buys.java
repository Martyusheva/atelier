package com.example.atelier.controller;

import com.example.atelier.model.Product.Product;
import com.example.atelier.model.Requests.Buy;
import com.example.atelier.model.Requests.Orderline;
import com.example.atelier.model.Requests.Request;
import com.example.atelier.model.Users.Administrator;
import com.example.atelier.repository.BuyRepository;
import com.example.atelier.repository.ProductRepository;
import com.example.atelier.repository.OrderlineRepository;
import com.example.atelier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Buys {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BuyRepository buyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderlineRepository orderlineRepository;

    @RequestMapping("/Buys")
    public String buysList(Model model) {
        model.addAttribute("buysToCloseList", buyRepository.findAllByRequest_Progress(1));

        model.addAttribute("buysList", buyRepository.findAll());
        return "/Administrator/Buys";
    }

    @RequestMapping("/AddBuy")
    public String addBuy(Model model) {
        model.addAttribute("UserList", userRepository.findAll());

        return "/Administrator/AddBuy";
    }

    @RequestMapping(value = "/AddBuyCheck", method = RequestMethod.POST)
    public String addBuyCheck(HttpServletRequest request, @RequestParam String id, @RequestParam String model, @RequestParam String collection, @RequestParam String comment) {
        if (model.equals("") || collection.equals("") || comment.equals("") || id.equals("")) {
            return "redirect:Failure";
        }
        int idInt = Integer.parseInt(id);
        buyRepository.save(new Buy(new Request(((Administrator) request.getSession().getAttribute("user")).getId(), collection, model, comment, 0, idInt, 0)));
        return "redirect:Buys";
    }

    @RequestMapping(value = "/CloseBuy", method = RequestMethod.POST)
    public String closeBuy(HttpServletRequest request) {
        try {
            int idInt = Integer.parseInt(request.getParameter("buy_id"));
            Buy updateBuy = buyRepository.findById(idInt);
            updateBuy.request.setProgress(3);
            buyRepository.save(updateBuy);
            return "redirect:Buys";
        } catch (Exception e) {
            return "redirect:Buys";
        }
    }

    @RequestMapping(value = "/GetOrderLines", method = RequestMethod.POST)
    public String getOrderLines(HttpServletRequest request) {
        try {
            int idInt = Integer.parseInt(request.getParameter("buy_id"));
            request.getSession().setAttribute("buy_id", idInt);
            request.getSession().setAttribute("OrderLines", orderlineRepository.findAllByBuy(idInt));

            Buy buy = buyRepository.findById(idInt);
            if (buy.request.getProgress().equals("Closed")) return "/Administrator/GetOrderLinesNoAdd";

            return "/Administrator/GetOrderLines";
        } catch (Exception e) {
            return "redirect:Buys";
        }
    }

    @RequestMapping(value = "/AddOrderLine")
    public String addOrderLines(Model model) {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);

        int idInt = (Integer) session.getAttribute("buy_id");
        model.addAttribute("productsList", productRepository.findAllByAmount());
        model.addAttribute("buy_id", idInt);
        return "/Administrator/AddOrderLine";
    }

    @RequestMapping(value = "/CheckLine")
    public String checkLine(HttpServletRequest request) {
        try {
            int idInt = Integer.parseInt(request.getParameter("product_id"));
            int countInt = Integer.parseInt(request.getParameter("count"));
            int buyInt = (Integer) request.getSession().getAttribute("buy_id");

            Product dtl = productRepository.findById(idInt);
            if ((dtl == null) || (countInt <= 0) || (dtl.getAmount() < countInt)) return "/Administrator/Failure";

            dtl.setAmount(dtl.getAmount() - countInt);
            productRepository.save(dtl);

            Buy buy = buyRepository.findById(buyInt);
            Request tmp = buy.getRequest();
            tmp.setProgress(1);
            buy.setRequest(tmp);
            buyRepository.save(buy);

            orderlineRepository.save(new Orderline(dtl, countInt, buyInt));

            return "redirect:Buys";
        } catch (Exception e) {
            return "/Administrator/GetOrderLines";
        }

    }

}