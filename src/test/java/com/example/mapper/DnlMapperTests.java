package com.example.mapper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Dnl;
import com.example.domain.Dnltime;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DnlMapperTests {

	@Autowired
	DnlMapper dnlMapper;
	
	@Test
	public void test00_confirm(){
		System.out.println("dnlMapper = " + dnlMapper);
	}
	
	@Test
	public void test01_selectAll(){
		List<Dnl> list = dnlMapper.selectAll();
		
		for(Dnl d : list){
			System.out.println("dnl = " + d);
		}
	}
	
	@Test
	public void test01_selectAllWithDnltime(){
		List<Dnl> list = dnlMapper.selectAllWithDnltime();
		
		for(Dnl d : list){
			System.out.println("dnl = " + d);
		}		
	}
	@Test
	public void test02_selectPage(){
		Pagination paging = new Pagination();
		paging.setTotalItem(dnlMapper.selectTotalCount());
		paging.setPageNo(2);
		
		List<Dnl> list = dnlMapper.selectPage(paging);
		
		for(Dnl d : list){
			System.out.println("dnl = " + d);
		}		
	}		
	@Test
	public void test02_selectPageWithDnltime(){
		Pagination paging = new Pagination();
		paging.setTotalItem(dnlMapper.selectTotalCount());
		paging.setPageNo(2);
		
		List<Dnl> list = dnlMapper.selectPageWithDnltime(paging);
		
		for(Dnl d : list){
			System.out.println("dnl = " + d);
		}		
	}	
	
	@Test
	public void test03_selectByDnlcode(){
		Dnl dnl = dnlMapper.selectByDnlCode(00);
		
		System.out.println("dnl = " + dnl);
	}

	@Test
	public void test03_selectByDnlcodeWithDnltime(){
		Dnl dnl = dnlMapper.selectByDnlCodeWithDnltime(00);
		
		System.out.println("dnl = " + dnl);
	}
}
