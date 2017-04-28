package com.example.dnltime.service;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.Validator;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DnltimeUnregisterServiceTests {

	@Autowired
	DnltimeSearchService dnltimeSearchService;
	
	@Autowired
	DnltimeUnregisterService dnltimeUnregisterService;
	
	@Autowired
	Validator validator;
	
	@Test
	public void test00_confirm(){
		System.out.println("dnltimeUnregisterService = " + dnltimeUnregisterService);
		System.out.println("dnltimeSearchService = " + dnltimeSearchService);
		System.out.println("Validator = " + validator);
	}
	

}
