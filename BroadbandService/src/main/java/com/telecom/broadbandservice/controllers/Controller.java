package com.telecom.broadbandservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telecom.broadbandservice.entities.Broadband;
import com.telecom.broadbandservice.service.BroadbandService;

@RestController
@RequestMapping("/broadband")
@CrossOrigin("http://localhost:3000/")
public class Controller {
	
	@Autowired
	private BroadbandService broadbandServices;
	
	@GetMapping("/all")
	public ResponseEntity<List<Broadband>> getallBroadband(){
		List<Broadband> all = broadbandServices.getallBroadbands();
		return ResponseEntity.ok(all);
	}
	
	
	@GetMapping("/{price}")
	public ResponseEntity<Broadband> getBroadbandByPrice(@PathVariable int price){
		Broadband broadband = broadbandServices.getBroadbandByPrice(price);
		return ResponseEntity.ok(broadband);
	}
	
	@PostMapping
	public ResponseEntity<Broadband> addBroadband(@RequestBody Broadband broadband){
		Broadband broadbandAdd = broadbandServices.addBroadband(broadband);
		return ResponseEntity.status(HttpStatus.CREATED).body(broadbandAdd);
	}
	
	@PutMapping("/{price}")
	public ResponseEntity<Broadband> updateBroadband(@PathVariable int price, @RequestBody Broadband broadband){
		Broadband broadbandUpdate = broadbandServices.updateBroadband(broadband, price);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(broadbandUpdate);
	}

}
