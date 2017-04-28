package com.example.country;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.country.service.CountrySearchService;
import com.example.country.service.CountryUnregisterService;
import com.example.domain.Country;

@Controller
@RequestMapping("/country")
public class CountryUnRegisterController {
	
	static Log log = LogFactory.getLog(CountryUnRegisterController.class);
	
	@Autowired
	CountrySearchService countrySearchService;
	
	@Autowired
	CountryUnregisterService countryUnregisterService;
	
	@GetMapping("/unregister/{code}")
	public String unregisterForm(@PathVariable String code, Model model) {
		log.info("unregister(" + code + ")");
		Country country = countrySearchService.getCountryByCode(code);
		model.addAttribute("country", country);
		
		return "country/unregisterForm";
	}
	
	@PostMapping("/unregister/{code}")
	public String unregister(@PathVariable String code, Integer pageNo) {
		log.info("unregister(" + code + ")");
		
		countryUnregisterService.unregister(code);
		
		return "redirect:/country/unregisterSuccess/" + code + "?pageNo=" + pageNo;
	}
	
	@GetMapping("/unregisterSuccess/{code}")
	public String unregisterSuccess(@PathVariable String code, Model model) {
		model.addAttribute("code", code);
		return "country/unregisterSuccess";
	}
}
