package com.example.form;

import java.util.List;

import com.example.domain.Dept;
import com.example.domain.Emp;

public class DeptForm extends Dept {
	
	public void SetDept( Dept dept ) {
		setDeptno(dept.getDeptno());
		setDname(dept.getDname());
		setLoc(dept.getLoc());
	}

	@Override
	public List<Emp> getEmps() {
		// TODO Auto-generated method stub
		return super.getEmps();
	}

	@Override
	public void setEmps(List<Emp> emps) {
		// TODO Auto-generated method stub
		super.setEmps(emps);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public int getDeptno() {
		// TODO Auto-generated method stub
		return super.getDeptno();
	}

	@Override
	public void setDeptno(int deptno) {
		// TODO Auto-generated method stub
		super.setDeptno(deptno);
	}

	@Override
	public String getDname() {
		// TODO Auto-generated method stub
		return super.getDname();
	}

	@Override
	public void setDname(String dname) {
		// TODO Auto-generated method stub
		super.setDname(dname);
	}

	@Override
	public String getLoc() {
		// TODO Auto-generated method stub
		return super.getLoc();
	}

	@Override
	public void setLoc(String loc) {
		// TODO Auto-generated method stub
		super.setLoc(loc);
	}

}
