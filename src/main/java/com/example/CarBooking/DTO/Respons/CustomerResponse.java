package com.example.CarBooking.DTO.Respons;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse {
    private String name;
    private String mobNo;
    private String email;
    private int age;
    DriverResponse drive;



}
