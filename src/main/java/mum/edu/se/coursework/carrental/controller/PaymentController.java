package mum.edu.se.coursework.carrental.controller;

import lombok.extern.java.Log;
import mum.edu.se.coursework.carrental.entity.Payment;
import mum.edu.se.coursework.carrental.entity.User;
import mum.edu.se.coursework.carrental.service.PaymentService;
import mum.edu.se.coursework.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@Log
public class PaymentController {

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value="/payment", method = RequestMethod.POST)
    public ModelAndView createPayment(Payment payment, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        payment.setUserId(user.getUserId());
        payment.setDate(LocalDate.now());

        modelAndView.setViewName("payment");

        paymentService.savePayment(payment);

        return modelAndView;
    }
}
