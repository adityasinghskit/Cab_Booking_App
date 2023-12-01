package com.masai.controller;

import java.util.List;

import com.masai.enums.CabType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.masai.entity.Cab;
import com.masai.service.CabService;

@RestController
//@RequestMapping("/api")
public class CabController {
	
	@Autowired
	private CabService cService;
	
	@PutMapping("/cabs")
    public ResponseEntity<Cab> updateCabHandler(@RequestParam Integer id,
									@RequestParam CabType type,
									@RequestParam Integer rate)
    {
		
		Cab updatedCab = cService.updateCab(id,type,rate);
		return new ResponseEntity<Cab>(updatedCab,HttpStatus.ACCEPTED);
		
    	
		
    }
	
	@GetMapping("/cabs")
	public ResponseEntity<?> viewCabsHandler()
	{
		
		List<CabType> cabs = cService.viewCabsOfType();
		
        return ResponseEntity.ok(cabs);
		
	}
	@GetMapping("/cabsCount")
     public String countCabsOfType()
     {
    	int countCab = cService.countCabsOfType();
    	
    	return "Number of Cabs Abvailable " + countCab;
     }
	
	
}
