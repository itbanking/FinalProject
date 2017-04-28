package com.example.memo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Memo;
import com.example.domain.Sal;
import com.example.form.MemoForm;
import com.example.form.SalForm;
import com.example.memo.service.MemoSearchService;
import com.example.memo.service.MemoUnregisterService;
import com.example.sal.service.SalSearchService;
import com.example.sal.service.SalUnregisterService;

@Controller       
@RequestMapping("/memo")
public class MemoUnregisterController {

	static Log log = LogFactory.getLog(MemoUnregisterController.class);
	
	@Autowired
	MemoSearchService memoSearchService;
	
	@Autowired
	MemoUnregisterService memoUnregisterService;
	
	@GetMapping("/unregister/{mno}")
	public String unregisterForm(MemoForm memoForm, @PathVariable int mno, Model model) {
		log.info("unregister(" + mno + ")");
		Memo memo = memoSearchService.getMemoByMno(mno);
		memoForm.setMemo(memo);
		model.addAttribute("memo", memoForm);
		
		return "memo/unregisterForm";
	}
	
	@PostMapping("/unregister/{mno}")
	public String unregister(@PathVariable int mno, Integer pageNo) {
		log.info("unregidter(" + mno + ")");
		
		memoUnregisterService.unregister(mno);
		
		return "redirect:/memo/unregisterSuccess/" + mno + "?pageNo=" + pageNo;
	}
	@GetMapping("/unregisterSuccess/{mno}")
	public String unregisterSuccess(@PathVariable int mno, Model model) {
		log.info("unregisterSuccess(" + mno + ")");
		Memo memo = memoSearchService.getMemoByMno(mno);
		model.addAttribute("memo", memo);
		return "memo/unregisterSuccess";
	}
}
