package com.example.memo;

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

import com.example.domain.Memo;
import com.example.form.MemoForm;
import com.example.memo.service.MemoModifyService;
import com.example.memo.service.MemoSearchService;

@Controller
@RequestMapping("/memo")
public class MemoModifyController {
	
	static Log log = LogFactory.getLog(MemoModifyController.class);
	
	@Autowired
	MemoSearchService memoSearchService;
	
	@Autowired
	MemoModifyService memoModifyService;
	
	@GetMapping("/modify/{mno}")
	public String ModifyForm(MemoForm memoForm, @PathVariable int mno, Model model) {
		log.info("modifyForm(" + mno + ")");
		
		Memo memo = memoSearchService.getMemoByMno(mno);
		
//		if(memo.getMcontent() != null) {
//			String content = memoForm.getMcontent();
//			content = content.replace("\u0020", "&nbsp");
//			content = content.replace("\r\n", "<br>");
//			memoForm.setMcontent(content);
//		}
		
		memoForm.setMemo(memo);
		
		model.addAttribute("memo", memoForm);
		
		return "memo/modifyForm";
	}
	
	@PostMapping("/modify")
	public String modify(@Valid MemoForm memoForm, BindingResult errors, Integer pageNo) {
		log.info("modify(" + memoForm + ")");
		System.out.println(memoForm);
//		
//		String content = memoForm.getMcontent();
//		content = content.replace("\u0020", "&nbsp");
//		content = content.replace("\r\n", "<br>");
//		memoForm.setMcontent(content);
		
		if (errors.hasErrors()){
			System.out.println(errors);
			return "memo/modifyForm";
		}
		memoModifyService.modify(memoForm, errors);
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "memo/modifyForm";
		}
		return "redirect:/memo/modifySuccess/" + memoForm.getMno() + "?pageNo=" + pageNo;
	}
	
	@GetMapping("/modifySuccess/{mno}")
	public String modifySuccess(@PathVariable int mno, Model model) {
		Memo memo = memoSearchService.getMemoByMno(mno);
		model.addAttribute("memo", memo);
		return "memo/modifySuccess";
	}
}

