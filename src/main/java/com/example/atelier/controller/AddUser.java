package com.example.atelier.controller;

import com.example.atelier.model.Users.User;
import com.example.atelier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;


@Controller
public class AddUser extends HttpServlet {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/AddUser", method = RequestMethod.POST)
    public String addUser(@RequestParam String name, @RequestParam String surname, @RequestParam String login,
                            @RequestParam String password, @RequestParam String phone){
        if (name.equals("") || surname.equals("") || login.equals("") || password.equals("") || phone.equals("")) {
            return "redirect:Failure";
        }
        else
        {
            userRepository.save(new User(name, surname, login, password, phone));
            return "redirect:Users";
        }
    }
}
