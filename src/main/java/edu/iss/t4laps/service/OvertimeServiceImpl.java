package edu.iss.t4laps.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.t4laps.model.Overtime;
import edu.iss.t4laps.repository.OvertimeRespository;

@Service
public class OvertimeServiceImpl implements OvertimeService{

	@Resource
	private OvertimeRespository otRepository;
	
	@Override
	@Transactional
	public Overtime createOvertime(Overtime overtime) {
		return otRepository.saveAndFlush(overtime);
	}

	@Override
	@Transactional
	public ArrayList<Overtime> findAllOvertime() {
		ArrayList<Overtime> list = (ArrayList<Overtime>) otRepository.findAll();
		return list;
	}

	@Override
	@Transactional
	public Overtime findOvertime(int overtimeId) {
		return otRepository.findOne(overtimeId);
	}

	@Override
	@Transactional
	public void removeOvertime(Overtime overtime) {
		otRepository.delete(overtime);
		
	}

	@Override
	@Transactional
	public Overtime changeOvertime(Overtime overtime) {
		return otRepository.saveAndFlush(overtime);
	}

}
