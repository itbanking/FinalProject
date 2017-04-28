package com.example.form;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.domain.Country;

public class CountryForm extends Country {
	
	public void setCountry(Country country) {
			super.setCode(country.getCode());
			super.setName(country.getName());
			super.setContinent(country.getContinent());
			super.setRegion(country.getRegion());
			super.setSurfaceArea(country.getSurfaceArea());
			super.setIndepYear(country.getIndepYear());
			super.setPopulation(country.getPopulation());
			super.setLifeExpectancy(country.getLifeExpectancy());
			super.setGnp(country.getGnp());
			super.setGnpOld(country.getGnpOld());
			super.setLocalName(country.getLocalName());
			super.setGovernmentForm(country.getGovernmentForm());
			super.setHeadOfState(country.getHeadOfState());
			super.setCapital(country.getCapital());
			super.setCode2(country.getCode2());
	}
	
	@NotNull
	@Size(max=3)
	@Override
	public String getCode() {
		// TODO Auto-generated method stub
		return super.getCode();
	}

	@Override
	public void setCode(String code) {
		if (code.equals(""))
			code = null;
		super.setCode(code);
	}
	
	@NotNull
	@Size(max=52)
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		if (name.equals(""))
			name = null;
		super.setName(name);
	}
	
	@Size(max=20)
	@Override
	public String getContinent() {
		// TODO Auto-generated method stub
		return super.getContinent();
	}

	@Override
	public void setContinent(String continent) {
		if (continent.equals(""))
			continent = null;
		super.setContinent(continent);
	}
	
	@Size(max=26)
	@Override
	public String getRegion() {
		// TODO Auto-generated method stub
		return super.getRegion();
	}

	@Override
	public void setRegion(String region) {
		if (region.equals(""))
			region = null;
		super.setRegion(region);
	}
	
	@Digits(integer=8,fraction=2)
	@Override
	public BigDecimal getSurfaceArea() {
		// TODO Auto-generated method stub
		return super.getSurfaceArea();
	}

	@Override
	public void setSurfaceArea(BigDecimal surfaceArea) {
		// TODO Auto-generated method stub
		super.setSurfaceArea(surfaceArea);
	}

	@Digits(integer=6,fraction=0)
	@Override
	public BigDecimal getIndepYear() {
		// TODO Auto-generated method stub
		return super.getIndepYear();
	}

	@Override
	public void setIndepYear(BigDecimal indepYear) {
		// TODO Auto-generated method stub
		super.setIndepYear(indepYear);
	}

	@Digits(integer=11,fraction=0)
	@Override
	public BigDecimal getPopulation() {
		// TODO Auto-generated method stub
		return super.getPopulation();
	}

	@Override
	public void setPopulation(BigDecimal population) {
		// TODO Auto-generated method stub
		super.setPopulation(population);
	}

	@Digits(integer=2,fraction=1)
	@Override
	public BigDecimal getLifeExpectancy() {
		// TODO Auto-generated method stub
		return super.getLifeExpectancy();
	}

	@Override
	public void setLifeExpectancy(BigDecimal lifeExpectancy) {
		// TODO Auto-generated method stub
		super.setLifeExpectancy(lifeExpectancy);
	}

	@Digits(integer=8,fraction=2)
	@Override
	public BigDecimal getGnp() {
		// TODO Auto-generated method stub
		return super.getGnp();
	}

	@Override
	public void setGnp(BigDecimal gnp) {
		// TODO Auto-generated method stub
		super.setGnp(gnp);
	}

	@Digits(integer=8,fraction=2)
	@Override
	public BigDecimal getGnpOld() {
		// TODO Auto-generated method stub
		return super.getGnpOld();
	}

	@Override
	public void setGnpOld(BigDecimal gnpOld) {
		// TODO Auto-generated method stub
		super.setGnpOld(gnpOld);
	}
	
	@Size(max=45)
	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return super.getLocalName();
	}

	@Override
	public void setLocalName(String localName) {
		if (localName.equals(""))
			localName = null;
		super.setLocalName(localName);
	}

	@Size(max=45)
	@Override
	public String getGovernmentForm() {
		// TODO Auto-generated method stub
		return super.getGovernmentForm();
	}

	@Override
	public void setGovernmentForm(String governmentForm) {
		if (governmentForm.equals(""))
			governmentForm = null;
		super.setGovernmentForm(governmentForm);
	}

	@Size(max=60)
	@Override
	public String getHeadOfState() {
		// TODO Auto-generated method stub
		return super.getHeadOfState();
	}

	@Override
	public void setHeadOfState(String headOfState) {
		if (headOfState.equals(""))
			headOfState = null;
		super.setHeadOfState(headOfState);
	}
	
	@Digits(integer=11,fraction=0)
	@Override
	public BigDecimal getCapital() {
		// TODO Auto-generated method stub
		return super.getCapital();
	}

	@Override
	public void setCapital(BigDecimal capital) {
		// TODO Auto-generated method stub
		super.setCapital(capital);
	}

	@Size(max=2)
	@Override
	public String getCode2() {
		// TODO Auto-generated method stub
		return super.getCode2();
	}

	@Override
	public void setCode2(String code2) {
		if (code2.equals(""))
			code2 = null;
		super.setCode2(code2);
	}
	
}
