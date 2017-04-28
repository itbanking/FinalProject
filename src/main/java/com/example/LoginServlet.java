package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.Member;
import com.example.mapper.MemberMapper;

@WebServlet("/Auth")
public class LoginServlet extends HttpServlet {

	@Autowired
	MemberMapper memberMapper;
	
	void printParam(HttpServletRequest req) {
		Enumeration<String> names = req.getParameterNames();
		while(names.hasMoreElements()) {
			String name = names.nextElement();
			System.out.println(name + " = " + req.getParameter(name));
		}
		System.out.println(req.getParameterMap());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("############");
		System.out.println("doGet().....");
		System.out.println("############");
		
		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/Auth/memberform.jsp");
		disp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("############");
		System.out.println("doPost().....");
		System.out.println("############");
		

		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		PrintWriter out = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		//ID 가 있는경우에만 인증처리
		if ( IsExistingId(id) ) {
			if ( !IsAllowed(id) ) {
				resp.sendRedirect("/NoPermission");
			}
			else {
				//id 에 저장된 암호화된 비밀번호를 가져온다.
				String Match = GetPassword(id);
				
				//받아온 password 를 md5형식으로 인코딩
				String PasswordEncoded = ConvertMD5(pw);
				
				if ( Match.equals(PasswordEncoded) ) {
					// 인증성공
					HttpSession session = req.getSession();
					session.setAttribute("logged", true);
					session.setAttribute("ID", id);
					if ( IsAdmin(id) ) {
						session.setAttribute("IsAdmin", true);
						resp.sendRedirect("/index/page");
//						resp.sendRedirect("/country/page/1");
					}
					else {
						resp.sendRedirect("/index/page");
//						resp.sendRedirect("/city/page/1");
					}
				} 
				else {
					// 인증실패
					resp.sendRedirect("/Auth?error");
				}
			}
		}
		else {
			resp.sendRedirect("/Auth?error");
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
	
	public Boolean IsExistingId(String id) {
		Member member = memberMapper.selectById(id);
		if ( member != null ) {
			return true;
		}
		return false;
	}
	
	public Boolean IsAdmin(String id) {
		Member member = memberMapper.selectById(id);
		if ( member.getIsadmin().equals("Y") ) {
			return true;
		}
		return false;
	}
	
	public Boolean IsAllowed(String id) {
		Member member = memberMapper.selectById(id);
		if ( member.getIsallowed().equals("Y") ) {
			return true;
		}
		return false;
	}
	
	public String GetPassword(String id) {
		Member member = memberMapper.selectById(id);
		String str = member.getPassword();
		return str;
	}
	
}
