package com.telecom.registeredbroadbandservicewithuser.controllers;

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

import com.telecom.registeredbroadbandservicewithuser.entities.RegBroadband;
import com.telecom.registeredbroadbandservicewithuser.service.BroadbandService;

@RestController
@RequestMapping("/regbroadband")
@CrossOrigin("*")
public class Controller {
	
	@Autowired
	private BroadbandService broadbandServices;
	
	@GetMapping("/all/{mobNo}")
	public ResponseEntity<List<RegBroadband>> getallBroadbandByMobNO(@PathVariable long mobNo){
		List<RegBroadband> all = broadbandServices.getallBroadbandByMobNo(mobNo);
		return ResponseEntity.ok(all);
	}
	
	
//	@GetMapping("/{mobNo}")
//	public ResponseEntity<Broadband> getBroadbandByPrice(@PathVariable int mobNo){
//		Broadband broadband = broadbandServices.getBroadbandByMobNo(mobNo);
//		return ResponseEntity.ok(broadband);
//	}
	
	@PostMapping
	public ResponseEntity<RegBroadband> addBroadband(@RequestBody RegBroadband broadband){
		RegBroadband broadbandAdd = broadbandServices.addBroadband(broadband);
		return ResponseEntity.status(HttpStatus.CREATED).body(broadbandAdd);
	}
	
//	@PutMapping("/{price}")
//	public ResponseEntity<Broadband> updateBroadband(@PathVariable int price, @RequestBody Broadband broadband){
//		Broadband broadbandUpdate = broadbandServices.updateBroadband(broadband, price);
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(broadbandUpdate);
//	}

}
