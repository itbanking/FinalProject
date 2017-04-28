package com.example.sal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.domain.Member;
import com.example.domain.Sal;
import com.example.mapper.MemberMapper;
import com.example.mapper.SalMapper;

@Service
public class SalModifyService {
	
	@Autowired
	SalMapper salMapper;
	
	@Autowired
	MemberMapper memberMapper;
	
	public void modify(Sal sal, BindingResult errors) {
		if (sal.getMembersrl() != null){
			Member member = memberMapper.selectByMembersrl(sal.getMembersrl());
			if (member == null)
				errors.reject("InvalidMemberSrl", "유효하지 않은 Member_Serial 입니다.");
		}
		
		if (!errors.hasErrors())
			salMapper.updateBySalno(sal);
	}
	
}
