package com.example.CarBooking.Transformer;

import com.example.CarBooking.DTO.Request.CabRequest;
import com.example.CarBooking.DTO.Respons.CabResponse;
import com.example.CarBooking.Model.Cab;
import com.example.CarBooking.Model.Driver;

public class CabTransformer {
    public static Cab requestToCar(CabRequest request){
        return Cab.builder()
                .cabNumber(request.getCabNumber())
                .cabModel(request.getCabModel())
                .perKmRate(request.getPerKmRate())
                .available(true)
                .build();

    }
    public static CabResponse CarToResponse(Cab car, Driver driver){
        return CabResponse.builder()
                .cabId(car.getCabId())
                .driver(DriverTranesformer.DriverToRespons(driver))
                .perKmRate(car.getPerKmRate())
                .cabNumber(car.getCabNumber())
                .available(car.isAvailable())
                .cabModel(car.getCabModel())
                .build();
    }
}
