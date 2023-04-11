package com.telecom.mobileplanservice.services;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.mobileplanservice.entities.RegPlan;
import com.telecom.mobileplanservice.exceptions.ResourceNotFoundException;
import com.telecom.mobileplanservice.repositories.PlanRepositories;

@Service
public class PlanServiceImpl implements PlanService{
	
	@Autowired
	private PlanRepositories planRepositories;
	
	class sortCompare implements Comparator<RegPlan>   
	{  
	    // Method of this class  
	    @Override  
	    public int compare(RegPlan a, RegPlan b)  
	    {  
	        /* Returns sorted data in ascending order */  
	        return b.getExpirationDate().compareTo(a.getExpirationDate());  
	    }  
	}
	

	@Override
	public List<RegPlan> getAllPlanByMobNo(long mobNo) {
		
		List<RegPlan> plans = planRepositories.findByMobNo(mobNo);
		 Collections.sort(plans, new sortCompare()); 
		return plans;
	}

//	@Override
//	public Plan getPlanById(int id) {
//
//		Plan plan = planRepositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found on server: " + id));
//		return plan;
//	}

	@Override
	public RegPlan addPlan(RegPlan plan) {
		
		
		plan.setActivationDate(LocalDate.now());
		int add = plan.getValidity();
		plan.setExpirationDate(LocalDate.now().plusDays(add));
		RegPlan planAdd = planRepositories.save(plan);

		
		return planAdd;
	}

//	@Override
//	public Plan updatePlan(Plan plan, int id) {
//		plan.setId(id);
//		return planRepositories.save(plan);
//	}

	@Override
	public RegPlan deletePlan(int id) {
		
		RegPlan plan = planRepositories.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found on server: " + id));
		planRepositories.deleteById(id);
		return plan;
	}
	
	

}
