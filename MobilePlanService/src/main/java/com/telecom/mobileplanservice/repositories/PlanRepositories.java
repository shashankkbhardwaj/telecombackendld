package com.telecom.mobileplanservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.mobileplanservice.entities.Plan;

public interface PlanRepositories extends JpaRepository<Plan, Integer> {

}
