package com.example.CarBooking.Repository;

import com.example.CarBooking.Enum.Gender;
import com.example.CarBooking.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
     List<Customer> findByGender(Gender val);
   List<Customer> findByGenderAndAge(Gender gender,int age);
   
/*HQL Query
 @Query("select c from Customer c where c.age >:age and  c.gender = :gender")// Hibernate Query Lenguage (HQL)
List<Customer> findGreterAgeOrGender(@Param("age")int age,@Param("gender") Gender gender);
*/
//SQL Query
@Query(value = "SELECT * FROM customer WHERE age > :age AND gender = :gender", nativeQuery = true)

List<Customer> findGreterAgeOrGender(@Param("age")int age,@Param("gender") String gender);

}
