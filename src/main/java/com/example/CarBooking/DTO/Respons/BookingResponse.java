package com.example.CarBooking.DTO.Respons;

import com.example.CarBooking.Enum.TripStatus;


import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookingResponse {
    private int bookingId;
    private String pickup;
    private String destination;
    private double trip_distanceinkm;

    private TripStatus trips_status;
    private double bill_amout;
    Date bookedAt;
    Date lastUpdateAt;
    CustomerResponse customer;
    CabResponse car;
}
