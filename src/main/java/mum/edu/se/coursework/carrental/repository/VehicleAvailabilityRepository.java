package mum.edu.se.coursework.carrental.repository;

import mum.edu.se.coursework.carrental.entity.VehicleAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleAvailabilityRepository extends JpaRepository<VehicleAvailability,Long> {
}
