package com.example.mapper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Member;
import com.example.domain.Sal;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SalMapperTests {
	
	@Autowired
	SalMapper salMapper;
	
	@Autowired
	MemberMapper memberMapper;
	
	@Test
	public void test00_confirmSalMapper() {
		System.out.println("salmapper = " + salMapper);
	}
	
	@Test
	public void test01_selectAll() {
		List<Sal> list = salMapper.selectAll();
		
		for (Sal s : list)
			System.out.println(s);
	}
	@Test
	public void test01_selectAllWithMember() {
		List<Sal> list = salMapper.selectAllWithMember();
		
		for (Sal s : list)
			System.out.println(s);
	}
	
	
//	@Test
//	public void test02_selectPage() {
//		Pagination paging = new Pagination();
//		paging.setTotalItem(salMapper.selectTotalCount());
//		paging.setPageNo(1);
//		
//		List<Sal> list = salMapper.selectPage(paging);
//		
//		for (Sal s : list)
//			System.out.println(s);
//	}
	@Test
	public void test02_selectPageWithMember() {
		Pagination paging = new Pagination();
		paging.setTotalItem(salMapper.selectTotalCount());
		paging.setPageNo(2);
		
		List<Sal> list = salMapper.selectPageWithMember(paging);
		
//		for (Sal s : list) 
		for (int i=0; i<list.size(); i++) {
			Sal s = list.get(i);
			System.out.println(s);
		}
	}
	
	@Test
	public void test03_selectBySalno() {
		Sal sal = salMapper.selectBySalno(10);
		
		System.out.println(sal);
	}
	@Test
	public void test03_selectBySalnoWithMember() {
		Sal sal = salMapper.selectBySalnoWithMember(11);
		
		System.out.println(sal);
	}
	
	@Test
	public void test04_insert() throws ParseException {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		Date salaryDate = format.parse("2017-04-20");
		
		Sal sal = new Sal();
		sal.setBasicSal(new BigDecimal(200));
		sal.setMembersrl(new BigDecimal(1));
		sal.setSaldate(salaryDate);
		
		Member member = memberMapper.selectByMembersrl(sal.getMembersrl());
		
		if (member == null) {
			System.out.println("error = 해당 Member_srl이 없습니다");
			return;
		}
		
		int cnt = salMapper.insert(sal);
		System.out.println(salMapper.selectBySalno(sal.getSalno()));
	}
	
	@Test
	public void test05_updateBySalno() {
		Sal sal = salMapper.selectBySalno(29);
		sal.setComm(new BigDecimal(300));
		sal.setOvertimeSal(new BigDecimal(40));
		
		Member member = memberMapper.selectByMembersrl(sal.getMembersrl());
		
		if (member == null) {
			System.out.println("error = 해당 Member_srl이 없습니다.");
			return;
		}
		
		int cnt = salMapper.updateBySalno(sal);
		System.out.println(salMapper.selectBySalno(sal.getSalno()));
		
	}
	
	@Test
	public void test06_deleteBySalno() {
		int salno = 30;
		int rtn = salMapper.deleteBySalno(salno);
		System.out.println("rtn = " + rtn);
	}
}
