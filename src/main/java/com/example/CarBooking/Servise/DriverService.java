package com.example.CarBooking.Servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CarBooking.DTO.Request.DriverRequest;
import com.example.CarBooking.DTO.Respons.DriverResponse;
import com.example.CarBooking.Model.Driver;
import com.example.CarBooking.Repository.DriverRepository;
import com.example.CarBooking.Transformer.DriverTranesformer;
@Service
public class DriverService {
     @Autowired
    DriverRepository repo;
    public DriverResponse saveDriver(DriverRequest request) {
      Driver d=repo.save(DriverTranesformer.RequestToDriver(request));
     return DriverTranesformer.DriverToRespons(d);
      
      
    }
}
