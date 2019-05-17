package mum.edu.se.coursework.carrental.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE")
@Data
public class Vehicle {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;

    @Column(name = "USER_ID")
    @JsonFormat
    private Long userId;

}
