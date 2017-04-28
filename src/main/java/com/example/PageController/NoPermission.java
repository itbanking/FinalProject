package com.example.PageController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NoPermission")
public class NoPermission extends HttpServlet {
	
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
