package mum.edu.se.coursework.carrental.controller;

import lombok.extern.java.Log;
import mum.edu.se.coursework.carrental.entity.User;
import mum.edu.se.coursework.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String main(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        model.addAttribute("user", user);

        return "home"; //view
    }

}
