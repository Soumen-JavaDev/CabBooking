package com.example.CarBooking.Model;

import com.example.CarBooking.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private int age;

    @Column(unique = true ,nullable = false)
    private String name;

    private String mobNo;

    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookin_id")
    @Builder.Default
    List<Booking> booking=new ArrayList<>();

}
