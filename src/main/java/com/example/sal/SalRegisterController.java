package com.example.sal;

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

import com.example.domain.Sal;
import com.example.form.SalForm;
import com.example.sal.service.SalRegisterService;
import com.example.sal.service.SalSearchService;

@Controller
@RequestMapping("/sal")
public class SalRegisterController {

	static Log log = LogFactory.getLog(SalRegisterController.class);
	@Autowired
	SalSearchService salSearchService;
	
	@Autowired
	SalRegisterService salRegisterService;
	
	@GetMapping("/register")
	public String registerForm(SalForm salForm) {
		log.info("registerForm()");
		return "sal/registerForm";
	}
	
	@PostMapping("/register")
	public String register(@Valid SalForm salForm, BindingResult errors, Integer pageNo) {
		log.info("register(" + salForm + ")");
		System.out.println(salForm);
		
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "sal/registerForm";
		}
		salRegisterService.register(salForm, errors);
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "sal/registerForm";
		}
		
		return "redirect:/sal/registerSuccess/" + salForm.getSalno() + "?pageNo=" + pageNo;
	}
	
	@GetMapping("/registerSuccess/{salno}")
	public String registerSuccess(@PathVariable int salno, Model model) {
		log.info("registerSuccess(" + salno + ")");
		
		Sal sal = salSearchService.getSalBySalno(salno);
		model.addAttribute("sal", sal);
		return "sal/registerSuccess";
	}
	
} 
