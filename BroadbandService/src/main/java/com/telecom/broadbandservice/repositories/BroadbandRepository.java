package com.telecom.broadbandservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.broadbandservice.entities.Broadband;

public interface BroadbandRepository extends JpaRepository<Broadband,Integer> {
	
	public Broadband getBroadbandByPrice(int price);
	
}
