package in.co.rays.test;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	System.out.println("first servlet do get method");
//		resp.sendRedirect("SecondServlet");
		
		RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
	rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	System.out.println("first servlet do post method");

//		resp.sendRedirect("SecondServlet");
		
RequestDispatcher rd = req.getRequestDispatcher("SecondServlet");
	rd.forward(req, resp);

	}

}
