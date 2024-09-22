package com.example.CarBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CarBooking.Model.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {
    
}
