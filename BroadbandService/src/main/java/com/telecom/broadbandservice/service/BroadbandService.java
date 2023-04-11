package com.telecom.broadbandservice.service;

import java.util.List;

import com.telecom.broadbandservice.entities.Broadband;

public interface BroadbandService {
	
	
	List<Broadband> getallBroadbands();
	
	Broadband getBroadbandByPrice(int price);
	
	Broadband addBroadband(Broadband broadband);
	
	Broadband deleteBreoadbandById(int price);
	
	Broadband updateBroadband(Broadband broadband, int price);
}
