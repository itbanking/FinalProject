package com.example.sal.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Sal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalUnregisterServiceTests {

	@Autowired
	SalSearchService salSearchService;
	@Autowired
	SalUnregisterService salUnregisterService;
	
	@Test
	public void test00_confirm() {
		System.out.println("salunregister = " + salUnregisterService);
	}
	
	@Test
	public void test01_Saldelete() {
		Sal sal = salSearchService.getSalBySalno(51);
		if (sal == null){
			System.out.println("해당 sal_no 가 없습니다");
			return;
		}
		salUnregisterService.unregister(51);
		
		System.out.println("sal = 삭제 되었습니다.");
	}
	
}
