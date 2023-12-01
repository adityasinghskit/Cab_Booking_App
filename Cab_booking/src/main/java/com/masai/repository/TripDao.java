package com.masai.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.entity.TripBooking;


@Repository
public interface TripDao extends JpaRepository<TripBooking,Integer> {
	@Query("from TripBooking order by CustomerId")
	public List<TripBooking> findByCustomerIdAsce();
	@Query("from TripBooking  order by fromDateTime")
	public List<TripBooking> findByFromDateTimeAsce();
	
	@Query("from TripBooking where CustomerId=:customerId AND fromDateTime=:date")
	public List<TripBooking> findByCustomerIdAndFromDateTime(String customerId, Date date);
	
	@Query("from TripBooking Group by DriverId")
	public List<TripBooking> findByDriverAscs();
}
