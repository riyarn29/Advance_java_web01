package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("UserRegistrationView.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
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
		
		UserBean bean= new UserBean();
		bean.setFirstName(fname);
		bean.setLastName(lname);
		bean.setLoginId(login);
		bean.setPassword(pass);
		try {
			bean.setDob(sdf.parse(dob));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		bean.setAddress(address);
		
		UserModel model = new UserModel();
		try {
			model.add(bean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		resp.sendRedirect("UserRegistrationView.jsp");
	}
}
