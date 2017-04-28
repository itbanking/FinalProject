package com.example.sal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Sal;
import com.example.form.SalForm;
import com.example.sal.service.SalSearchService;
import com.example.sal.service.SalUnregisterService;

@Controller       
@RequestMapping("/sal")
public class SalUnregisterController {

	static Log log = LogFactory.getLog(SalUnregisterController.class);
	
	@Autowired
	SalSearchService salSearchService;
	
	@Autowired
	SalUnregisterService salUnregisterService;
	
	@GetMapping("/unregister/{salno}")
	public String unregisterForm(SalForm salForm, @PathVariable int salno, Model model) {
		log.info("unregister(" + salno + ")");
		Sal sal = salSearchService.getSalBySalno(salno);
		salForm.setSal(sal);
		model.addAttribute("sal", salForm);
		
		return "sal/unregisterForm";
	}
	
	@PostMapping("/unregister/{salno}")
	public String unregister(@PathVariable int salno, Integer pageNo) {
		log.info("unregidter(" + salno + ")");
		
		salUnregisterService.unregister(salno);
		
		return "redirect:/sal/unregisterSuccess/" + salno + "?pageNo=" + pageNo;
	}
	@GetMapping("/unregisterSuccess/{salno}")
	public String unregisterSuccess(@PathVariable int salno, Model model) {
		log.info("unregisterSuccess(" + salno + ")");
		Sal sal = salSearchService.getSalBySalno(salno);
		model.addAttribute("sal", sal);
		return "sal/unregisterSuccess";
	}
}
