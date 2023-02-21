package com.spritle.trainapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="agent_table")
public class Agent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="agent_Id")
	private int agentId;
	@Column(name="agent_name")
	private String name;
	@Column(name="agent_email",unique = true)
	private String email;
	@Column(name="agent_password")
	private String password;
	@Column(name="agent_dob")
	private String dob;
	@Column(name="agent_mbl")
	private long mbl;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="supadmin_Id")
	private SuperAdmin admin;
	
	@OneToMany(mappedBy = "agent")
	private List<Booking> book;
	
	public Agent() {
		// TODO Auto-generated constructor stub
	}
	

	public Agent(int agentId, String name, String email, String password, String dob, long mbl, SuperAdmin admin,
			List<Booking> book) {
		super();
		this.agentId = agentId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.mbl = mbl;
		this.admin = admin;
		this.book = book;
	}

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public long getMbl() {
		return mbl;
	}

	public void setMbl(long mbl) {
		this.mbl = mbl;
	}

	public SuperAdmin getAdmin() {
		return admin;
	}

	public void setAdmin(SuperAdmin admin) {
		this.admin = admin;
	}

	public List<Booking> getBook() {
		return book;
	}

	public void setBook(List<Booking> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", name=" + name + ", email=" + email + ", password=" + password + ", dob="
				+ dob + ", mbl=" + mbl + ", admin=" + admin + ", book=" + book + "]";
	}

	
	
	
	
}
