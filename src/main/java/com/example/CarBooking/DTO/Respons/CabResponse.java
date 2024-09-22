package com.example.CarBooking.DTO.Respons;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class CabResponse {
    private int cabId;

    private String cabNumber;
    private String cabModel;

    private double perKmRate; 
    private boolean available;
    private DriverResponse driver;
}
