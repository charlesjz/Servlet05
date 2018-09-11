package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)req;
		System.out.println(request.getServletPath());
		
		System.out.println("Before...");
		chain.doFilter(req, res);
		System.out.println("After...");

	}

	public void destroy() {
		System.out.println("Ending...");
	}
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Begining...");
	}

}
