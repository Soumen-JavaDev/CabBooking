package com.example.CarBooking.DTO.Request;

import com.example.CarBooking.Enum.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverRequest {
    private String name;
    private String mobNo; // Mobile number stored as a String
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
