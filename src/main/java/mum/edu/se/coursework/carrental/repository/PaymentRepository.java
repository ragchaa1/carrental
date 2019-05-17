package mum.edu.se.coursework.carrental.repository;

import mum.edu.se.coursework.carrental.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
