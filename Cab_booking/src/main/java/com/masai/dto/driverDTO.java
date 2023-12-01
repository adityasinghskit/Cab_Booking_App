package com.masai.dto;

import javax.persistence.Entity;


import com.masai.entity.Address;
import com.masai.entity.Cab;
import com.masai.entity.TripBooking;
import lombok.Data;


@Data
public class driverDTO {
	
	private Integer userId;
	
	private String Username;
	
	private String Mobile;
	
	private Address address;
	
	private String Email;
	
	private Integer licenseNo;
	
	private Double rating;
	
	private Boolean available;

	
	private Cab cab;

	private TripBooking tripBooking;
}
