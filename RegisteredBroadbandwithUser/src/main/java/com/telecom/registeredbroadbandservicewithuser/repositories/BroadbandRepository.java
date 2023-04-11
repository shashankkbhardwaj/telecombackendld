package com.telecom.registeredbroadbandservicewithuser.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecom.registeredbroadbandservicewithuser.entities.RegBroadband;

public interface BroadbandRepository extends JpaRepository<RegBroadband,Integer> {
	
	List<RegBroadband> findByMobNo(long mobNo);
	
}
