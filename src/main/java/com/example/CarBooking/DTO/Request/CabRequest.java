package com.example.CarBooking.DTO.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CabRequest {


    private String cabNumber;
    private String cabModel;

    private double perKmRate; // Naming convention (camel case)

}
