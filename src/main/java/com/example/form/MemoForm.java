package com.example.form;

import java.math.BigDecimal;
import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.domain.Memo;

public class MemoForm extends Memo{
	
	public void setMemo(Memo memo) {
		super.setMno(memo.getMno());
		super.setMname(memo.getMname());
		super.setMcontent(memo.getMcontent());
		super.setMdate(memo.getMdate());
		super.setMembersrl(memo.getMembersrl());
	}
	
	@NotNull
	@Size(max=100)
	@Override
	public String getMname() {
		// TODO Auto-generated method stub
		return super.getMname();
	}

	@Override
	public void setMname(String mname) {
		// TODO Auto-generated method stub
		super.setMname(mname);
	}
	
	@Size(max=4000)
	@Override
	public String getMcontent() {
		// TODO Auto-generated method stub
		return super.getMcontent();
	}

	@Override
	public void setMcontent(String mcontent) {
		// TODO Auto-generated method stub
		super.setMcontent(mcontent);
	}
	
	@NotNull
	@Override
	public java.util.Date getMdate() {
		// TODO Auto-generated method stub
		return super.getMdate();
	}
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Override
	public void setMdate(java.util.Date mdate) {
		// TODO Auto-generated method stub
		super.setMdate(mdate);
	}

	@NotNull
	@Override
	public BigDecimal getMembersrl() {
		// TODO Auto-generated method stub
		return super.getMembersrl();
	}

	@Override
	public void setMembersrl(BigDecimal membersrl) {
		// TODO Auto-generated method stub
		super.setMembersrl(membersrl);
	}
	
}
