package com.example.CarBooking.Transformer;

import com.example.CarBooking.DTO.Request.BookingRequest;
import com.example.CarBooking.DTO.Respons.BookingResponse;
import com.example.CarBooking.Model.Booking;
import com.example.CarBooking.Model.Cab;
import com.example.CarBooking.Model.Customer;
import com.example.CarBooking.Model.Driver;

public class BookingTransformer {
    public static Booking requestToBooking(BookingRequest request, Double val){
        return Booking.builder()
               .pickup(request.getPickup())
               .destination(request.getDestination())
               .trip_distanceinkm(request.getTrip_distanceinkm()*val)
                .build();


    }
    public static BookingResponse responsBooking(Booking b, Customer cr, Cab c, Driver d){
        return BookingResponse.builder()
                .bookingId(b.getBookingId())
                .pickup(b.getPickup())
                .destination(b.getDestination())
                .trip_distanceinkm(b.getTrip_distanceinkm())
                .trips_status(b.getTrips_status())
                .bill_amout(b.getBill_amount())
                .bookedAt(b.getBookedAt())
                .lastUpdateAt(b.getLastUpdateAt())
                .customer(CustomerTransformer.customerToResponse(cr))
                .car(CabTransformer.CarToResponse(c, d)) // Ensure Driver is handled correctly
                .build();


    }
}
