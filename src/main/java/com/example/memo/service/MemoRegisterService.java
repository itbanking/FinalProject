package com.example.memo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.domain.Member;
import com.example.domain.Memo;
import com.example.mapper.MemberMapper;
import com.example.mapper.MemoMapper;

@Service
public class MemoRegisterService {
	
	@Autowired
	MemoMapper memoMapper;
	
	@Autowired
	MemberMapper memberMapper;
	
	public void register(Memo memo, BindingResult errors) {
		if (memo.getMembersrl() != null) {
			Member member = memberMapper.selectByMembersrl(memo.getMembersrl());
			if (member == null)
				errors.reject("IvalidMemberSrl", "유효하지 않은 Member_Serial 입니다.");
		}
		
		if(!errors.hasErrors())
			memoMapper.insert(memo);
	}
}
