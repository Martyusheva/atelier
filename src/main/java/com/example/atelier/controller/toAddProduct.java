package com.example.atelier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class toAddProduct {

    @RequestMapping("/toAddProduct")
    public String login() {
        return "/Administrator/AddProduct";
    }

}