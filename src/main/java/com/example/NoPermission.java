package com.example;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.mapper.MemberMapper;

@WebServlet("/NoPermission")
public class NoPermission extends HttpServlet {

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
		
		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/Auth/NoPermission.jsp");
		disp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("############");
		System.out.println("doPost().....");
		System.out.println("############");
	}	
	
}
