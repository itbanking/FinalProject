package com.example.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Member {

	private BigDecimal membersrl;
	private String userid;
	private String email;
	private String username;
	private String password;
	private String isadmin;
	private String isallowed;

	public Member() {
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
	/**
	 * @return the membersrl
	 */
	public BigDecimal getMembersrl() {
		return membersrl;
	}

	/**
	 * @param value the membersrl to set
	 */
	public Member setMembersrl(final BigDecimal value) {
		membersrl = value;
		return this;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param value the userid to set
	 */
	public Member setUserid(final String value) {
		userid = value;
		return this;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param value the email to set
	 */
	public Member setEmail(final String value) {
		email = value;
		return this;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param value the username to set
	 */
	public Member setUsername(final String value) {
		username = value;
		return this;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param value the password to set
	 */
	public Member setPassword(final String value) {
		password = value;
		return this;
	}

	/**
	 * @return the isadmin
	 */
	public String getIsadmin() {
		return isadmin;
	}

	/**
	 * @param value the isadmin to set
	 */
	public Member setIsadmin(final String value) {
		isadmin = value;
		return this;
	}
	
	/**
	 * @return the isadmin
	 */
	public String getIsallowed() {
		return isallowed;
	}

	/**
	 * @param value the isadmin to set
	 */
	public Member setIsallowed(final String value) {
		isallowed = value;
		return this;
	}

}
