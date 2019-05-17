package mum.edu.se.coursework.carrental.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "MANUFACTURER")
@Data
public class Manufacturer {
    @Id
    @Column(name = "MANUFACTURER_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mId;


}
