package com.telecom.mobileplanservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.mobileplanservice.entities.RegPlan;

public interface PlanRepositories extends JpaRepository<RegPlan, Integer> {

	
	List<RegPlan> findByMobNo(long mobNo);
}
