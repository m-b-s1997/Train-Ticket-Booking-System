package com.spritle.trainapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spritle.trainapp.dto.Agent;
import com.spritle.trainapp.dto.Booking;
import com.spritle.trainapp.dto.CoachDto;
import com.spritle.trainapp.dto.SuperAdmin;

@Repository
public class TicketDao {
	
	@Autowired
	private EntityManagerFactory factory;
	
	public SuperAdmin insertSupAdmin(SuperAdmin adminDto) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(adminDto);
			transaction.commit();
			return adminDto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
	}

	public SuperAdmin supLogin(String email) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(SuperAdmin.class, email);
	}

	public Agent agentLogin(Agent agent) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(Agent.class, agent);
	}

	public boolean validateLogin(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM SuperAdmin WHERE email=?1 and password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<SuperAdmin> list = query.getResultList();
		
		return !list.isEmpty();
	}

	public Agent insertAgent(Agent agent1) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(agent1);
			transaction.commit();
			return agent1;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
	}

	public List<Agent> getAllAgent() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM Agent");
		List<Agent> list = query.getResultList();
		return list;
	}


	public Agent deleteEmployee(Agent agent) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			Agent dto= manager.merge(agent);
			manager.remove(dto);
			transaction.commit();
			return dto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}	
	}

	public Agent searchAgent(int id) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(Agent.class, id);
	}

	public boolean agentLoginValidate(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM Agent WHERE email=?1 and password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Agent> list = query.getResultList();
		
		return !list.isEmpty();
	}

	public List<SuperAdmin> getAllAdmin() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM SuperAdmin");
		List<SuperAdmin> list = query.getResultList();
		return list;
	}

	public void seatCreat(int seat) {
		
		seat*=6;
		for (int i = 0; i <seat; i++) {
			CoachDto coachDto  = new CoachDto();
			coachDto.setStatus(false);
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			
			try {
				transaction.begin();
				manager.persist(coachDto);
				transaction.commit();
			} catch (Exception e) {
				e.printStackTrace();
				transaction.rollback();
			}
		}
		
		
		
	}

	public List<CoachDto> getAllSeats() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM CoachDto");
		
		List<CoachDto> list = query.getResultList();
		return list;
	}

	public SuperAdmin searchAdmin(int id) {
		EntityManager manager = factory.createEntityManager();
		return manager.find(SuperAdmin.class, id);
	}

	public Booking saveBooking(Booking booking) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(booking);
			transaction.commit();
			return booking;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
	}

	public CoachDto updateStatus(CoachDto coachDto) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.merge(coachDto);
			transaction.commit();
			return coachDto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}
		
	}

	public List<CoachDto> getAvailableSeats() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM CoachDto WHERE status = 0");
		return query.getResultList();
	}

	public List<CoachDto> getAllBookedSeats() {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM CoachDto WHERE status = 1");
		return query.getResultList();
	}
	
}
	

