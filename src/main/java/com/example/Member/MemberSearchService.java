package com.example.Member;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Member;
import com.example.mapper.MemberMapper;
import com.example.util.Pagination;

@Service
public class MemberSearchService {
	static Log log = LogFactory.getLog(MemberSearchService.class);
	
	@Autowired
	MemberMapper memberMapper;
	
	public List<Member> getListAll() {
		log.info("getListAll()");
		List<Member> list = memberMapper.selectAll();
		
		return list;
	}
	
	public Map<String, Object> getPage(int pageNo) {

		Pagination paging = new Pagination();
		paging.setTotalItem(memberMapper.CountAll());
		paging.setPageNo(pageNo);
		
		List<Member> list = memberMapper.selectPage(paging);
		
		Map<String, Object> map = new HashMap<>();
		map.put("members", list);
		map.put("paging", paging);
		
		return map;
	}
	
	
	public Member getMemberById(String id) {
		Member member = memberMapper.selectById(id);
		
		return member;
	}
	
	public Member getMemberByMemberSrl(BigDecimal id) {
		Member member = memberMapper.selectByMembersrl(id);
		
		return member;
	}


}
