package mum.edu.se.coursework.carrental.service;

import lombok.extern.java.Log;
import mum.edu.se.coursework.carrental.entity.Booking;
import mum.edu.se.coursework.carrental.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

}
