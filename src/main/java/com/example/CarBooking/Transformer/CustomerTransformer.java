package com.example.CarBooking.Transformer;

import com.example.CarBooking.DTO.Request.CustomerRequest;
import com.example.CarBooking.DTO.Respons.CustomerResponse;
import com.example.CarBooking.Model.Customer;

public class CustomerTransformer {

    // Transform CustomerRequest to Customer entity
    public static Customer requestToCustomer(CustomerRequest customerRequest) {
        return Customer.builder()
                .age(customerRequest.getAge())
                .gender(customerRequest.getGender())
                .mobNo(customerRequest.getMobNo())
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .build();
    }

    // Transform Customer entity to CustomerResponse DTO
    public static CustomerResponse customerToResponse(Customer customer) {
        return CustomerResponse.builder()
                .name(customer.getName())
                .mobNo(customer.getMobNo())
                .age(customer.getAge())
                .email(customer.getEmail())
                .build();
    }
}
