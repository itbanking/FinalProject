package com.example.Member;

import java.math.BigDecimal;

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

import com.example.domain.Member;
import com.example.form.MemberForm;
import com.example.mapper.MemberMapper;

@Controller
@RequestMapping("/Admin/CMD")
public class MemberModifyController {
	
	static Log log = LogFactory.getLog(MemberRegisterController.class);

	@Autowired
	MemberSearchService memberSearchService;
	
	@Autowired
	MemberModifyService memberModifyService;
	
	@Autowired
	MemberMapper memberMapper;
	
	@GetMapping("/Mod/{id}")
	public String modifyForm(MemberForm memberForm, @PathVariable BigDecimal id, Model model) {
		log.info("modifyForm()");

		Member member = memberSearchService.getMemberByMemberSrl(id);
		member.setPassword("");
		memberForm.SetMember(member);
		memberForm.setMembersrl(id);
		
		System.out.println("Current Membersrl(ModifyForm) : " + memberForm.getMembersrl());

		model.addAttribute("member", memberForm);
		
		return "Admin/CMD/ModifyMember";
	}
	
	@PostMapping("/Mod")
	public String modify(MemberForm memberForm, BindingResult errors) {

		Member member = memberSearchService.getMemberById(memberForm.getUserid());
		memberForm.setMembersrl(member.getMembersrl());
		
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
			return "Admin/CMD/ModifyMember";
		}
		
		// Register
		memberModifyService.Modify(memberForm, errors);
		if ( errors.hasErrors() ) {
			System.out.println(errors);
			return "Admin/CMD/ModifyMember";
		}

		return "redirect:/Admin/CMD/ModifyMemberSuccess/" + memberForm.getMembersrl(); 
	}
	
	@GetMapping("/ModifyMemberSuccess/{id}")
	public String modifySuccess(@PathVariable BigDecimal id, Model model) {
		Member member = memberSearchService.getMemberByMemberSrl(id);
		model.addAttribute("member", member);
		return "Admin/CMD/ModifyMemberSuccess";
	}

}
