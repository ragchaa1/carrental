package mum.edu.se.coursework.carrental.repository;

import mum.edu.se.coursework.carrental.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends  JpaRepository<Vehicle,Long> {
}