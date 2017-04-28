package com.example.memo;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Member.MemberSearchService;
import com.example.domain.Member;
import com.example.domain.Memo;
import com.example.form.MemberForm;
import com.example.memo.service.MemoSearchService;

@Controller
@RequestMapping("/memo")
public class MemoSearchController {

	static Log log = LogFactory.getLog(MemoSearchController.class);
	
	@Autowired
	MemoSearchService memoSearchService;
	
	@Autowired
	HttpSession m_Session;
	
	@Autowired
	MemberSearchService memberSearchService;
	
	@GetMapping("/list")
	public String getList(Model model) {
		log.info("getList()");
		
		List<Memo> list = memoSearchService.getListAll();
		model.addAttribute("memos", list);
		
		return "memo/list";
	}
	
	@GetMapping("/page/{pageNo}")
	public String getPage(@PathVariable int pageNo, Model model, MemberForm memberForm) {
		
		log.info("getPage(" + pageNo + ")" );
		
		Member member = memberSearchService.getMemberById( (String)m_Session.getAttribute("ID") );
		memberForm.setMembersrl(member.getMembersrl());	
		memberForm.setUserid(member.getUserid());
		memberForm.setEmail(member.getIsadmin());
		memberForm.setUsername(member.getUsername());
		memberForm.setIsadmin(member.getIsadmin());
		
		log.info("getpage(" + memberForm + ")");
		
		Map<String, Object> page = memoSearchService.getPage(pageNo, memberForm);
		model.addAttribute("page", page);
		
		return "memo/page";
	}
	
	@GetMapping("item/{mno}")
	public String getItem(@PathVariable int mno, Model model) {
		log.info("getItem("+ mno +")");
		
		Memo memo = memoSearchService.getMemoByMno(mno, true);
		model.addAttribute("memo", memo);
		
		return "memo/item";
	}
}
