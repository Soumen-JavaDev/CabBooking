package com.example.CarBooking.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CarBooking.DTO.Request.BookingRequest;
import com.example.CarBooking.DTO.Respons.BookingResponse;
import com.example.CarBooking.Servise.BookingService;

/**
 * BookingController
 */
@RestController
@RequestMapping("booking")
public class BookingController {
     @Autowired
    BookingService service;
   
    @PostMapping("/book/customer/{customer}")
    public BookingResponse bookCar(@RequestBody BookingRequest book,@PathVariable("customer")int id) throws Exception{
        return service.bookCar(book,id);
    }
    
}