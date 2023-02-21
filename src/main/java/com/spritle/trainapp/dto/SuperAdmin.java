package com.spritle.trainapp.dto;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sup_admin_table")
public class SuperAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="supadmin_Id")
	private int supAdminId;
	@Column(name="supadmin_email",unique = true)
	private String email;
	@Column(name="supadmin_password")
	private String password;
	
	@OneToMany(mappedBy = "admin")
//	@JoinColumn(name="supadmin_Id")
	private List<Agent> agents;
	
	public SuperAdmin() {
		// TODO Auto-generated constructor stub
	}
	public SuperAdmin(int supAdminId, String email, String password, List<Agent> agents) {
		super();
		this.supAdminId = supAdminId;
		this.email = email;
		this.password = password;
		this.agents = agents;
	}


	public int getSupAdminId() {
		return supAdminId;
	}

	public void setSupAdminId(int supAdminId) {
		this.supAdminId = supAdminId;
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

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	@Override
	public String toString() {
		return "SuperAdmin [supAdminId=" + supAdminId + ", email=" + email + ", password=" + password + ", agents="
				+ agents + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(agents, email, password, supAdminId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuperAdmin other = (SuperAdmin) obj;
		return Objects.equals(agents, other.agents) && Objects.equals(email, other.email)
				&& Objects.equals(password, other.password) && supAdminId == other.supAdminId;
	}
	
	

		
	
	
	
	
}
