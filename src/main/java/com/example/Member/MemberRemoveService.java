package com.example.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.domain.Member;
import com.example.mapper.MemberMapper;

@Service
public class MemberRemoveService {

	@Autowired
	MemberMapper memberMapper;
	
	public void Remove( Member member, BindingResult errors ) {
		
		Member validate = memberMapper.selectByMembersrl( member.getMembersrl() );
		
		if ( validate == null ) {
			errors.reject("Member not exists", "해당 시리얼에 회원이 존재하지 않습니다..");
		}
		
		if ( !errors.hasErrors() ) {
			memberMapper.delete(member);
		}
	}
}
