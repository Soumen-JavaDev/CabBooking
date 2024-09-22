package com.example.CarBooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CarBooking.DTO.Request.DriverRequest;
import com.example.CarBooking.DTO.Respons.DriverResponse;
import com.example.CarBooking.Servise.DriverService;

@RestController
@RequestMapping("driver")
public class DriverController {
     @Autowired
    DriverService servise;
    @PostMapping("/savedriver")
    public DriverResponse saveDriver(@RequestBody DriverRequest request){
        return servise.saveDriver(request);
    }
}
