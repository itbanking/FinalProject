package com.example.form;

import java.math.BigDecimal;
import java.sql.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.domain.Dept;
import com.example.domain.Emp;

public class EmpForm extends Emp {
	
	public void SetEmp(Emp e) {
		setComm(e.getComm());
		setDeptno(e.getDeptno());
		setEmpno(e.getEmpno());
		setEname(e.getEname());
		setHiredate(e.getHiredate());
		setJob(e.getJob());
		setMgr(e.getMgr());
		setSal(e.getSal());
	}
	
	@Override
	public Dept getDept() {
		// TODO Auto-generated method stub
		return super.getDept();
	}

	@Override
	public void setDept(Dept dept) {
		// TODO Auto-generated method stub
		super.setDept(dept);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@NotNull
	@Digits(integer=4,fraction=0)
	@Override
	public int getEmpno() {
		// TODO Auto-generated method stub
		return super.getEmpno();
	}

	@Override
	public void setEmpno(int empno) {
		// TODO Auto-generated method stub
		super.setEmpno(empno);
	}

	@Size(max=10)
	@Override
	public String getEname() {
		// TODO Auto-generated method stub
		return super.getEname();
	}

	@Override
	public void setEname(String ename) {
		// TODO Auto-generated method stub
		super.setEname(ename);
	}

	@Size(max=9)
	@Override
	public String getJob() {
		// TODO Auto-generated method stub
		return super.getJob();
	}

	@Override
	public void setJob(String job) {
		// TODO Auto-generated method stub
		super.setJob(job);
	}

	@Digits(integer=4,fraction=0)
	@Override
	public Integer getMgr() {
		// TODO Auto-generated method stub
		return super.getMgr();
	}

	@Override
	public void setMgr(Integer mgr) {
		// TODO Auto-generated method stub
		super.setMgr(mgr);
	}

	@Override
	public Date getHiredate() {
		// TODO Auto-generated method stub
		return super.getHiredate();
	}

	@Override
	public void setHiredate(Date hiredate) {
		// TODO Auto-generated method stub
		super.setHiredate(hiredate);
	}

	@Digits(integer=7,fraction=2)
	@Override
	public BigDecimal getSal() {
		// TODO Auto-generated method stub
		return super.getSal();
	}

	@Override
	public void setSal(BigDecimal sal) {
		// TODO Auto-generated method stub
		super.setSal(sal);
	}

	@Digits(integer=7,fraction=2)
	@Override
	public BigDecimal getComm() {
		// TODO Auto-generated method stub
		return super.getComm();
	}

	@Override
	public void setComm(BigDecimal comm) {
		// TODO Auto-generated method stub
		super.setComm(comm);
	}

	@Digits(integer=2,fraction=0)
	@Override
	public Integer getDeptno() {
		// TODO Auto-generated method stub
		return super.getDeptno();
	}

	@Override
	public void setDeptno(Integer deptno) {
		// TODO Auto-generated method stub
		super.setDeptno(deptno);
	}

}
