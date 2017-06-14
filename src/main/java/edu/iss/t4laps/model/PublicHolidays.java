package edu.iss.t4laps.model;


//import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="public_holidays")


public class PublicHolidays{
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yy")
	private Date holiday_date;
	private String occasion;
	public Date getHoliday_date() {
		return holiday_date;
	}
	public void setHoliday_date(Date holiday_date) {
		this.holiday_date = holiday_date;
	}
	public String getOccasion() {
		return occasion;
	}
	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
	public PublicHolidays(Date holiday_date, String occasion) {
		super();
		this.holiday_date = holiday_date;
		this.occasion = occasion;
	}
	
	public PublicHolidays()
	{
		
	}
	

}
