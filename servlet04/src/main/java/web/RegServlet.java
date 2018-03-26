package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username="+username);
		System.out.println("password="+password);
		if("123".equals(password)){
			res.setContentType("text/html");
			PrintWriter writer = res.getWriter();
			writer.println("Congratulation! "+username+" login successful!");
		}else {
			
		}
	}

}
