package com.example.sal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.domain.Member;
import com.example.domain.Sal;
import com.example.mapper.MemberMapper;
import com.example.mapper.SalMapper;

@Service
public class SalRegisterService {
	
	@Autowired
	SalMapper salMapper;
	
	@Autowired
	MemberMapper memberMapper;
	
	public void register(Sal sal, BindingResult errors) {
		
		if (sal.getMembersrl() != null) {
			
			Member member = memberMapper.selectByMembersrl(sal.getMembersrl());
			if (member == null)
				errors.reject("InvalidMemberSrl", "유효한 MemberSrl이 없습니다.");
		}
		
		if(!errors.hasErrors())
			salMapper.insert(sal);
	}
}
