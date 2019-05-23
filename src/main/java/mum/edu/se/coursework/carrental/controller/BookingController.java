package mum.edu.se.coursework.carrental.controller;

import lombok.extern.java.Log;
import mum.edu.se.coursework.carrental.entity.Booking;
import mum.edu.se.coursework.carrental.entity.Payment;
import mum.edu.se.coursework.carrental.entity.User;
import mum.edu.se.coursework.carrental.entity.UserRole;
import mum.edu.se.coursework.carrental.service.BookingService;
import mum.edu.se.coursework.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@Log
public class BookingController {

    @Autowired
    UserService userService;

    @Autowired
    BookingService bookingService;

    @RequestMapping(value="/booking", method = RequestMethod.POST)
    public ModelAndView createBooking(Booking booking, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());

        booking.setUserId(user.getUserId());

        Payment payment=new Payment();

        modelAndView.addObject("payment", payment);
        modelAndView.setViewName("payment");
        UserRole userRole = userService.findbyUserId(user.getUserId());
        modelAndView.addObject("userRole", userRole);

        bookingService.saveBooking(booking);

        return modelAndView;
    }

}
