package UserController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Login_bean;
import Model.User_bean;
import UserDao.Login_Dao;

@WebServlet("/Login_Controller")
public class Login_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* response.setContentType("text/Login.html"); */
		PrintWriter out = response.getWriter();

		String username = request.getParameter("uname");

		String password = request.getParameter("psw");
		
		Login_Dao ld = new Login_Dao();
		// User_bean abc=new User_bean ();
		if (ld.validate(username, password)) {
			System.out.println("done login");

			RequestDispatcher rd = request.getRequestDispatcher("TodoTask.html");
			rd.forward(request, response);
		} else if (username.equals("Admin") && password.equals("Admin")) {
			System.out.println("ADmIN login Done");
			RequestDispatcher rd = request.getRequestDispatcher("Admi_C");
			rd.forward(request, response);
		} else {

			System.out.println("Sorry username or password error");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}

		out.close();

	}
}
