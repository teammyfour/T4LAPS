package edu.iss.t4laps.service;

import java.sql.Date;
import java.util.ArrayList;

import edu.iss.t4laps.model.LeaveHistory;

public interface LeaveHistoryService {
	
	public LeaveHistory insertLeave(LeaveHistory leavehistory);
	public int findDates(Date startDate,Date endDate);
	public ArrayList<LeaveHistory> findAll(int empId);
	public LeaveHistory findEditLeaveDetails(int leaveId);
	public String findEmpName(int leaveId);
	public int updateLeaveHistory(int leaveId,int empId,String leavetype,Date sDate,Date eDate,String reason,String status,int workingDays);
	public int updateStatus(int leaveId,String status);
	public String findEmailId(int empId);
	public int findTotalDays(int empId,String leaveType);
	public int findAnualWorkingDays(int empid);

}
