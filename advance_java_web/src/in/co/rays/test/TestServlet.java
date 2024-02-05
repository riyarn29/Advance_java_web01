package in.co.rays.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in get method");
		System.out.println("method="+req.getMethod());
		System.out.println("URI="+req.getRequestURI());
		System.out.println("protocol="+req.getProtocol());
		System.out.println("remote address="+req.getRemoteAddr());
		
		Enumeration e= req.getHeaderNames();
		while (e.hasMoreElements()) {
			String name = (String) e.nextElement();
			String value= req.getHeader(name);
			System.out.println(name +"="+value);
		}
		}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in post method");
		String fname = req.getParameter("firstName");
		String lname= req.getParameter("lastName");
		String login= req.getParameter("loginId");
		String pass= req.getParameter("password");
		String dob= req.getParameter("dob");
		String address= req.getParameter("address");
		System.out.println("first name = "+fname);
		System.out.println("last name = "+lname);
		System.out.println("loginId = "+login);
		System.out.println("password = "+pass);
		System.out.println("dob = "+dob);
		System.out.println("address = "+address);
		
	}
}
