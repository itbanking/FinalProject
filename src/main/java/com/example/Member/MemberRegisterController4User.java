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
@RequestMapping("/Sign_in")
public class MemberRegisterController4User {
	
	static Log log = LogFactory.getLog(MemberRegisterController4User.class);

	@Autowired
	MemberSearchService memberSearchService;
	
	@Autowired
	MemberRegisterService memberRegisterService;
	
	@Autowired
	MemberMapper memberMapper;
	
	@GetMapping("/Form")
	public String registerForm(MemberForm memberForm) {
		log.info("registerForm()");
		return "Auth/MemberSignInForm";
	}

	@PostMapping("/Form")
	public String register(MemberForm memberForm, BindingResult errors) {
		//Get Next Membersrl
		BigDecimal NewSerial = memberMapper.GetNextMembersrl();
		System.out.println("New Serial : " + NewSerial);
		memberForm.setMembersrl(NewSerial);
		
		//set id to lowercase
		String original = memberForm.getUserid();
		memberForm.setUserid(original.toLowerCase());
		memberForm.setIsadmin("N");
		memberForm.setIsallowed("N");
		
		return register(memberForm, errors, true);
	}
	
	public String register(@Valid MemberForm memberForm, BindingResult errors, Boolean Checked) {
		log.info("AddMember(" + memberForm + ")");
		
		System.out.println(memberForm);
		
		// Validate
		if ( errors.hasErrors() ) {
			System.out.println(errors);
			return "Auth/MemberSignInForm";
		}
		
		// Register
		memberRegisterService.register(memberForm, errors);
		if ( errors.hasErrors() ) {
			System.out.println(errors);
			return "Auth/MemberSignInForm";
		}

		return "redirect:/Sign_in/Success"; 
	}
	
	@GetMapping("/Success")
	public String registerSuccess(Model model) {
		return "/Auth/MemberSignInSuccess";
	}
}
