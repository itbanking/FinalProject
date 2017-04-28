package com.example.Member;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.example.domain.Member;
import com.example.mapper.MemberMapper;


@Service
public class MemberRegisterService {
	
	@Autowired
	MemberMapper memberMapper;
	
	public void register( Member member, BindingResult errors ) {
		
		Member validate = memberMapper.selectByMembersrl( member.getMembersrl() );
		
		if ( validate != null ) {
			errors.reject("Member already exists", "해당 시리얼에 회원이 이미 존재합니다..");
		}
		
		if ( !errors.hasErrors() ) {
			//Encrypt Password
			member.setPassword( ConvertMD5( member.getPassword() ) );
			
			memberMapper.insert(member);
		}
	}
	
	public String ConvertMD5(String str){
		String MD5 = ""; 
		try{
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(str.getBytes()); 
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer(); 
			for(int i = 0 ; i < byteData.length ; i++){
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100, 16).substring(1));
			}
			MD5 = sb.toString();
		}
		catch(NoSuchAlgorithmException e){
			e.printStackTrace(); 
			MD5 = null; 
		}
		return MD5;
		
	}
	

}
