package com.telecom.registeredbroadbandservicewithuser.service;

import java.util.List;

import com.telecom.registeredbroadbandservicewithuser.entities.RegBroadband;

public interface BroadbandService {
	
	
	List<RegBroadband> getallBroadbandByMobNo(long mobNo);
	
//	Broadband getBroadbandByMobNo(int mobNo);
	
	RegBroadband addBroadband(RegBroadband broadband);
	
//	Broadband deleteBreoadbandById(int price);
//	
//	Broadband updateBroadband(Broadband broadband, int price);
}
