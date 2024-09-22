package com.example.CarBooking.Transformer;

import com.example.CarBooking.DTO.Request.DriverRequest;
import com.example.CarBooking.DTO.Respons.DriverResponse;
import com.example.CarBooking.Model.Driver;

public class DriverTranesformer {


        public static DriverResponse DriverToRespons(Driver driver){
            DriverResponse result=DriverResponse
                    .builder().age(driver.getAge())
                    .name(driver.getName())
                    .driverId(driver.getDriverId())
                    .gender(driver.getGender())
                    .mobNo(driver.getMobNo())
                    .build();
            return result;

        }
        public static Driver RequestToDriver(DriverRequest request){
            Driver result=Driver.builder()
                    .age(request.getAge())
                    .name(request.getName())
                    .mobNo(request.getMobNo())
                    .gender(request.getGender())
                    .build();
            return result;
        }

}
