package mum.edu.se.coursework.carrental.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PAYMENT")
@Data
public class Payment {
    @Id
    @Column(name = "PAYMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
}
