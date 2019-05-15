package mum.edu.se.coursework.carrental.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "BOOKING")
@Data
public class Booking {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;

    @Column(name = "USER_ID")
    private Long userId;



}
