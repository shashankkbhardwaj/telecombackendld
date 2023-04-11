package com.telecom.mobileplanservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.telecom.mobileplanservice.entities.Plan;
import com.telecom.mobileplanservice.exceptions.ResourceNotFoundException;
import com.telecom.mobileplanservice.repositories.PlanRepositories;

@Service
public class PlanServiceImpl implements PlanService{
	
	@Autowired
	private PlanRepositories planRepositories;

	@Override
	public List<Plan> getAllPlan() {
		
		List<Plan> plans = planRepositories.findAll(Sort.by(Sort.Direction.ASC, "price"));
		return plans;
	}

	@Override
	public Plan getPlanById(int id) {

		Plan plan = planRepositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found on server: " + id));
		return plan;
	}

	@Override
	public Plan addPlan(Plan plan) {
		
		Plan planAdd = planRepositories.save(plan);
		return planAdd;
	}

	@Override
	public Plan updatePlan(Plan plan, int id) {
		plan.setId(id);
		return planRepositories.save(plan);
	}

	@Override
	public Plan deletePlan(int id) {
		
		Plan plan = planRepositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found on server: " + id));
		planRepositories.deleteById(id);
		return plan;
	}
	
	

}
