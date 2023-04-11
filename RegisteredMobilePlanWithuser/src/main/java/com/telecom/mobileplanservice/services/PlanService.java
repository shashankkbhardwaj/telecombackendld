package com.telecom.mobileplanservice.services;

import java.util.List;

import com.telecom.mobileplanservice.entities.RegPlan;

public interface PlanService {
	
	
	
	//get list of all plan
	List<RegPlan> getAllPlanByMobNo(long mobNo);
	
//	//get plan by id
//	Plan getPlanById(int id);
	
	//add a new plan
	RegPlan addPlan(RegPlan plan);
	
//	// update the existing plan
//	Plan updatePlan(Plan plan , int id);
	
	//delete particular plan by id
	RegPlan deletePlan(int id);

}
