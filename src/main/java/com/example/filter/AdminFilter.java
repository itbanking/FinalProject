package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebFilter("/Admin/*")
public class AdminFilter implements Filter {

	static Log log = LogFactory.getLog(AdminFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		log.info("##########");
		log.info("doFilter()");
		log.info("##########");
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		Boolean logged = (Boolean) session.getAttribute("logged");
		Boolean IsAdmin = (Boolean) session.getAttribute("IsAdmin");
		
		if ( logged != null && logged ) {
			if ( IsAdmin != null && IsAdmin ) {
				chain.doFilter(request, response);
			}
			else {
				resp.sendRedirect("/NoPermission");
			}
		}
		else {
			resp.sendRedirect("/Auth");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
