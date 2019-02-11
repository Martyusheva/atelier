package com.example.atelier.controller;

import com.example.atelier.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Repairs {

    @Autowired
    private RequestRepository requestRepository;

    @RequestMapping("/Repairs")
    public String usersList(Model model){

        //ArrayList<Request> repairs = (ArrayList<Request>) requestRepository.findAll();
        //model.addAttribute("RepairList", repairs);
        //model.addAttribute("ToCloseRepairList", repairRepository.findByProgress(Request.progressToInt(Request.Progress.Done)));
        return "/Administrator/Repairs";
    }
}