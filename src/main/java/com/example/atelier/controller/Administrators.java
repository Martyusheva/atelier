package com.example.atelier.controller;

import com.example.atelier.model.Users.Administrator;
import com.example.atelier.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class Administrators {

    @Autowired
    private AdministratorRepository administratorRepository;



    @RequestMapping("/Administrators")
    public String getAdministrators(Model model){
        ArrayList<Administrator> adminsList = (ArrayList<Administrator>) administratorRepository.findAll();
        model.addAttribute("adminsList", adminsList);
        return "/Administrator/Administrators";
    }
}