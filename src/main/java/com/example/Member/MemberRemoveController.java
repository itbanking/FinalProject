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
public class MemberRemoveController {
	
	static Log log = LogFactory.getLog(MemberRegisterController.class);

	@Autowired
	MemberSearchService memberSearchService;
	
	@Autowired
	MemberRemoveService memberRemoveService;
	
	@Autowired
	MemberMapper memberMapper;
	
	@GetMapping("/Rem/{id}")
	public String RemoveForm(MemberForm memberForm, @PathVariable BigDecimal id) {
		log.info("RemoveForm()");
		
		Member member = memberSearchService.getMemberByMemberSrl(id);

		memberForm.SetMember(member);
		
		System.out.println("Current Membersrl(RemoveForm) : " + memberForm.getMembersrl());
		
		return "Admin/CMD/RemoveMember";
	}
	
	@PostMapping("/Rem")
	public String remove(MemberForm memberForm, BindingResult errors) {
		Member member = memberSearchService.getMemberById(memberForm.getUserid());
		memberForm.setMembersrl(member.getMembersrl());
		
		System.out.println("Current Membersrl(RemoveProcess01) : " + memberForm.getMembersrl());
	
		return removeProcess(memberForm, errors);
	}
	
	public String removeProcess(@Valid MemberForm memberForm, BindingResult errors) {
		log.info("RemoveMember(" + memberForm + ")");
		System.out.println("Current Membersrl(RemoveProcess02) : " + memberForm.getMembersrl());
		
		System.out.println(memberForm);
		
		// Validate
		if ( errors.hasErrors() ) {
			System.out.println(errors);
			return "Admin/CMD/RemoveMember";
		}
		
		// Register
		memberRemoveService.Remove(memberForm, errors);
		if ( errors.hasErrors() ) {
			System.out.println(errors);
			return "Admin/CMD/RemoveMember";
		}

		return "redirect:/Admin/CMD/RemoveMemberSuccess/"; 
	}
	
	@GetMapping("/RemoveMemberSuccess")
	public String modifySuccess(Model model) {
		return "Admin/CMD/RemoveMemberSuccess";
	}

}
