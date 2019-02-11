package com.example.atelier.controller;

import com.example.atelier.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Products {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping("/Products")
    public String usersList(Model model){
        model.addAttribute("productsList", productRepository.findAll());
        return "/Administrator/Products";
    }
}