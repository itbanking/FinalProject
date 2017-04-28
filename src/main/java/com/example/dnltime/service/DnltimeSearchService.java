package com.example.dnltime.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Member.MemberSearchService;
import com.example.domain.Dnltime;
import com.example.domain.Member;
import com.example.form.MemberForm;
import com.example.mapper.DnltimeMapper;
import com.example.util.Pagination;

@Service
public class DnltimeSearchService {
	static Log log = LogFactory.getLog(DnltimeSearchService.class);
	
	@Autowired
	DnltimeMapper dnltimeMapper;
	
	public List<Dnltime> getListAll(){
		log.info("getListAll()");
		return getListAll(false);
	}
	public List<Dnltime> getListAll(boolean withDnl){
		log.info("getListAll(" + withDnl+ ") ");
		
		List<Dnltime> list = null;
		
		if(withDnl)
			list = dnltimeMapper.selectAllWithDnl();
		else
			list = dnltimeMapper.selectAll();
		return list;
	}
	
	public Map<String, Object> getPage(int pageNo, MemberForm memberForm){
		
		return getPage(pageNo, memberForm, false);
	}

	public Map<String, Object> getPage(int pageNo, MemberForm memberForm , boolean withDnl){
		Pagination paging = new Pagination();
		paging.setTotalItem(dnltimeMapper.selectTotalUserCount(memberForm));
		paging.setPageNo(pageNo);
		
		List<Dnltime> list = null;
		if(withDnl)
			list = dnltimeMapper.selectPageWithDnl(paging);	
		else
			list = dnltimeMapper.selectPage(paging, memberForm);
		
		Map<String, Object> map = new HashMap<>();
		map.put("dnltimeList", list);
		map.put("paging", paging);
		
		return map;
	}

	public Map<String, Object> getPageWithIsAdmin(int pageNo, MemberForm memberForm ){
		Pagination paging = new Pagination();
		paging.setTotalItem(dnltimeMapper.selectTotalIsAdmin());
		paging.setPageNo(pageNo);
		
		List<Dnltime> list = dnltimeMapper.selectPageIsAdmin(paging);	
		
		Map<String, Object> map = new HashMap<>();
		map.put("dnltimeList", list);
		map.put("paging", paging);
		
		return map;
	}
	
	public Dnltime getDnltimeByDnlno(int dnlno){
		log.info("getDnltimeByDnlno( " + dnlno + ")");
		
		return getDnltimeByDnlno(dnlno, false);
	}
	public Dnltime getDnltimeByDnlno(int dnlno, boolean withMember){
		Dnltime dnltime = null;
		if(withMember)
			dnltime = dnltimeMapper.selectByDnlnoWithDnl(dnlno);
		else
			dnltime = dnltimeMapper.selectByDnlno(dnlno);
		return dnltime;
	}
	
	public Dnltime getDnltimeByDnlnoWithMembersrl(int dnlno){
		log.info("getDnltimeByDnlnoWithMembersrl( " + dnlno + ")");
		
		Dnltime dnltime = dnltimeMapper.selectByDnlnoWithMember(dnlno);
		
		return dnltime;
	}
	
	
	public List<Dnltime> getmembersrl(int membersrl) {
			
		List<Dnltime> dnltime = dnltimeMapper.selectmembersrl(membersrl);
		
		return dnltime;
	}

}
