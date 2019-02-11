package com.example.atelier.controller;

import com.example.atelier.model.Users.Tailor;
import com.example.atelier.repository.TailorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class Tailors {

    @Autowired
    private TailorRepository tailorRepository;



    @RequestMapping("/Tailors")
    public String mastersList(Model model){
        ArrayList<Tailor> tailorList = (ArrayList<Tailor>) tailorRepository.findAll();
        model.addAttribute("tailorList", tailorList);
        return "/Administrator/Tailors";
    }
}