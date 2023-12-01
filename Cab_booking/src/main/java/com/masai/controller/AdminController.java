package com.masai.controller;



import java.time.LocalDate;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Admin;
import com.masai.entity.Cab;
import com.masai.entity.TripBooking;
import com.masai.service.AdminService;
@RestController
//@RequestMapping("/api/admin")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/")
	public ResponseEntity<Admin> insertAdminHandler(@RequestBody Admin admin) {
		Admin savedAdmin = adminService.saveAdmin(admin);
		return ResponseEntity.ok(savedAdmin);
	}
	
	@GetMapping("/")
	public Admin deleteMappingHandler1() {
		
		return null;
	}
	
	@DeleteMapping("/{adminId}")
	public ResponseEntity<Admin> deleteMappingHandler(@PathVariable("adminId") Integer adminId) {
		Admin returnAdmin = adminService.delete(adminId); 
		return ResponseEntity.ok(returnAdmin);
	}
	
	@GetMapping("/trips/{customerId}")
	public ResponseEntity<List<TripBooking>>  getAllTripsHandler(@PathVariable("customerId") Integer customerId){
		
		List<TripBooking> trips= adminService.getAllTrips(customerId);
		return ResponseEntity.ok(trips);
	}
	
	@GetMapping("trips/{cab}")
	public ResponseEntity<List<TripBooking>> getTripsDriverwiseHandler(@RequestBody Cab cab){
		
		List<TripBooking> trips= adminService.getTripsDriverwise();
		return ResponseEntity.ok(trips);
	}
	
	
	@PutMapping("/")
	public ResponseEntity<String> updateAdminHandler(@RequestBody Admin admin) {
		Admin updatedAdmin = adminService.update(admin);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("admin updated "+updatedAdmin);
	}
	
	
	
	
	@GetMapping("/customertrips")
	public List<TripBooking> getTripsCustomerwiseHandler(){
		return adminService.getTripsCustomerwise();
	}
	
	@GetMapping("/datewisetrips")
	public List<TripBooking> getTripsDatewiseHandler(){
		return adminService.getTripsDatewise();
	}
	
	@GetMapping("trips/{customerId}/{date}")
	public List<TripBooking> getTripsDatewiseAndCustomerHandler(@PathVariable("customerId") String customerId, @PathVariable("date") Date date){
		return adminService.getTripsDatewiseAndCustomer(customerId, date);

	}
}
