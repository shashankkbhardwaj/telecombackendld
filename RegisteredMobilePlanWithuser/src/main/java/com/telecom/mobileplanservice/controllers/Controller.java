package com.telecom.mobileplanservice.controllers;

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

import com.telecom.mobileplanservice.entities.RegPlan;
import com.telecom.mobileplanservice.services.PlanService;

@RestController
@RequestMapping("/regplan")
@CrossOrigin("http://localhost:3000/")
public class Controller {
	
	@Autowired
	private PlanService planService;

	@GetMapping("/all/{mobNo}")
	public ResponseEntity<List<RegPlan>> getAllplanByMobNo(@PathVariable long mobNo){
		List<RegPlan> plan = planService.getAllPlanByMobNo(mobNo);
		
		return ResponseEntity.ok(plan);
	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<Plan> getPlanById(@PathVariable int id){
//		Plan plan = planService.getPlanById(id);
//		
//		return ResponseEntity.status(HttpStatus.FOUND).body(plan);
//	}
	
	
	@PostMapping
	public ResponseEntity<RegPlan> addPlan(@RequestBody RegPlan plan){
		
		if(plan.getMobNo()>=1000000000) {
		RegPlan addPlan = planService.addPlan(plan);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addPlan);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<Plan> updatePlan(@RequestBody Plan plan, @PathVariable int id){
//		Plan updatedPlan = planService.updatePlan(plan, id);
//		
//		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedPlan);
//	}
	
	
	
}
