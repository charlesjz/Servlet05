package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServTest02 extends HttpServlet {


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw =res.getWriter();
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		String now = simpleDateFormat.format(date);
		pw.println("<p>"+now+"</p>");
		pw.close();
	}
	

}
