package com.example.memo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Memo;
import com.example.form.MemberForm;
import com.example.mapper.MemoMapper;
import com.example.util.Pagination;

@Service
public class MemoSearchService {
	static Log log = LogFactory.getLog(MemoSearchService.class);
	
	@Autowired
	MemoMapper memoMapper;
	
	
	public List<Memo> getListAll() {
		log.info("getListAll()");
		return getListAll(false);
	}
	
	public List<Memo> getListAll(boolean withMember) {
		log.info("getListAll(" + withMember + ")");
		
		List<Memo> list = null;
		if (withMember)
			list = memoMapper.selectAllWithMember();
		else
			list = memoMapper.selectAll();
		
		return list;
	}
	
	public Map<String, Object> getPage(int pageNo, MemberForm memberForm) {
		
		return getPage(pageNo, memberForm, false);
	}
	
	public Map<String, Object> getPage(int pageNo, MemberForm memberForm,boolean withMember) {
		Pagination paging = new Pagination();
		paging.setTotalItem(memoMapper.selectTotalCount(memberForm));
		paging.setPageNo(pageNo);
		
		List<Memo> list = memoMapper.selectPageWithMember(paging);
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("memos", list);
		map.put("paging", paging);
		
		return map;
	}
	
	public Memo getMemoByMno(int mno) {
		log.info("getMemoByMno("+ mno +")");
		return getMemoByMno(mno, false);
	}
	
	public Memo getMemoByMno(int mno, boolean withMember) {
		log.info("getMemoBymno("+ mno +", " + withMember +")");
		Memo memo = null;
		if (withMember)
			memo = memoMapper.selectByMnoWithMember(mno);
		else
			memo = memoMapper.selectByMno(mno);
		
		return memo;
	}
	
}
