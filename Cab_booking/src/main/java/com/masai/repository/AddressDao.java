package com.masai.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.entity.Address;

import java.util.Optional;

public interface AddressDao extends JpaRepository<Address, Integer> {
    Optional<Address> findByAddressId(String addressId);
}
