package mum.edu.se.coursework.carrental.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLE_AVAILABILITY")
@Data
public class VehicleAvailability {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleAvaId;
}
