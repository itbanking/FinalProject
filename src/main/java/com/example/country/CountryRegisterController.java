package com.example.country;

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

import com.example.country.service.CountryRegisterService;
import com.example.country.service.CountrySearchService;
import com.example.domain.Country;
import com.example.form.CountryForm;

@Controller
@RequestMapping("/country")
public class CountryRegisterController {
	
	static Log log = LogFactory.getLog(CountryRegisterController.class);
	
	@Autowired
	CountrySearchService countrySearchService;
	
	@Autowired
	CountryRegisterService countryRegisterService;
	
	@GetMapping("/register")
	public String reigsterForm(CountryForm countryForm) {
		log.info("register()");
		
		return "country/registerForm";
	}
	
	@PostMapping("/register")
	public String register(@Valid CountryForm countryForm, BindingResult errors, Integer pageNo) {
		log.info("register(" + countryForm + ")");
		System.out.println(countryForm);
		
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "/country/registerForm";
		}
		
		countryRegisterService.register(countryForm, errors);
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "/country/registerForm";
		}
		
		return "redirect:/country/registerSuccess/" + countryForm.getCode() + "?pageNo=" + pageNo;
	}
	
	@GetMapping("/registerSuccess/{code}")
	public String registerSuccess(@PathVariable String code, Model model) {
		log.info("registerSuccess(" + code + ")");
		
		Country country = countrySearchService.getCountryByCode(code);
		model.addAttribute("country", country);
		
		return "/country/registerSuccess";
	}
}
