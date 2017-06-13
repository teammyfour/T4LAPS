package edu.iss.t4laps.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import edu.iss.t4laps.model.LeaveEntitlement;

@Service
public interface EntitlementService {
	LeaveEntitlement createEntilement(LeaveEntitlement entitlement);
	
	ArrayList<LeaveEntitlement> findAllEntitlements();
	
	LeaveEntitlement findEntitlement(String designation);
	
	void removeEntitlement(LeaveEntitlement entitlement);

	LeaveEntitlement changeEntitlement(LeaveEntitlement entitlement);
}

