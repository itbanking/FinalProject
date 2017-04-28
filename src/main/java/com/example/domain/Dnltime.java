package com.example.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Dnltime {

	private int dnlno;
	private Date attend;
	private Date leave;
	private String reason;
	private int dnlCode;
	private BigDecimal membersrl;
	private Dnl dnl;
	private Member member;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Dnl getDnl() {
		return dnl;
	}

	public void setDnl(Dnl dnl) {
		this.dnl = dnl;
	}

	public Dnltime() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String str= null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			str = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return str;
	}

	public int getDnlno() {
		return dnlno;
	}

	public void setDnlno(int dnlno) {
		this.dnlno = dnlno;
	}

	public Date getAttend() {
		return attend;
	}

	public void setAttend(Date attend) {
		this.attend = attend;
	}

	public Date getLeave() {
		return leave;
	}

	public void setLeave(Date leave) {
		this.leave = leave;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getDnlCode() {
		return dnlCode;
	}

	public void setDnlCode(int dnlCode) {
		this.dnlCode = dnlCode;
	}

	public BigDecimal getMembersrl() {
		return membersrl;
	}

	public void setMembersrl(BigDecimal membersrl) {
		this.membersrl = membersrl;
	}
	


}
