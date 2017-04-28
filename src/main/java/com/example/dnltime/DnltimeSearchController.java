package com.example.dnltime;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Member.MemberSearchService;
import com.example.city.CitySearchController;
import com.example.dnltime.service.DnltimeSearchService;
import com.example.domain.Dnltime;
import com.example.domain.Member;
import com.example.form.MemberForm;

@Controller
@RequestMapping("/dnltime")
public class DnltimeSearchController {

	static Log log = LogFactory.getLog(CitySearchController.class);
	
	@Autowired
	DnltimeSearchService dnltimeSearchService;
	
	@Autowired
	HttpSession m_Session;


	@Autowired
	MemberSearchService memberSearchService;
	
	@GetMapping("/list")
	public String getList(Model model){
		log.info("getList()");
		
		List<Dnltime> list = dnltimeSearchService.getListAll(true);
		model.addAttribute("dnltime", list);
		return "dnltime/list";
	}
	
	@GetMapping("/page/{pageNo}")
	public String getPage(@PathVariable int pageNo, Model model, MemberForm memberForm){
		log.info("getPage(" + pageNo + ")");
		
		Member member = memberSearchService.getMemberById( (String)m_Session.getAttribute("ID") );
		memberForm.setMembersrl(member.getMembersrl());	
		memberForm.setUserid(member.getUserid());
		memberForm.setEmail(member.getIsadmin());
		memberForm.setUsername(member.getUsername());
		memberForm.setIsadmin(member.getIsadmin());
		
		log.info("getpage(" + memberForm + ")");
		
		if(member.getIsadmin().equals("Y")){
			Map<String, Object> page = dnltimeSearchService.getPageWithIsAdmin(pageNo, memberForm);
			model.addAttribute("page", page);
			return "dnltime/page";
		}
		else{
			Map<String, Object> page = dnltimeSearchService.getPage(pageNo, memberForm);
			model.addAttribute("page", page);
			return "dnltime/pageUser";
		}
		
		
//		Map<String, Object> page = dnltimeSearchService.getPage(pageNo, memberForm);
//		model.addAttribute("page", page);
	}

//	@GetMapping("/item/{dnlno}")
//	public String getItemByDnlno(@PathVariable int dnlno, Model model){
//		log.info("getItem("+ dnlno + ")");
//		
//		Dnltime dnltime = dnltimeSearchService.getDnltimeByDnlno(dnlno, true);
//		model.addAttribute("dnltime", dnltime);
//		
//		return "dnltime/item";
//	}
	
	@GetMapping("/item/{dnlno}")
	public String getItemByDnlnoWithMembersrl(@PathVariable int dnlno, Model model){
		log.info("getItem("+ dnlno + ")");
		
				
		Dnltime dnltime = dnltimeSearchService.getDnltimeByDnlnoWithMembersrl(dnlno);
		model.addAttribute("dnltime", dnltime);
		
		return "dnltime/item";
	}
	
	@GetMapping("/member/{membersrl}")
	public String getMemberList(@PathVariable int membersrl, Model model){
		log.info("getMemberList()");
		
		List<Dnltime> dnltime = dnltimeSearchService.getmembersrl(membersrl);
		model.addAttribute("memberlist", dnltime);
		
		return "dnltime/member";
	}
	
}
