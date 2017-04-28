package com.example.dnltime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.city.CityUnregisterController;
import com.example.dnltime.service.DnltimeSearchService;
import com.example.dnltime.service.DnltimeUnregisterService;
import com.example.domain.Dnltime;

@Controller
@RequestMapping("/dnltime")
public class DnltimeUnregisterController {

	static Log log = LogFactory.getLog(CityUnregisterController.class);
	@Autowired
	DnltimeSearchService dnltimeSearchService;
	
	@Autowired
	DnltimeUnregisterService dnltimeUnregisterService; 
	
	@GetMapping("/unregister/{dnlno}")
	public String unregister(@PathVariable int dnlno, Model model){
		log.info("unregister(" + dnlno + ")");
		
		Dnltime dnltime = dnltimeSearchService.getDnltimeByDnlno(dnlno);
		log.info(dnltime);
		
		dnltimeUnregisterService.unregister(dnltime.getDnlno());
		
		return "redirect:/dnltime/page/1";
	}
}
