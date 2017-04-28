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

import com.example.domain.Dnltime;
import com.example.form.MemberForm;
import com.example.util.Pagination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DnltimeMapperTests {

	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	DnltimeMapper dnltimeMapper;
	
	@Autowired
	DnlMapper dnlMapper;
	
	@Test
	public void test00_confirm(){
		System.out.println("dnltimeMapper = " + dnltimeMapper);
	}
	
	@Test
	public void test01_selectAll(){
		List<Dnltime> list = dnltimeMapper.selectAll();
		
		for(Dnltime d : list){
			System.out.println("dnltime = " + d);
		}
	}
	
	@Test
	public void test01_selectAllWithDnl(){
		List<Dnltime> list = dnltimeMapper.selectAllWithDnl();
		
		for(Dnltime d : list){
			System.out.println("dnltime = " + d);
		}		
	}
	
//	@Test
//	public void test02_selectPage(){
//		Pagination paging = new Pagination();
//		paging.setTotalItem(dnltimeMapper.selectTotalCount());
//		paging.setPageNo(1);
//		
//		MemberForm memberForm;
//		
////		List<Dnltime> list = dnltimeMapper.selectPage(paging, memberForm);
//		
//		for(Dnltime d : list)
//			System.out.println(d);
//	}
	
	@Test
	public void test02_selectPageWithDnl(){
		Pagination paging = new Pagination();
		paging.setTotalItem(dnltimeMapper.selectTotalCount());
		paging.setPageNo(2);
		
		List<Dnltime> list = dnltimeMapper.selectPageWithDnl(paging);
		
		for(Dnltime d : list)
			System.out.println(d);
	}
	
	@Test
	public void test03_selectByDnlno(){
		Dnltime dnltime = dnltimeMapper.selectByDnlno(5);
		
		System.out.println("dnltime = " + dnltime);
	}
	
	@Test
	public void test03_selectByDnlnoWithDnl(){
		Dnltime dnltime = dnltimeMapper.selectByDnlnoWithDnl(1);
		
		System.out.println("dnltime = " + dnltime);
	}
	
	@Test
	public void test03_selectByDnlnoWithMember(){
		Dnltime dnltime = dnltimeMapper.selectByDnlnoWithMember(1);
		
		System.out.println("dnltime = " + dnltime);
	}
	@Test
	public void test04_insert() throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		
		Date attend = format.parse("2017/03/23 11:10:09");
		
		Dnltime dnltime = new Dnltime();
		dnltime.setDnlCode(02);
		dnltime.setAttend(attend);
		dnltime.setLeave(new Date());
		dnltime.setReason("병원내원");
		dnltime.setMembersrl(new BigDecimal(1));
		
		int rtn = dnltimeMapper.insert(dnltime);
		
		Dnltime n =  dnltimeMapper.selectByDnlno(dnltime.getDnlno());
		System.out.println(n);
		System.out.println("Attend=" + format.format(n.getAttend()));
		
	}
}
