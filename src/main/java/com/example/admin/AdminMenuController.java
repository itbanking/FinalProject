package com.example.admin;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Member.MemberRegisterService;
import com.example.Member.MemberSearchService;
import com.example.domain.Member;
import com.example.form.CityForm;
import com.example.form.MemberForm;
import com.example.mapper.MemberMapper;

@Controller
@RequestMapping("/Admin")
public class AdminMenuController {

	static Log log = LogFactory.getLog(AdminController.class);
	
	@Autowired
	MemberSearchService memberSearchService;
	
	@Autowired
	MemberMapper memberMapper;
	
	@GetMapping("/CMD")
	public String ControlMemberDatabase(Model model) {
		log.info("ControlMemberDatabase()");
		
		List<Member> list = memberSearchService.getListAll();
		model.addAttribute("Members", list);
		
		return "Admin/CMD";
	}

}
