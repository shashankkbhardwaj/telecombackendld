package com.telecom.mobileplanservice.services;

import java.util.List;

import com.telecom.mobileplanservice.entities.Plan;

public interface PlanService {
	
	
	//get list of all plan
	List<Plan> getAllPlan();
	
	//get plan by id
	Plan getPlanById(int id);
	
	//add a new plan
	Plan addPlan(Plan plan);
	
	// update the existing plan
	Plan updatePlan(Plan plan , int id);
	
	//delete particular plan by id
	Plan deletePlan(int id);

}
