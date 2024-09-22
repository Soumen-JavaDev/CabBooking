package com.example.CarBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CarBooking.DTO.Request.CabRequest;
import com.example.CarBooking.DTO.Respons.CabResponse;
import com.example.CarBooking.Servise.CabServise;
@RestController
@RequestMapping("cab")
public class CabController {
    @Autowired
    CabServise servise;

    @PostMapping("/add/car/{id}")
    public CabResponse saveCar(@RequestBody CabRequest request,@PathVariable("id") int id){
           return servise.saveCar(request,id);
    }
}
