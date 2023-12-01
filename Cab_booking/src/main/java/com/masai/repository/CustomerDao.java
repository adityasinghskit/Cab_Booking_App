package com.masai.repository;



import com.masai.entity.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.masai.entity.Customer;

import java.util.Optional;


@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer>{
    Optional<Customer> findByCustomerId(String customerId);
}


