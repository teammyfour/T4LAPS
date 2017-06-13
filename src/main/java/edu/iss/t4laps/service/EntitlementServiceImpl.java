package edu.iss.t4laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.iss.t4laps.model.LeaveEntitlement;
import edu.iss.t4laps.repository.EntitlementRepository;

@Service
public class EntitlementServiceImpl implements EntitlementService {

	@Resource
	private EntitlementRepository enRepository;
	
	@Override
	public LeaveEntitlement createEntilement(LeaveEntitlement entitlement) {
		return enRepository.saveAndFlush(entitlement);
	}

	@Override
	public ArrayList<LeaveEntitlement> findAllEntitlements() {
		ArrayList<LeaveEntitlement> list = (ArrayList<LeaveEntitlement>) enRepository.findAll();
		return list;
	}

	@Override
	public LeaveEntitlement findEntitlement(String designation) {
		return enRepository.findOne(designation);
	}

	@Override
	public void removeEntitlement(LeaveEntitlement entitlement) {
		enRepository.delete(entitlement);
		
	}

	@Override
	public LeaveEntitlement changeEntitlement(LeaveEntitlement entitlement) {
		return enRepository.saveAndFlush(entitlement);
	}

}
