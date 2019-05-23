package mum.edu.se.coursework.carrental.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "LOCATION_ID")
    private Long locationId;

    @Column(name = "CAR_ID")
    private Long carId;

    @Column(name = "PICK_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickDate;

    @Column(name = "RETURN_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;

}
