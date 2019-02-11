package com.example.atelier.controller;

import com.example.atelier.model.Requests.Request;
import com.example.atelier.model.Requests.Tailoring;
import com.example.atelier.model.Users.Administrator;
import com.example.atelier.model.Users.Tailor;
import com.example.atelier.repository.UserRepository;
import com.example.atelier.repository.TailoringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TailoringList {

    @Autowired
    TailoringRepository tailoringRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/Tailoring")
    public String getTailoringList(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        if (user instanceof Administrator) {
            request.getSession().setAttribute("tailoringList", tailoringRepository.findAll());
            request.getSession().setAttribute("tailoringToCloseList", tailoringRepository.findAllByRequest_Progress(2));
            return "/Administrator/Tailoring";
        } else if (user instanceof Tailor) {
            Tailor tailor = (Tailor) user;

            List<Tailoring> ut = tailoringRepository.findAllByRequest_Progress(1);
            ArrayList<Tailoring> temp = new ArrayList<>();
            for (Tailoring tmp : ut) {
                if (tmp.getTailorid() == tailor.getId()) temp.add(tmp);
            }
            request.getSession().setAttribute("tailoringToDoneList", temp);
            request.getSession().setAttribute("tailorID", tailor.getId());
            return "/Tailor/Tailoring";
        }
        return "/login/login";
    }

    @RequestMapping("/TailoringTailor")
    public String getTailorTailoring(HttpServletRequest request) {
        request.getSession().setAttribute("tailoringList",
                tailoringRepository.findAllByRequest_Progress(0));
        int a = 5;
        return "/Tailor/GetTailoring";
    }

    @RequestMapping("/GetTailoring")
    public String getTailoring(HttpServletRequest request) {
        try {
            int idInt = Integer.parseInt(request.getParameter("tailoring_id"));
            Tailoring updateUtil = tailoringRepository.findById(idInt);
            updateUtil.getRequest().setProgress(1);
            updateUtil.setTailorid(((Tailor)request.getSession().getAttribute("user")).getId());
            tailoringRepository.save(updateUtil);
            return "redirect:Tailoring";
        } catch (Exception e) {
            return "redirect:Tailoring";
        }
    }


    @RequestMapping("/AddTailoring")
    public String addTailoring(Model model) {
        model.addAttribute("UserList", userRepository.findAll());
        return "/Administrator/AddTailoring";
    }

    @RequestMapping(value = "/AddTailoringCheck", method = RequestMethod.POST)
    public String addTailoringCheck(HttpServletRequest request, @RequestParam String id, @RequestParam String model, @RequestParam String collection, @RequestParam String comment, @RequestParam String price) {
        if (model.equals("") || collection.equals("") || comment.equals("") || id.equals("") || price.equals("")) {
            return "redirect:Failure";
        }
        int idInt = Integer.parseInt(id);
        int priceInt = Integer.parseInt(price);
        tailoringRepository.save(new Tailoring(0, new Request(((Administrator) request.getSession().getAttribute("user")).getId(),
                collection, model, comment, priceInt, idInt, 0)));
        return "redirect:Tailoring";
    }


    @RequestMapping(value = "/CloseTailoring", method = RequestMethod.POST)
    public String closeTailoring(HttpServletRequest request) {
        try {
            int idInt = Integer.parseInt(request.getParameter("tailoring_id"));
            Tailoring updateTailoring = tailoringRepository.findById(idInt);
            updateTailoring.getRequest().setProgress(3);
            tailoringRepository.save(updateTailoring);
            return "redirect:Tailoring";
        } catch (Exception e) {
            return "redirect:Tailoring";
        }

    }

    @RequestMapping(value = "/DoneTailoring", method = RequestMethod.POST)
    public String doneTailoring(HttpServletRequest request) {
        try {
            int idInt = Integer.parseInt(request.getParameter("tailoring_id"));
            Tailoring updateTailoring = tailoringRepository.findById(idInt);
            updateTailoring.getRequest().setProgress(2);
            tailoringRepository.save(updateTailoring);
            return "redirect:Tailoring";
        } catch (Exception e) {
            return "redirect:Tailoring";
        }

    }
}
