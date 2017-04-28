package com.example.dnltime.service;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.Member.MemberSearchService;
import com.example.domain.Dnltime;
import com.example.domain.Member;
import com.example.form.MemberForm;
import com.example.mapper.DnlMapper;
import com.example.mapper.DnltimeMapper;

@Service
public class DnltimeRegisterService {

	@Autowired
	DnltimeMapper dnltimeMapper;
	
	@Autowired
	DnlMapper dnlmapper;

	@Autowired
	HttpSession m_Session;
	
	@Autowired
	MemberSearchService memberSearchService;
	
	public void registerAttend(Dnltime dnltime, BindingResult errors , MemberForm memberForm) throws ParseException{
	
		
		Date today = new Date();
		dnltime.setAttend(today);	
		dnltime.setDnlCode(00);
		
		Member member = memberSearchService.getMemberById( (String)m_Session.getAttribute("ID") );
		dnltime.setMembersrl(member.getMembersrl());
		
			
		if(dnltime.getDnlCode() != 0 ){
			Dnltime DnltimeCode = dnltimeMapper.selectByDnlno(dnltime.getDnlCode());
			
			if(DnltimeCode==null)
				errors.reject("InvalidDnltimeDnlcode", "dnl테이블에 존재하지 않는 dnl code입니다.");
		}
		
		if(!errors.hasErrors())
			dnltimeMapper.insert(dnltime);
	}
	
}

