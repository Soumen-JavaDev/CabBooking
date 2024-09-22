package com.example.CarBooking.Servise;


import com.example.CarBooking.DTO.Request.CustomerRequest;
import com.example.CarBooking.DTO.Respons.CustomerResponse;
import com.example.CarBooking.Enum.Gender;
import com.example.CarBooking.Excption.CustomerNotFound;
import com.example.CarBooking.Model.Customer;
import com.example.CarBooking.Repository.CustomerRepository;
import com.example.CarBooking.Transformer.CustomerTransformer;
import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class CustomerService { // Corrected class name to follow camel case

    @Autowired
    private CustomerRepository repository;

    // Method to add a customer
    public CustomerResponse addCustomer(CustomerRequest customer) {
       Customer cust = CustomerTransformer.requestToCustomer(customer);
      
        Customer saveCustomer=repository.save(cust);
        CustomerResponse resp=CustomerTransformer.customerToResponse(saveCustomer);
        return resp;
    }

  

   // Find customer by ID
   public CustomerResponse findId(int id) {
       Optional<Customer> result = repository.findById(id);
       if (result.isEmpty()) {
           throw new CustomerNotFound("Invalid customer ID");
       }
       return CustomerTransformer.customerToResponse(result.get());
   }
//
   // Find customers by gender
   public List<CustomerResponse> findByGender(Gender gender) {
       List<Customer> customers = repository.findByGender(gender);
       if (customers.isEmpty()) {
           throw new CustomerNotFound("No customers found with the specified gender");
       }
//
       List<CustomerResponse> responses = new ArrayList<>();
       customers.forEach(customer -> responses.add(CustomerTransformer.customerToResponse(customer)));
       return responses;
   }
//
   // Find customers by gender and age
   public List<CustomerResponse> genderAge(Gender gender, int age) {
       List<Customer> customers = repository.findByGenderAndAge(gender, age);
       if (customers.isEmpty()) {
           throw new CustomerNotFound("No customers found with the specified gender and age");
       }

       List<CustomerResponse> responses = new ArrayList<>();
       customers.forEach(customer -> responses.add(CustomerTransformer.customerToResponse(customer)));
       return responses;
   }

   // Find customers with greater age or specific gender
   public List<CustomerResponse> findGreaterAgeOrGender(int age, String gender) {
       List<Customer> customers = repository.findGreterAgeOrGender(age, gender);
       if (customers.isEmpty()) {
           throw new CustomerNotFound("No customers found with the specified age or gender");
       }

       List<CustomerResponse> responses = new ArrayList<>();
       customers.forEach(customer -> responses.add(CustomerTransformer.customerToResponse(customer)));
       return responses;
   }
}
