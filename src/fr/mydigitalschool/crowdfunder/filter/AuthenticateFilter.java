package fr.mydigitalschool.crowdfunder.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.http.HttpFilter;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

public class AuthenticateFilter extends HttpFilter {
	
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("AuthenticateFilter doFilter");
		
		if(request.getSession().getAttribute("login") == null) {
			response.sendRedirect("/Crowdfunder/login");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

