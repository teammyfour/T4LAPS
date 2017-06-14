package edu.iss.t4laps.service;

import java.sql.Date;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.t4laps.model.LeaveHistory;
import edu.iss.t4laps.repository.LeaveHistoryRepository;

@Service

public class LeaveHistoryServiceImpl implements LeaveHistoryService {

	@Resource
	private LeaveHistoryRepository leavehistoryRepository;

	@Override
	@Transactional
	public LeaveHistory insertLeave(LeaveHistory leavehistory) {
		return leavehistoryRepository.saveAndFlush(leavehistory);
	}

	@Override
	@Transactional
	public int findDates(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return leavehistoryRepository.findDates(startDate, endDate);
	}

	@Override
	@Transactional
	public ArrayList<LeaveHistory> findAll(int empId) {
		// TODO Auto-generated method stub
		return leavehistoryRepository.findAll(empId);
	}

	@Override
	@Transactional
	public LeaveHistory findEditLeaveDetails(int leaveId) {
		// TODO Auto-generated method stub
		return leavehistoryRepository.findEditLeaveDetails(leaveId);
	}

	@Override
	@Transactional
	public String findEmpName(int leaveId) {
		// TODO Auto-generated method stub
		return leavehistoryRepository.findEmpName(leaveId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public int updateLeaveHistory(int leaveId, int empId, String leavetype, Date sDate, Date eDate, String reason,
			String status, int workingDays) {
		// TODO Auto-generated method stub
		return leavehistoryRepository.updateLeaveHistory(empId, leavetype, sDate, eDate, reason, status, leaveId,
				workingDays);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public int updateStatus(int leaveId, String status) {
		// TODO Auto-generated method stub
		return leavehistoryRepository.updateStatus(status, leaveId);
	}

	@Override
	public String findEmailId(int empId) {
		// TODO Auto-generated method stub
		return leavehistoryRepository.findEmailId(empId);
	}

	@Override
	public int findTotalDays(int empId, String leaveType) {
		// TODO Auto-generated method stub
		return leavehistoryRepository.findTotalDays(empId, leaveType);
	}

	@Override
	public int findAnualWorkingDays(int empid) {
		// TODO Auto-generated method stub
		return leavehistoryRepository.findAnualWorkingDays(empid);
	}

	@Override
	public int findMedicalWorkingDays(int empid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public LeaveHistory changeLeaveHistory(LeaveHistory leavehistory) {
		return leavehistoryRepository.saveAndFlush(leavehistory);
	}

	@Override
	@Transactional
	public ArrayList<LeaveHistory> findSubmittedLeaveHistoryByEID(int empid) {
		return leavehistoryRepository.findSubmittedLeaveHistoryByEID(empid);
	}

	@Override
	@Transactional
	public LeaveHistory findLeaveHistory(int id) {
		return leavehistoryRepository.findOne(id);
	}

}
