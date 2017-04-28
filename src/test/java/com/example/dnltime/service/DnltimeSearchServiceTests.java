package com.example.dnltime.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dnltime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DnltimeSearchServiceTests {

	
	@Autowired
	DnltimeSearchService dnltimeSearchService;
	
	@Test
	public void test00_confirm(){
		System.out.println("dnltimeSearchService = " + dnltimeSearchService);
	}
	
	@Test
	public void test01_getListAll(){
		List<Dnltime> list = dnltimeSearchService.getListAll();
		
		for(Dnltime d : list)
			System.out.println(d);
	}
	
	@Test
	public void test01_getListAll_WithDnl(){
		List<Dnltime> list = dnltimeSearchService.getListAll(true);
		
		for(Dnltime d : list)
			System.out.println(d);
	}
	
//	@Test
//	public void test02_getPage(){
//		Map<String,Object> map = dnltimeSearchService.getPage(1, 1);
//		List<Dnltime> list = (List<Dnltime>)map.get("dnltimeList");
//		
//		for(Dnltime d : list)
//			System.out.println(d);
//			System.out.println(map.get("paging"));
//	}
//	@Test
//	public void test02_getPageWithDnl(){
//		Map<String,Object> map = dnltimeSearchService.getPage(1, 1, true);
//		List<Dnltime> list = (List<Dnltime>)map.get("dnltimeList");
//		
//		for(Dnltime d : list)
//			System.out.println(d);
//			System.out.println(map.get("paging"));
//	}
	
	@Test
	public void test03_getDnl(){
		Dnltime dnl = dnltimeSearchService.getDnltimeByDnlno(26);
		
		System.out.println(dnl);
	}
	
	@Test
	public void test03_getDnlByDnlno(){
		Dnltime dnl = dnltimeSearchService.getDnltimeByDnlno(26, true);
		
		System.out.println(dnl);
	}
}
