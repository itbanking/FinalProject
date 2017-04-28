package com.example.Member;

import java.math.BigDecimal;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Member;
import com.example.form.MemberForm;
import com.example.mapper.MemberMapper;

@Controller
@RequestMapping("/User")
public class MemberModifyController4Member {
	
	static Log log = LogFactory.getLog(MemberRegisterController.class);
	
	@Autowired
	HttpSession m_Session;

	@Autowired
	MemberSearchService memberSearchService;
	
	@Autowired
	MemberModifyService memberModifyService;
	
	@Autowired
	MemberMapper memberMapper;
	
	@GetMapping("/Mod")
	public String modifyForm(MemberForm memberForm) {
		log.info("modifyForm() : GetMapping");

		Member member = memberSearchService.getMemberById( (String)m_Session.getAttribute("ID") );
		member.setPassword("");
		memberForm.SetMember(member);
		memberForm.setMembersrl(member.getMembersrl());
		
		System.out.println("Current Membersrl(ModifyForm) : " + memberForm.getMembersrl());
		
		return "User/ModifyMember";
	}
	
	@PostMapping("/Mod")
	public String modify(MemberForm memberForm, BindingResult errors) {
		log.info("modify() : PostMapping(First)");

		Member member = memberSearchService.getMemberById( (String)m_Session.getAttribute("ID") );

		memberForm.setMembersrl(member.getMembersrl());
		memberForm.setIsadmin(member.getIsadmin());
		
		log.info("Successfully Set Base Infos");
		log.info("GetPassword : '" + memberForm.getPassword() + "'");
		
		if ( memberForm.getPassword() == null ) {
			memberForm.setPassword(member.getPassword());
		}
		
		System.out.println("Current Membersrl(ModifyProcess01) : " + memberForm.getMembersrl());
	
		return modifyProcess(memberForm, errors);
	}
	
	public String modifyProcess(@Valid MemberForm memberForm, BindingResult errors) {
		log.info("ModifyMember(" + memberForm + ")");
		System.out.println("Current Membersrl(ModifyProcess02) : " + memberForm.getMembersrl());
		
		System.out.println(memberForm);
		
		// Validate
		if ( errors.hasErrors() ) {
			System.out.println(errors);
			return "User/ModifyMember";
		}
		
		// Register
		memberModifyService.Modify(memberForm, errors);
		if ( errors.hasErrors() ) {
			System.out.println(errors);
			return "User/ModifyMember";
		}

		return "redirect:/User/ModifyMemberSuccess"; 
	}
	
	@GetMapping("/ModifyMemberSuccess")
	public String modifySuccess(Model model) {
		Member member = memberSearchService.getMemberById( (String)m_Session.getAttribute("ID") );
		
		model.addAttribute("member", member);
		return "User/ModifyMemberSuccess";
	}

}
