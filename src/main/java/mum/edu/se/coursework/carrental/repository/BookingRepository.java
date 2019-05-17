package mum.edu.se.coursework.carrental.repository;

import mum.edu.se.coursework.carrental.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
