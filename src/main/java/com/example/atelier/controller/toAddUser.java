package com.example.atelier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class toAddUser {

    @RequestMapping("/toAddUser")
    public String login() {
        return "/Administrator/AddUser";
    }

}