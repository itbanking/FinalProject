package com.example.admin;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Member.MemberSearchService;
import com.example.city.CitySearchController;
import com.example.city.service.CitySearchService;
import com.example.domain.City;
import com.example.domain.Member;
import com.example.mapper.MemberMapper;

@WebServlet("/Admin")
public class AdminController extends HttpServlet {
	
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
		
		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/Admin/Main.jsp");
		disp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("############");
		System.out.println("doPost().....");
		System.out.println("############");
	}	
	
	
}
