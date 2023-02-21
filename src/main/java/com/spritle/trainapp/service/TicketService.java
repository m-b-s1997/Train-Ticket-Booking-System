package com.spritle.trainapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spritle.trainapp.dao.TicketDao;
import com.spritle.trainapp.dto.Agent;
import com.spritle.trainapp.dto.Booking;
import com.spritle.trainapp.dto.CoachDto;
import com.spritle.trainapp.dto.SuperAdmin;

@Service
public class TicketService {

	@Autowired
	private TicketDao dao;

	public SuperAdmin saveSupadmin(SuperAdmin admin) {
		SuperAdmin admin1=new SuperAdmin();
		admin1.setEmail(admin.getEmail());
		admin1.setPassword(admin.getPassword());

		return dao.insertSupAdmin(admin1);
	}

	public Agent saveAgent(Agent agent) {
		
		return dao.insertAgent(agent);
	}

	public Agent deleteEmployee(int id) {
		Agent allAgent=dao.searchAgent(id);
		if (allAgent==null) {
			return null;
		}else {
			return dao.deleteEmployee(allAgent);
		}
	}

	public SuperAdmin getAllAdmin1(String email) {
		List<SuperAdmin> admin=dao.getAllAdmin();
		System.out.println("service get all"+admin);
		for (SuperAdmin admin2 : admin) {
			if (email.equals(admin2.getEmail())) {
				return admin2;
			}
		}
		return null;		
	}

	public Object seatCreat(int seat) {
		dao.seatCreat(seat);
		return null;
		
	}

	public List<CoachDto> getAvailableSeats() {		
		return dao.getAvailableSeats();
	}

	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
		return dao.saveBooking(booking);
	}

	public List<CoachDto> getAllBookedSeats() {
		// TODO Auto-generated method stub
		return dao.getAllBookedSeats();
	}	
}
