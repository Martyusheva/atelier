package com.example.atelier.controller;

import com.example.atelier.model.Users.Administrator;
import com.example.atelier.model.Users.Tailor;
import com.example.atelier.model.Users.User;
import com.example.atelier.repository.AdministratorRepository;
import com.example.atelier.repository.TailorRepository;
import com.example.atelier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class Users {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TailorRepository tailorRepository;

    @Autowired
    private AdministratorRepository administratorRepository;


    @RequestMapping("/Users")
    public String usersList(Model model) {
        ArrayList<User> usersList = (ArrayList<User>) userRepository.findAll();
        ArrayList<Tailor> tailorsList = (ArrayList<Tailor>) tailorRepository.findAll();
        ArrayList<Administrator> adminsList = (ArrayList<Administrator>) administratorRepository.findAll();
        model.addAttribute("usersList", userRepository.findAll());

        Iterator<User> u = usersList.iterator();
        Iterator<Tailor> m = tailorsList.iterator();
        Iterator<Administrator> a = adminsList.iterator();

        while (u.hasNext()) {
            User user = u.next();
            while (m.hasNext()) {
                Tailor tailor = m.next();
                if (user.getId() == tailor.getUser().getId())
                    u.remove();
            }
            m = tailorsList.iterator();
        }

        u = usersList.iterator();
        while (u.hasNext()) {
            User user = u.next();
            while (a.hasNext()) {
                Administrator admin = a.next();

                if (user.getId() == admin.getUser().getId())
                    u.remove();
            }
            a = adminsList.iterator();

        }
        model.addAttribute("commonUsersList", usersList);


        return "/Administrator/Users";
    }
}