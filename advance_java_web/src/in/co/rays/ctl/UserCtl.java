package in.co.rays.ctl;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		UserBean bean = null;
		if (id != null) {
			System.out.println("in if get user ctl");
			UserModel model = new UserModel();
			try {
				bean = model.findPk(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		req.setAttribute("bean", bean);
		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String id = req.getParameter("id");
		String fname = req.getParameter("firstName");
		String lname = req.getParameter("lastName");
		String login = req.getParameter("loginId");
		String pass = req.getParameter("password");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String op = req.getParameter("operation");

		UserBean bean = new UserBean();
		if (id != null && !(id.equals(""))) {
			bean.setId(Integer.parseInt(id));
		}
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

		if (op.equals("save")) {
			try {
				model.add(bean);
				req.setAttribute("msg", "User added successfully...!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			model.add(bean);
			req.setAttribute("msg", "user added successfully..!!!");
		} catch (Exception e) {
			e.printStackTrace();

		}
		if (op.equals("update")) {
			
			System.out.println("");
			try {
				model.update(bean);
				bean = model.findPk(bean.getId());
				req.setAttribute("bean", bean);
				req.setAttribute("msg", "user updated successfully..!!!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("UserView.jsp");
		rd.forward(req, resp);

	}
}
