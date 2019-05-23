package mum.edu.se.coursework.carrental.controller;

import lombok.extern.java.Log;
import mum.edu.se.coursework.carrental.entity.*;
import mum.edu.se.coursework.carrental.service.PaymentService;
import mum.edu.se.coursework.carrental.service.StreamService;
import mum.edu.se.coursework.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Log
@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private StreamService streamService;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/home")
    public String main(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        UserRole userRole = userService.findbyUserId(user.getUserId());
        model.addAttribute("userRole", userRole);


        Booking booking=new Booking();
        model.addAttribute("user", user);
        model.addAttribute("booking", booking);

        return "home"; //view
    }

    @GetMapping("/car")
    public String car(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        model.addAttribute("user", user);

        UserRole userRole = userService.findbyUserId(user.getUserId());
        model.addAttribute("userRole", userRole);
        return "car"; //view
    }

    @GetMapping("/booking")
    public String booking(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        Booking booking=new Booking();
        model.addAttribute("user", user);
        model.addAttribute("booking",booking);

        UserRole userRole = userService.findbyUserId(user.getUserId());
        model.addAttribute("userRole", userRole);
        return "payment"; //view
    }

    @GetMapping("/payment")
    public String payment(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        Payment payment=new Payment();
        Booking booking=new Booking();
        model.addAttribute("user", user);
        model.addAttribute("payment",payment);
        model.addAttribute("booking",booking);

        UserRole userRole = userService.findbyUserId(user.getUserId());
        model.addAttribute("userRole", userRole);
        return "payment"; //view
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<User> all = userService.findAll();
        User user = userService.findUserByEmail(auth.getName());
        log.info("all size = = = "+all.size());
        Map<String, Long> surveyMap = streamService.getStateStat.apply(all);
        List<Payment> paymentList = paymentService.findAll();
        model.addAttribute("surveyMap", surveyMap);

        UserRole userRole = userService.findbyUserId(user.getUserId());
        model.addAttribute("userRole", userRole);
        return "dashboard"; //view
    }


    @GetMapping("/month")
    public String month(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<Payment> paymentList = paymentService.findAll();
        Map<Integer, Double> paymentMap = streamService.getMonthStat.apply(paymentList);
        model.addAttribute("surveyMap", paymentMap);
        User user = userService.findUserByEmail(auth.getName());
        UserRole userRole = userService.findbyUserId(user.getUserId());
        model.addAttribute("userRole", userRole);
        return "month"; //view
    }

    @GetMapping("/year")
    public String year(Model model) {
        List<Payment> paymentList = paymentService.findAll();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Map<Integer, Double> collect = paymentList.stream().collect(Collectors.groupingBy(e -> e.getDate().getYear(), Collectors.summingDouble(t -> t.getAmount())));
        Map<Integer, Double> paymentMap = streamService.getYearStat.apply(paymentList);
        User user = userService.findUserByEmail(auth.getName());
        UserRole userRole = userService.findbyUserId(user.getUserId());
        model.addAttribute("userRole", userRole);

        model.addAttribute("surveyMap", paymentMap);
        return "year"; //view
    }

    @GetMapping("/about")
    public String about(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        UserRole userRole = userService.findbyUserId(user.getUserId());
        model.addAttribute("user", user);
        model.addAttribute("userRole", userRole);

        return "about"; //view
    }

}
