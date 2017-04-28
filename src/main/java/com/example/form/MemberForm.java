package com.example.form;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.domain.Member;

public class MemberForm extends Member {
	
	public void SetMember( Member member ) {
		super.setIsadmin(member.getIsadmin());
		super.setIsallowed(member.getIsallowed());
		super.setEmail(member.getEmail());
		super.setMembersrl(member.getMembersrl());
		super.setPassword(member.getPassword());
		super.setUserid(member.getUserid());
		super.setUsername(member.getUsername());
	}

	@NotNull
	@Digits(integer=10, fraction=2)
	@Override
	public BigDecimal getMembersrl() {
		// TODO Auto-generated method stub
		return super.getMembersrl();
	}

	@Override
	public Member setMembersrl(BigDecimal value) {
		// TODO Auto-generated method stub
		return super.setMembersrl(value);
	}

	@NotNull
	@Size(max=80)
	@Override
	public String getUserid() {
		// TODO Auto-generated method stub
		return super.getUserid();
	}

	@Override
	public Member setUserid(String value) {
		// TODO Auto-generated method stub
		return super.setUserid(value);
	}

	@NotNull
	@Size(max=250)
	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public Member setEmail(String value) {
		// TODO Auto-generated method stub
		return super.setEmail(value);
	}

	@NotNull
	@Size(max=40)
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public Member setUsername(String value) {
		// TODO Auto-generated method stub
		return super.setUsername(value);
	}

	@NotNull
	@Size(max=32)
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public Member setPassword(String value) {
		// TODO Auto-generated method stub
		return super.setPassword(value);
	}

	@NotNull
	@Size(max=1)
	@Override
	public String getIsadmin() {
		// TODO Auto-generated method stub
		return super.getIsadmin();
	}

	@Override
	public Member setIsadmin(String value) {
		// TODO Auto-generated method stub
		return super.setIsadmin(value);
	}

	@NotNull
	@Size(max=1)
	@Override
	public String getIsallowed() {
		// TODO Auto-generated method stub
		return super.getIsallowed();
	}

	@Override
	public Member setIsallowed(String value) {
		// TODO Auto-generated method stub
		return super.setIsallowed(value);
	}

}
