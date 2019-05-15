package mum.edu.se.coursework.carrental.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CAR_MODEL")
@Data
public class CarModel {

    @Id
    @Column(name = "MODEL_CODE")
    private String modelCode;

    @Column(name = "MANUFACTURER_CODE")
    private String manufacturerCode;

    @Column(name = "MODEL_NAME")
    private String modelName;
}
