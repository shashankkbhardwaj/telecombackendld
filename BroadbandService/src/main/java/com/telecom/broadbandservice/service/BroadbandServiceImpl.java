package com.telecom.broadbandservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.broadbandservice.entities.Broadband;
import com.telecom.broadbandservice.exceptions.ResourceNotFoundException;
import com.telecom.broadbandservice.repositories.BroadbandRepository;

@Service
public class BroadbandServiceImpl  implements BroadbandService{
	
	
	@Autowired
	private BroadbandRepository broadbandRepository;

	@Override
	public List<Broadband> getallBroadbands() {
		// TODO Auto-generated method stub 
				List<Broadband> broadband =	broadbandRepository.findAll();
				return broadband;
	}

	@Override
	public Broadband getBroadbandByPrice(int price) {
		return broadbandRepository.findById(price).orElseThrow(() -> new ResourceNotFoundException("Plan with given price is not found on server" + price));
	}

	@Override
	public Broadband addBroadband(Broadband broadband) {
		return broadbandRepository.save(broadband);
	}

	@Override
	public Broadband deleteBreoadbandById(int price) {
		Broadband broadband = broadbandRepository.findById(price).orElseThrow(() -> new ResourceNotFoundException("Plan with given price is not found on server" + price));
		broadbandRepository.deleteById(price);
		return broadband;
	}

	@Override
	public Broadband updateBroadband(Broadband broadband, int price) {
		broadbandRepository.findById(price).orElseThrow(() -> new ResourceNotFoundException("Plan with given price is not found on server" + price));
		broadband.setPrice(price);
		return broadbandRepository.save(broadband);
	}

}
