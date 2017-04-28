package com.example.form;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.example.domain.Sal;

public class SalForm extends Sal{
	
	public void setSal(Sal sal) {
		super.setSalno(sal.getSalno());
		super.setBasicSal(sal.getBasicSal());
		super.setOvertimeSal(sal.getOvertimeSal());
		super.setComm(sal.getComm());
		super.setAidSal(sal.getAidSal());
		super.setSaldate(sal.getSaldate());
		super.setMembersrl(sal.getMembersrl());
	}

	@NotNull
	@Digits(integer=8, fraction=2)
	@Override
	public BigDecimal getBasicSal() {
		// TODO Auto-generated method stub
		return super.getBasicSal();
	}
	
	@Override
	@NumberFormat(style = Style.NUMBER, pattern="##,###,###")
	public void setBasicSal(BigDecimal basicSal) {
		// TODO Auto-generated method stub
		super.setBasicSal(basicSal);
	}

	@Digits(integer=8, fraction=2)
	@Override
	public BigDecimal getOvertimeSal() {
		// TODO Auto-generated method stub
		return super.getOvertimeSal();
	}

	@Override
	@NumberFormat(style = Style.NUMBER, pattern="##,###,###")
	public void setOvertimeSal(BigDecimal overtimeSal) {
		super.setOvertimeSal(overtimeSal);
	}

	@Digits(integer=8, fraction=2)
	@Override
	public BigDecimal getComm() {
		// TODO Auto-generated method stub
		return super.getComm();
	}

	@Override
	@NumberFormat(style = Style.NUMBER, pattern="##,###,###")
	public void setComm(BigDecimal comm) {
		super.setComm(comm);
	}

	@Digits(integer=8, fraction=2)
	@Override
	public BigDecimal getAidSal() {
		// TODO Auto-generated method stub
		return super.getAidSal();
	}

	@Override
	@NumberFormat(style = Style.NUMBER, pattern="##,###,###")
	public void setAidSal(BigDecimal aidSal) {
		super.setAidSal(aidSal);
	}

	@NotNull
	@Override
	public Date getSaldate() {
		// TODO Auto-generated method stub
		return super.getSaldate();
	}
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Override
	public void setSaldate(Date saldate) {
		// TODO Auto-generated method stub
		super.setSaldate(saldate);
	}
	
	@NotNull
	@Digits(integer=10, fraction=0)
	@Override
	public BigDecimal getMembersrl() {
		// TODO Auto-generated method stub
		return super.getMembersrl();
	}

	@Override
	public void setMembersrl(BigDecimal membersrl) {
		super.setMembersrl(membersrl);
	}

	
	
}
