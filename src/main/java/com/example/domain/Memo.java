package com.example.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Memo {

	private int mno;
	private String mname;
	private String mcontent;
	private Date mdate;
	private BigDecimal membersrl;
	
	private Member member;

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Memo() {
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

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public BigDecimal getMembersrl() {
		return membersrl;
	}

	public void setMembersrl(BigDecimal membersrl) {
		this.membersrl = membersrl;
	}

	
	
	

}
