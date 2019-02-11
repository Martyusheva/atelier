package com.example.atelier.controller;

import com.example.atelier.model.Users.Tailor;
import com.example.atelier.model.Users.User;
import com.example.atelier.repository.TailorRepository;
import com.example.atelier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AddTailor {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TailorRepository tailorRepository;

    @RequestMapping(value = "/AddTailor", method = RequestMethod.POST)
    public String addTailor(@RequestParam String id){
        if (id.equals("-")) return "redirect:Users";

        Long idLong = Long.parseLong(id);
        Tailor tailor = new Tailor();
        userRepository.findById(idLong);
        Optional<User> newTailor = userRepository.findById(idLong);
        if (newTailor.isPresent())
        {
            tailor.setUser(newTailor.get());
            tailorRepository.save(tailor);
        }

        return "redirect:Tailors";
    }
}
