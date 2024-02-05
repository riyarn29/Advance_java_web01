package in.co.rays.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestQuerryString")
public class TestQuerryString extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in TestQuerryString get method");
		
		String operation =	req.getParameter("operation");
		String name =	req.getParameter("name");
		
		System.out.println("name="+name);
		System.out.println("operation="+operation);
	}
}
