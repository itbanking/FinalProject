package com.example.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/index")
public class IndexController {

	@GetMapping("/page")
	public String getList(){

		return "home/firstpage";
	}
	
}
