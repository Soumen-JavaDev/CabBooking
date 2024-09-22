package com.example.CarBooking.DTO.Request;

import com.example.CarBooking.Enum.Gender;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CustomerRequest {
   


    private int age;

    private String email;
    private String name;

    private String mobNo;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
