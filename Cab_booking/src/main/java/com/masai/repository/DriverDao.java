package com.masai.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.entity.Driver;
@Repository
public interface DriverDao extends JpaRepository<Driver,Integer> {
	@Query("from Driver d where d.rating>=4.5 AND d.available=true")
	public List<Driver> viewBestDriver();

	Optional<Driver> findByDriverId(String driverId);
	
//	@Query("from Driver d where cab")
//	public Optional<Driver> findByCabId(Integer cabId);
}
