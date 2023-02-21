package com.spritle.trainapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coach_table")
public class CoachDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_seatNo")
	private int seatNo;
	@Column(name="book_Id")
	private int bookId;
	@Column(name="book_status")
	private boolean status;
	public CoachDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "CoachDto [seatNo=" + seatNo + ", bookId=" + bookId + ", status=" + status + "]";
	}
	
	
	
	}
	
	
	


