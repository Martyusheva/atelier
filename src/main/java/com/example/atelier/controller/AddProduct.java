package com.example.atelier.controller;

import com.example.atelier.model.Product.Product;
import com.example.atelier.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;


@Controller
public class AddProduct extends HttpServlet {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
    public String addProduct(@RequestParam String model, @RequestParam String collection, @RequestParam String stringPrice, @RequestParam String stringAmount) {
        if (model.equals("") || collection.equals("") || stringPrice.equals("") || stringAmount.equals("")) {
            return "redirect:Failure";
        }
        Double price;
        Integer amount;
        try {
            price = Double.parseDouble(stringPrice);
            amount = Integer.parseInt(stringAmount);
        } catch (Exception e) {
            return "redirect:Failure";
        }
        productRepository.save(new Product(model, collection, price, amount));
        return "redirect:Products";
    }
}
