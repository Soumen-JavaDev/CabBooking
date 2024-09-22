package com.example.CarBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.CarBooking.Model.Cab;
@Repository
public interface CabRepository extends JpaRepository<Cab,Integer>{

      @Query(value="SELECT * FROM cab WHERE available =true ORDER BY RAND() LIMIT 1",nativeQuery = true)
    Cab getAvailableCarRandomly();
}
