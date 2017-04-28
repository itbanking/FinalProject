package com.example.sal.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Sal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalSearchServiceTests {
	
	@Autowired
	SalSearchService salSearchService;
	
	@Test
	public void test00_confirmService() {
		System.out.println("service = " + salSearchService);
	}
	
	@Test
	public void test01_getListAll() {
		List<Sal> list = salSearchService.getListAll();
		for (Sal s : list)
			System.out.println(s);
	}
	@Test
	public void test01_getListAllWithMember() {
		List<Sal> list = salSearchService.getListAll(true);
		for (Sal s : list)
			System.out.println(s);
	}
	
//	@Test
//	public void test02_getPage() {
//		Map<String, Object> map = salSearchService.getPage(1);
//		
//		List<Sal> list = (List<Sal>)map.get("sals");
//		
//		for (Sal s : list)
//			System.out.println(s);
//
//		System.out.println(map.get("paging"));
//	}
	
//	@Test
//	public void test02_getPageWithMember() {
//		Map<String, Object> map = salSearchService.getPage(2, true);
//		
//		List<Sal> list = (List<Sal>)map.get("sals");
//		
//		for (Sal s : list)
//			System.out.println(s);
//		
//		System.out.println(map.get("paging"));
//	}
	
	@Test
	public void test03_getSalBySalno() {
		Sal sal = salSearchService.getSalBySalno(15);
		System.out.println(sal);
	}
	@Test
	public void test03_getSalBySalno_WithMember() {
		Sal sal = salSearchService.getSalBySalno(11, true);		
		System.out.println(sal);
	}
}
