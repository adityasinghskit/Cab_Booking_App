package com.masai.controller;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Admin;
import com.masai.entity.TripBooking;
import com.masai.service.AdminService;
@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> insertAdmin(@RequestBody Admin admin) {
		Admin savedAdmin = adminService.saveAdmin(admin);
		return new ResponseEntity<Admin>(savedAdmin,HttpStatus.OK);
	}
	
	
	@PutMapping("/admin")
	public ResponseEntity<String> updateAdmin(@RequestBody Admin admin) {
		Admin updatedAdmin = adminService.update(admin);
		return new ResponseEntity<String>("admin updated "+updatedAdmin,HttpStatus.ACCEPTED); 
	}
	
	@DeleteMapping("/admin/{adminId}")
	public String deleteMapping(@PathVariable("adminId") int adminId) {
		Admin deletedAdmin = adminService.delete(adminId);
		return "admin deleted "+deletedAdmin;
	}
	
	@GetMapping("/trips/{customerId}")
	public ResponseEntity<List<TripBooking>> getAllTrips(@PathVariable("customerId") int customerId){
		List<TripBooking> list = adminService.getAllTrips(customerId);
		return new ResponseEntity<List<TripBooking>>(list,HttpStatus.OK);
	}
	
	//This one Not done :
	@GetMapping("cabwisetrips")
	public List<TripBooking> getTripsCabwise(){
		List<TripBooking> list = new ArrayList<>();
		return list;
	}
	
	@GetMapping("/customertrips")
	public List<TripBooking> getTripsCustomerwise(){
		List<TripBooking> list = adminService.getTripsCustomerwise();
		return list;
	}
	
	@GetMapping("/datewisetrips")
	public List<TripBooking> getTripsDatewise(){
		List<TripBooking> list = adminService.getTripsDatewise();
		return list;
	}
	
	@GetMapping("trips/{customerId}/{date}")
	public List<TripBooking> getTripsDatewiseAndCustomer(@PathVariable("customerId") Integer customerId, @PathVariable("date") LocalDate date){
		List<TripBooking> list = adminService.getTripsDatewiseAndCustomer(customerId, date);
		return list;
	}
}
