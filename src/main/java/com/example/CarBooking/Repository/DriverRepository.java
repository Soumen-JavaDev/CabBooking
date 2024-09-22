package com.example.CarBooking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.CarBooking.Model.Driver;
@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer>{
     @Query(value = "select * from driver where car_Id =:carId",nativeQuery = true)
    Driver getBycarid(@Param("carId")int carId);
    
}
