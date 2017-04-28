package com.example.dnltime.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

import com.example.Member.MemberSearchService;
import com.example.domain.Dnltime;
import com.example.domain.Member;
import com.example.form.DnlForm;
import com.example.form.DnltimeForm;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DnltimeRegisterServiceTests {

	@Autowired
	DnltimeSearchService dnltimeSearchService;
	
	@Autowired
	DnltimeRegisterService dnltimeRegisterService;

	@Autowired
	HttpSession m_Session;
	
	@Autowired
	MemberSearchService memberSearchService;	
	
	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirm(){
		System.out.println("dnltimeRegisterService = " + dnltimeRegisterService);
		System.out.println("dnltimeSearchService = " + dnltimeSearchService);
		System.out.println("Validator = " + validator);
	}
	
	@Test
	public void test01_register(Dnltime dnltime, Member memberForm) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		Date leave = format.parse("2017-03-23 18:00:00");
		
		DnltimeForm dnltimeForm = new DnltimeForm();
		dnltimeForm.setAttend(new Date());
		dnltimeForm.setLeave(leave);
		dnltimeForm.setDnlCode(00);
		dnltimeForm.setMembersrl(new BigDecimal(6));
		
		BindingResult errors = new BeanPropertyBindingResult(dnltimeForm, "dnltimeForm");
		
		validator.validate(dnltimeForm, errors);
		if(errors.hasErrors()){
			System.out.println("errors = " + errors);
			return;
		}
		
//		dnltimeRegisterService.registerAttend(dnltime, errors, memberForm);
//		if(errors.hasErrors()){
//			System.out.println("errors = " + errors);
//			return;
//		}
		System.out.println("dnltime = " + dnltimeSearchService.getDnltimeByDnlno(dnltimeForm.getDnlno()));
	}
}
