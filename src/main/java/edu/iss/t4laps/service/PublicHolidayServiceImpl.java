package edu.iss.t4laps.service;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.t4laps.model.PublicHolidays;
import edu.iss.t4laps.repository.PublicHolidayRepository;


@Service
public class PublicHolidayServiceImpl implements PublicHolidayService {

	@Resource
	private PublicHolidayRepository PublicHolidayRepository;
	
	@Override
	@Transactional
	public ArrayList<PublicHolidays> findAllHoliday() {
		ArrayList<PublicHolidays> ul = (ArrayList<PublicHolidays>) PublicHolidayRepository.findAll();
		return ul;
	}

	@Override
	@Transactional
	public PublicHolidays findPublicHoliday(Date holiday_date) {
		return PublicHolidayRepository.findPublicHoliday(holiday_date);
	}

	@Override
	@Transactional
	public PublicHolidays createPublicHoliday(PublicHolidays PublicHoliday) {
		return PublicHolidayRepository.saveAndFlush(PublicHoliday);
	}

	@Override
	@Transactional
	public PublicHolidays changePublicHoliday(PublicHolidays PublicHoliday) {
		return PublicHolidayRepository.saveAndFlush(PublicHoliday);
	}

	@Override
	@Transactional
	public void removePublicHoliday(PublicHolidays PublicHoliday) {
		PublicHolidayRepository.delete(PublicHoliday);

	}

	@Override
	@Transactional
	public ArrayList<String> findAllPublicHoldiayOcasion() {
		return PublicHolidayRepository.findAllPublicHoldiayOcasion();
	}

	@Override
	@Transactional
	public PublicHolidays findPublicHoldiayByOcasion(String ocasion) {
		return PublicHolidayRepository.findPublicHoldiayByOcassion(ocasion);
	}

}
