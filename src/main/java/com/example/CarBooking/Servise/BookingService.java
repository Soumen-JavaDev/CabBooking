package com.example.CarBooking.Servise;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.CarBooking.DTO.Request.BookingRequest;
import com.example.CarBooking.DTO.Respons.BookingResponse;
import com.example.CarBooking.Excption.CabNotFound;
import com.example.CarBooking.Excption.CustomerNotFound;
import com.example.CarBooking.Model.Booking;
import com.example.CarBooking.Model.Cab;
import com.example.CarBooking.Model.Customer;
import com.example.CarBooking.Model.Driver;
import com.example.CarBooking.Repository.BookingRepository;
import com.example.CarBooking.Repository.CabRepository;
import com.example.CarBooking.Repository.CustomerRepository;
import com.example.CarBooking.Repository.DriverRepository;
import com.example.CarBooking.Transformer.BookingTransformer;
@Service
public class BookingService {
  @Autowired
  CustomerRepository cRepo;

  @Autowired
  CabRepository carrepo;

  @Autowired
  DriverRepository driverrepo;

  @Autowired 
  BookingRepository bookingrepo;

  @Autowired 
  private JavaMailSender mailSender;

    public BookingResponse bookCar(BookingRequest book, int id) throws Exception {
     Optional<Customer> optionalCustomer =cRepo.findById(id);
     if(optionalCustomer.isEmpty()){
      throw new CustomerNotFound("id not found");
     }
     Customer customer=optionalCustomer.get();
     Cab availableCar=carrepo.getAvailableCarRandomly();
     if(availableCar==null)
      throw new CabNotFound("Sorry! no car available");

      Booking boking=BookingTransformer.requestToBooking(book, availableCar.getPerKmRate());
      Booking saveBooking=bookingrepo.save(boking); 
      availableCar.setAvailable(false);
       customer.getBooking().add(saveBooking);

       Driver driver=driverrepo.getBycarid(availableCar.getCabId());
       driver.getBookings().add(saveBooking);
      Customer savCustomer=cRepo.save(customer);
      Driver saveDriver=driverrepo.save(driver);
      // sendSimpleMessage(savCustomer.getEmail(),"bookin confirmation", "successfully book your trekit");
      sendBookingConfirmation(savCustomer);

      return BookingTransformer.responsBooking(saveBooking, savCustomer, availableCar, saveDriver);

    }


    // public void sendSimpleMessage (
    //   String to, String subject, String text) throws Exception{
        
    //     SimpleMailMessage message = new SimpleMailMessage(); 
    //     message.setFrom("mathur.kultuka@gmail.com");
    //     message.setTo("soumenmondal7584@gmail.com"); 
    //     message.setSubject(subject); 
    //     message.setText(text);
    //     mailSender.send(message);
      
    // }

    private void sendBookingConfirmation(Customer customer) {
      if (customer.getEmail() == null) {
        System.out.println("Customer email is not available, cannot send confirmation.");
        return;
    }

    try {
        String message = "Dear " + ",\n\nYour booking was successfully confirmed!";
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("mathur.kultuka@gmail.com");
        mail.setTo("soumenmondal7584@gmail.com");
        mail.setSubject("Booking Confirmation");
        mail.setText(message);

        mailSender.send(mail); // Sending email

        System.out.println("Booking confirmation email sent to " + customer.getEmail());
    } catch (Exception e) {
        System.out.println("Failed to send booking confirmation email: " + e.getMessage());
       
    }

    }
  }



