package com.example.dnltime.service;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.city.CityRegisterController;
import com.example.domain.Dnltime;
import com.example.mapper.DnlMapper;
import com.example.mapper.DnltimeMapper;

@Service
public class DnltimeModifyService {

	static Log log = LogFactory.getLog(DnltimeModifyService.class);
	
	@Autowired
	DnltimeMapper dnltimeMapper;
	
	@Autowired
	DnlMapper dnlmapper;
	
	public void modify(Dnltime dnltime, BindingResult errors) throws ParseException{
	
		
		
		Date today = new Date();
		dnltime.setLeave(today);
		
		if(dnltime.getDnlCode() != 0 ){
			Dnltime DnltimeCode = dnltimeMapper.selectByDnlno(dnltime.getDnlCode());
			
			if(DnltimeCode==null)
				errors.reject("InvalidDnltimeDnlcode", "dnl테이블에 존재하지 않는 dnl code입니다.");
		}
		
		if(!errors.hasErrors())
			dnltimeMapper.updateByDnlno(dnltime);
		log.info("modify(" + dnltime + ")");
	}
	
	
}

