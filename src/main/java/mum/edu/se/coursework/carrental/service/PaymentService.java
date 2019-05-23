package mum.edu.se.coursework.carrental.service;

import lombok.extern.java.Log;
import mum.edu.se.coursework.carrental.entity.Payment;
import mum.edu.se.coursework.carrental.entity.User;
import mum.edu.se.coursework.carrental.entity.UserRole;
import mum.edu.se.coursework.carrental.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

}
