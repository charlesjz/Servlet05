package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DefServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Def");
		
		Cookie[] cookies = req.getCookies();
		
		for(Cookie cookie : cookies){
			System.out.println(cookie.getName()+":"+cookie.getValue());
		}
		
		ServletConfig cfg= getServletConfig();
		String maxOnLine= cfg.getInitParameter("maxOnLine");
		System.out.println(maxOnLine);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	public void init() throws ServletException {
		
	}

}
