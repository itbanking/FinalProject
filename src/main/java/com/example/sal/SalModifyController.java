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
import com.example.sal.service.SalModifyService;
import com.example.sal.service.SalSearchService;

@Controller
@RequestMapping("/sal")
public class SalModifyController {
	
	static Log log = LogFactory.getLog(SalModifyController.class);
	
	@Autowired
	SalSearchService salSearchService;
	
	@Autowired
	SalModifyService salModifyService;
	
	@GetMapping("/modify/{salno}")
	public String modifyForm(SalForm salForm, @PathVariable int salno, Model model) {
		log.info("modifyForm(" + salno + ")");
		Sal sal = salSearchService.getSalBySalno(salno);
		salForm.setSal(sal);
		
		model.addAttribute("sal", salForm);
		
		return "sal/modifyForm";
	}
	
	@PostMapping("/modify")
	public String modify(@Valid SalForm salForm, BindingResult errors, Integer pageNo) {
		log.info("modify(" + salForm + ")");
		System.out.println(salForm);
		
		if (errors.hasErrors()){
			System.out.println(errors);
			return "sal/modifyForm";
		}
		salModifyService.modify(salForm, errors);
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "sal/modifyForm";
		}
		return "redirect:/sal/modifySuccess/" + salForm.getSalno() + "?pageNo=" + pageNo;
	}
	
	@GetMapping("/modifySuccess/{salno}")
	public String modifySuccess(@PathVariable int salno, Model model) {
		Sal sal = salSearchService.getSalBySalno(salno);
		model.addAttribute("sal", sal);
		return "sal/modifySuccess";
	}
}
