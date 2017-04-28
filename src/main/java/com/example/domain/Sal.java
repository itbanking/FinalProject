package com.example.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Sal {

	private int salno;
	private BigDecimal basicSal;
	private BigDecimal overtimeSal;
	private BigDecimal comm;
	private BigDecimal aidSal;
	private Date saldate;
	private BigDecimal membersrl;
	
	private Member member;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Sal() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		String str = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return str;
	}

	public int getSalno() {
		return salno;
	}

	public void setSalno(int salno) {
		this.salno = salno;
	}

	public BigDecimal getBasicSal() {
		return basicSal;
	}

	public void setBasicSal(BigDecimal basicSal) {
		this.basicSal = basicSal;
	}

	public BigDecimal getOvertimeSal() {
		return overtimeSal;
	}

	public void setOvertimeSal(BigDecimal overtimeSal) {
		this.overtimeSal = overtimeSal;
	}

	public BigDecimal getComm() {
		return comm;
	}

	public void setComm(BigDecimal comm) {
		this.comm = comm;
	}

	public BigDecimal getAidSal() {
		return aidSal;
	}

	public void setAidSal(BigDecimal aidSal) {
		this.aidSal = aidSal;
	}

	public Date getSaldate() {
		return saldate;
	}

	public void setSaldate(Date saldate) {
		this.saldate = saldate;
	}

	public BigDecimal getMembersrl() {
		return membersrl;
	}

	public void setMembersrl(BigDecimal membersrl) {
		this.membersrl = membersrl;
	}
	

}
