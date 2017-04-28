package com.example.form;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.domain.Dnl;

public class DnlForm extends Dnl {

	@NotNull
	@Digits(integer=3,fraction=0)
	@Override
	public int getDnlCode() {
		// TODO Auto-generated method stub
		return super.getDnlCode();
	}

	@Override
	public void setDnlCode(int dnlCode) {
		// TODO Auto-generated method stub
		super.setDnlCode(dnlCode);
	}

	@Size(max=4)
	@Override
	public String getDnlType() {
		// TODO Auto-generated method stub
		return super.getDnlType();
	}

	@Override
	public void setDnlType(String dnlType) {
		// TODO Auto-generated method stub
		super.setDnlType(dnlType);
	}

}
