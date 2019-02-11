package com.example.atelier.controller;

import com.example.atelier.model.Users.Administrator;
import com.example.atelier.model.Users.Tailor;
import com.example.atelier.model.Users.User;
import com.example.atelier.repository.AdministratorRepository;
import com.example.atelier.repository.TailorRepository;
import com.example.atelier.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Authorization {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TailorRepository tailorRepository;

    @Autowired
    private AdministratorRepository administratorRepository;

    @RequestMapping(value = "/authorization", method = RequestMethod.POST)
    public String authorization(HttpServletRequest request) {
        User user = userRepository.findByLoginAndPassword(request.getParameter("login"), request.getParameter("password"));

        if (user != null) {
            HttpSession session = request.getSession();
            Tailor tailor = tailorRepository.findByUser(user);
            if (tailor != null) {
                session.setAttribute("user", tailor);
                return "redirect:Tailoring";
            }
            Administrator administrator = administratorRepository.findByUser(user);
            if (administrator != null) {
                session.setAttribute("user", administrator);
                return "redirect:Users";
            }
            session.setAttribute("user", user);
            return "redirect:userRequests";
        }
        return "/login/login";
    }
}