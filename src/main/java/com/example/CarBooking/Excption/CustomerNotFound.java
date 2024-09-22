package com.example.CarBooking.Excption;

public class CustomerNotFound extends  RuntimeException{
    public CustomerNotFound(String mass){
        super(mass);
    }

}
