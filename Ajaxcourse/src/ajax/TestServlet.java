package ajax;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		System.out.println(request.getMethod());
		System.out.println(request.getParameter("a"));
		System.out.println(request.getParameter("b"));
		System.out.println(request.getParameter("c"));
		out.print("connection server ok");
	}

	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		System.out.println(request.getMethod());
		System.out.println(request.getParameter("a"));
		System.out.println(request.getParameter("b"));
		System.out.println(request.getParameter("c"));
		out.print("post connection server ok");
	}

}
