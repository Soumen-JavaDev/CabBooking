package com.example.CarBooking.DTO.Respons;

import com.example.CarBooking.Enum.Gender;
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
public class DriverResponse {
    private int driverId;
    private String name;
    private String mobNo; // Mobile number stored as a String
    private int age;
    private Gender gender;
}
