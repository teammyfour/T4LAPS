package edu.iss.t4laps.repository;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.t4laps.model.LeaveHistory;

public interface LeaveHistoryRepository extends JpaRepository<LeaveHistory, Integer>{
	
	
	@Query("SELECT COUNT(p.holiday_date) from PublicHolidays p WHERE p.holiday_date BETWEEN :stDate AND :edDate")
	int findDates(@Param("stDate") Date stDate,@Param("edDate")Date edDate);
	@Query("SELECT l FROM LeaveHistory l WHERE l.employeeId=:empid")
	ArrayList<LeaveHistory> findAll(@Param("empid") int empid);
	@Query("SELECT l FROM LeaveHistory l WHERE l.leaveId=:leaveid")
	LeaveHistory findEditLeaveDetails(@Param("leaveid") int leaveid);
	@Query("SELECT e.emp_name FROM EmployeeDetails e WHERE e.employeeId=(select l.employeeId from LeaveHistory l where l.leaveId=:leaveid)")
	String findEmpName(@Param("leaveid") int leaveid);
	@Modifying
	@Query("UPDATE LeaveHistory l set l.employeeId=:empid,l.leavetype=:leaveType,l.startDate=:sDate,l.endDate=:eDate,l.reason=:reason,l.status=:status,l.number_of_days=:workingdays  where l.leaveId=:leaveid")
	int updateLeaveHistory(@Param("empid") int empid,@Param("leaveType") String leaveType,@Param("sDate") Date sDate,@Param("eDate") Date eDate,@Param("reason") String reason,@Param("status") String status,@Param("leaveid") int leaveid,@Param("workingdays") int workingdays);
	@Modifying
	@Query("UPDATE LeaveHistory l set l.status =:status where l.leaveId =:leaveid")
	int updateStatus(@Param("status") String status,@Param("leaveid") int leaveid);
	@Query("SELECT e.email_address from EmployeeDetails e where e.employeeId=(SELECT e.managerId from EmployeeDetails e where e.employeeId=:empid)")
	String findEmailId(@Param("empid") int empid);
	@Query("SELECT  COALESCE(SUM(l.number_of_days),0) FROM LeaveHistory l where l.employeeId=:empid AND l.leavetype=:leaveType AND l.status='APPROVED'")
	int findTotalDays(@Param("empid") int empid,@Param("leaveType") String leaveType);
	@Query("SELECT le.annual_leave from LeaveEntitlement le where le.designation=(SELECT e.designation FROM EmployeeDetails e WHERE e.employeeId=:empid)")
	int findAnualWorkingDays(@Param("empid")int empid);
	@Query("SELECT le.medical_leave from LeaveEntitlement le where le.designation=(SELECT e.designation FROM EmployeeDetails e WHERE e.employeeId=:empid)")
	int findMedicalWorkingDays(@Param("empid") int empid);
	@Query("SELECT l from LeaveHistory l WHERE l.employeeId=:empid AND (l.status='SUBMITTED'OR l.status='UPDATED')")
	ArrayList<LeaveHistory> findSubmittedLeaveHistoryByEID(@Param("empid") int empid);
	@Query("SELECT e.email_address from EmployeeDetails e where e.employeeId=:empid)")
	String findEmpEmailId(@Param("empid") int empid);

	
	
	
	
}