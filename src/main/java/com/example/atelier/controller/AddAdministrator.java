package com.example.atelier.controller;

import com.example.atelier.model.Users.Administrator;
import com.example.atelier.model.Users.User;
import com.example.atelier.repository.AdministratorRepository;
import com.example.atelier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AddAdministrator {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @RequestMapping(value = "/AddAdministrator", method = RequestMethod.POST)
    public String addAdministrator(@RequestParam String id){
        if (id.equals("-")) return "redirect:Users";

        try {
            Optional<User> newAdministrator = userRepository.findById(Long.parseLong(id));
            if (newAdministrator.isPresent()) {
                administratorRepository.save(new Administrator(newAdministrator.get()));
            }
            return "redirect:Administrators";
        }
        catch (Exception e) {return "redirect:Failure";}
    }
}
