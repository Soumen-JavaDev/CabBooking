package com.example.CarBooking.Excption;




public class CabNotFound extends RuntimeException {
    public CabNotFound(String mass){
        super(mass);
    }
}
