package com.masai.controller;



import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Admin;
import com.masai.entity.TripBooking;
import com.masai.service.AdminServiceImp;
@RestController
public class AdminController {
	@Autowired
	private AdminServiceImp adminService;
	
	@PostMapping("/admin")
	public Admin insertAdmin(@RequestBody Admin admin) {
		return adminService.saveAdmin(admin);
	}
	
	
	@PutMapping("/admin/{adminId}")
	public String updateAdmin(@RequestBody Admin admin, @PathVariable("adminId") int adminId) {
		return "admin updated "+admin; 
		
	}
	
	@DeleteMapping("/admin/{adminId}")
	public String deleteMapping(@PathVariable("adminId") int adminId) {
		return "admin deleted";
	}
	
	@GetMapping("/trips/{customerId}")
	public List<TripBooking> getAllTrips(@PathVariable("customerId") int customerId){
		List<TripBooking> list = new ArrayList<>();
		return list;
	}
	
	@GetMapping("trips/{cabId}")
	public List<TripBooking> getTripsCabwise(@PathVariable("cabId") int cabId){
		List<TripBooking> list = new ArrayList<>();
		return list;
	}
	
	@GetMapping("trips/{customerId}")
	public List<TripBooking> getTripsCustomerwise(@PathVariable("customerId") int customerId){
		List<TripBooking> list = new ArrayList<>();
		return list;
	}
	
	@GetMapping("trips/{date}")
	public List<TripBooking> getTripsDatewise(@PathVariable("date") LocalDateTime date){
		List<TripBooking> list = new ArrayList<>();
		return list;
	}
	
	@GetMapping("trips/{customerId}/{fromDate}/{toDate}")
	public List<TripBooking> getAllTripsForDays(@PathVariable("customerId") int customerId, @PathVariable("fromDate") LocalDateTime fromDate, @PathVariable("toDate") LocalDateTime toDate){
		List<TripBooking> list = new ArrayList<>();
		return list;
	}
}
