package com.telecom.registeredbroadbandservicewithuser.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.registeredbroadbandservicewithuser.entities.RegBroadband;
import com.telecom.registeredbroadbandservicewithuser.exceptions.ResourceNotFoundException;
import com.telecom.registeredbroadbandservicewithuser.repositories.BroadbandRepository;

@Service
public class BroadbandServiceImpl  implements BroadbandService{
	
	
	@Autowired
	private BroadbandRepository broadbandRepository;

	@Override
	public List<RegBroadband> getallBroadbandByMobNo(long mobNo) {
		// TODO Auto-generated method stub 
				List<RegBroadband> broadband =	broadbandRepository.findByMobNo(mobNo);
				return broadband;
	}
//
//	@Override
//	public Broadband getBroadbandByMobNo(int price) {
//		return broadbandRepository.findById(price).orElseThrow(() -> new ResourceNotFoundException("Plan with given price is not found on server" + price));
//	}

	@Override
	public RegBroadband addBroadband(RegBroadband broadband) {
		
		broadband.setActivationDate(LocalDate.now());
		int add = broadband.getValidity();
		broadband.setExpirationDate(LocalDate.now().plusDays(add));
		RegBroadband planAdd = broadbandRepository.save(broadband);

		
		return planAdd;
	}

//	@Override
//	public Broadband deleteBreoadbandById(int price) {
//		Broadband broadband = broadbandRepository.findById(price).orElseThrow(() -> new ResourceNotFoundException("Plan with given price is not found on server" + price));
//		broadbandRepository.deleteById(price);
//		return broadband;
//	}

//	@Override
//	public Broadband updateBroadband(Broadband broadband, int price) {
//		broadbandRepository.findById(price).orElseThrow(() -> new ResourceNotFoundException("Plan with given price is not found on server" + price));
//		broadband.setPrice(price);
//		return broadbandRepository.save(broadband);
//	}

}
