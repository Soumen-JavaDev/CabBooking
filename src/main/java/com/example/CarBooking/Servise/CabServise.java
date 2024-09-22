package com.example.CarBooking.Servise;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CarBooking.DTO.Request.CabRequest;
import com.example.CarBooking.DTO.Respons.CabResponse;
import com.example.CarBooking.Excption.DriverExcaption;
import com.example.CarBooking.Model.Cab;
import com.example.CarBooking.Model.Driver;
import com.example.CarBooking.Repository.DriverRepository;
import com.example.CarBooking.Transformer.CabTransformer;

@Service
public class CabServise {
    @Autowired
    DriverRepository drepo;
    public CabResponse saveCar(CabRequest request, int id) {
       Optional<Driver> d=drepo.findById(id);
       if(d.isEmpty()){
        throw new DriverExcaption("invalid id");
       }
       Driver dex=d.get();
       Cab car=CabTransformer.requestToCar(request);
       dex.setCab(car);
      Driver savedriver= drepo.save(dex);
       return CabTransformer.CarToResponse(savedriver.getCab(), savedriver);
    }
}
