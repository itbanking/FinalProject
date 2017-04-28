package com.example.memo;

import java.math.BigDecimal;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Member.MemberSearchService;
import com.example.domain.Member;
import com.example.domain.Memo;
import com.example.form.MemberForm;
import com.example.form.MemoForm;
import com.example.memo.service.MemoRegisterService;
import com.example.memo.service.MemoSearchService;

import scala.annotation.meta.setter;

@Controller
@RequestMapping("/memo")
public class MemoRegisterController {
	
	static Log log = LogFactory.getLog(MemoRegisterController.class);
	
	@Autowired
	MemoSearchService memoSearchService;
	
	@Autowired
	MemoRegisterService memoRegisterService;
	
	@Autowired
	HttpSession m_Session;
	
	@Autowired
	MemberSearchService memberSearchService;
	
	@GetMapping("/register")
	public String registerForm(MemoForm memoForm) {
		log.info("registerForm( " + memoForm + ")");
		Member member = memberSearchService.getMemberById( (String)m_Session.getAttribute("ID") );
		memoForm.setMembersrl(member.getMembersrl());	
		return "/memo/registerForm";
	}
	
	@PostMapping("/register")
	public String register(@Valid MemoForm memoForm, BindingResult errors, Integer pageNo) {
		log.info("register("+ memoForm +")");
		System.out.println(memoForm);
		
		String content = memoForm.getMcontent();
		content = content.replace("\u0020", "&nbsp");
		content = content.replace("\r\n", "<br>");
		memoForm.setMcontent(content);
		
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "memo/registerForm";
		}
		memoRegisterService.register(memoForm, errors);
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "memo/registerForm";
		}
		
		return "redirect:/memo/registerSuccess/" + memoForm.getMno() + "?pageNo=" + pageNo;
	}
	
	@GetMapping("registerSuccess/{mno}")
	public String registerSuccess(@PathVariable int mno, Model model) {
		log.info("registerSuccess("+ mno +")");
		
		Memo memo = memoSearchService.getMemoByMno(mno);
		model.addAttribute("memo", memo);
		return "memo/registerSuccess";
	}
}
