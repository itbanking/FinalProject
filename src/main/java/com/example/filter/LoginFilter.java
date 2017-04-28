package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
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

@WebFilter("/*")
public class LoginFilter implements Filter {

	static Log log = LogFactory.getLog(LoginFilter.class);
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
		
		String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", ""); 
		
		HttpSession session = req.getSession();
		
		Boolean logged = (Boolean) session.getAttribute("logged");
		Boolean Viewable = CheckViewablePaths(path);
		
		if ( Viewable || ( logged != null && logged ) ) {
			chain.doFilter(request, response);
		}
		else {
			resp.sendRedirect("/Auth");
		}
		
	}
	
	public Boolean CheckViewablePaths(String path) {
		if ( 	path.equals("/Auth") 
			 || path.contains("/Sign_in")
			 || path.equals("/NoPermission") 
			 || path.contains("/css") 
		   ) {
			return true;
		}
		return false;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
