package mum.edu.se.coursework.carrental.controller;

import lombok.extern.java.Log;
import mum.edu.se.coursework.carrental.entity.Payment;
import mum.edu.se.coursework.carrental.entity.Role;
import mum.edu.se.coursework.carrental.entity.User;
import mum.edu.se.coursework.carrental.entity.UserRole;
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
        model.addAttribute("user", user);
        model.addAttribute("userRole", userRole);

        return "home"; //view
    }

    @GetMapping("/car")
    public String car(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        model.addAttribute("user", user);

        return "car"; //view
    }

    @GetMapping("/payment")
    public String payment(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        model.addAttribute("user", user);

        return "payment"; //view
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        List<User> all = userService.findAll();
        log.info("all size = = = "+all.size());
        Map<String, Long> surveyMap = streamService.getStateStat.apply(all);
        List<Payment> paymentList = paymentService.findAll();
        model.addAttribute("surveyMap", surveyMap);
        return "dashboard"; //view
    }


    @GetMapping("/month")
    public String month(Model model) {
        List<Payment> paymentList = paymentService.findAll();
        Map<Integer, Double> paymentMap = streamService.getMonthStat.apply(paymentList);
        model.addAttribute("surveyMap", paymentMap);
        return "month"; //view
    }

    @GetMapping("/year")
    public String year(Model model) {
        List<Payment> paymentList = paymentService.findAll();

        Map<Integer, Double> collect = paymentList.stream().collect(Collectors.groupingBy(e -> e.getDate().getYear(), Collectors.summingDouble(t -> t.getAmount())));
        Map<Integer, Double> paymentMap = streamService.getYearStat.apply(paymentList);


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
