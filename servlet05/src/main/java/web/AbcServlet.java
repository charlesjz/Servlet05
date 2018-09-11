package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AbcServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		System.out.println(req.getServletContext());
		System.out.println(req.getContextPath());
		System.out.println(req.getRequestURI());
		System.out.println(req.getRequestURL());
		
		Cookie cookie = new Cookie("myCookie", "myCookieValue");
		res.addCookie(cookie);
		cookie = new Cookie("myCookie2", "myCookieValue2");
		res.addCookie(cookie);		
	}
	

	
	
	

}
