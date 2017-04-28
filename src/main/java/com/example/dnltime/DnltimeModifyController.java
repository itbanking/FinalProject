package com.example.dnltime;

import java.text.ParseException;
import java.util.Date;

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
import com.example.dnltime.service.DnltimeModifyService;
import com.example.dnltime.service.DnltimeSearchService;
import com.example.domain.Dnltime;

@Controller
@RequestMapping("/dnltime")
public class DnltimeModifyController {
	
	static Log log = LogFactory.getLog(DnltimeModifyController.class);
	
	@Autowired
	DnltimeSearchService dnltimeSearchService;
	
	@Autowired
	DnltimeModifyService dnltimeModifyService;
	

	@GetMapping("/modifyLeave/{dnlno}")
	public String modifyLeave(@PathVariable int dnlno, Dnltime dnltime, BindingResult errors, Integer pageNo) throws ParseException {
		
		Dnltime dtdnlno = dnltimeSearchService.getDnltimeByDnlno(dnlno);
		dnltime.setAttend(dtdnlno.getAttend());
		dnltime.setLeave(new Date());
		dnltime.setReason(dtdnlno.getReason());
		dnltime.setDnlCode(dtdnlno.getDnlCode());
		dnltime.setMembersrl(dtdnlno.getMembersrl());
		
		dnltimeModifyService.modify(dnltime, errors);
		
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "dnltime/modifyForm";
		}
		return "redirect:/dnltime/page/1" + "?pageNo=" + pageNo ;
	}
	
	@GetMapping("/modifyReason/{dnlno}")
	public String modifyReason(@PathVariable int dnlno, Dnltime dnltime) {
		
		Dnltime dnltimeResult = dnltimeSearchService.getDnltimeByDnlno(dnlno);
		log.info("modifyForm2(" + dnltimeResult + ")");

		dnltime.setAttend(dnltimeResult.getAttend());
		dnltime.setLeave(dnltimeResult.getLeave());
		dnltime.setReason(dnltimeResult.getReason());
		dnltime.setDnlCode(dnltimeResult.getDnlCode());
		dnltime.setMembersrl(dnltimeResult.getMembersrl());
		
		return "dnltime/modifyForm";
	}
	@PostMapping("/modifyReason")
	public String modifyReason(Dnltime dnltime,BindingResult errors, Integer pageNo, Model model) throws ParseException{
		log.info("modifyReason (" + dnltime + ")");

		if (errors.hasErrors()) {
			System.out.println(errors);
			return "dnltime/modifyForm";
		}
		
		dnltimeModifyService.modify(dnltime, errors);
		
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "dnltime/modifyForm";
		}
	
		return "redirect:/dnltime/page/1";
	}
}
