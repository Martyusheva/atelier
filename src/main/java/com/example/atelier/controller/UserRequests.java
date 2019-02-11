package com.example.atelier.controller;


import com.example.atelier.model.Users.User;
import com.example.atelier.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserRequests {

    @Autowired
    private RequestRepository requestRepository;

    @RequestMapping(value = "/userRequests", method = RequestMethod.GET)
    public String requestList(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Integer id = user.getId().intValue();
        session.setAttribute("userRequests", requestRepository.findAllByUserid(id));
        return "/User/UserRequests";
    }
}