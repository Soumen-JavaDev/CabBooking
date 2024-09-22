package com.example.CarBooking.controller;

import com.example.CarBooking.DTO.Request.CustomerRequest;
import com.example.CarBooking.DTO.Respons.CustomerResponse;
import com.example.CarBooking.Enum.Gender;
import com.example.CarBooking.Servise.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService service; 

    // Endpoint to add a customer
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerRequest customer) {
        CustomerResponse response = service.addCustomer(customer); 
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

   // Find customer by ID
   @GetMapping("/find/customer/{id}")
   public ResponseEntity<CustomerResponse> findById(@PathVariable("id") int id) { 
       CustomerResponse response = service.findId(id);
       return new ResponseEntity<>(response, HttpStatus.OK);
   }

   // Find customers by gender
   @GetMapping("/gender")
   public List<CustomerResponse> findByGender(@RequestParam("Gender") Gender gender) {
       return service.findByGender(gender);
   }

   // Find customers by gender and age
   @GetMapping("/findByGenderAndAge") 
   public List<CustomerResponse> findByGenderAndAge(@RequestParam("Gender") Gender gender, @RequestParam("age") int age) {
       return service.genderAge(gender, age);
   }

   // Find by greater age or gender
   @GetMapping("/findByAgeOrGender")
   public List<CustomerResponse> findGreaterAgeOrGender(@RequestParam("age") int age, @RequestParam("gender") String gender) {
       return service.findGreaterAgeOrGender(age, gender);
   }
}