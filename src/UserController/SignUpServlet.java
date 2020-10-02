package UserController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserDao.EmailNotifiaction;
import UserDao.User_Dao;

@WebServlet("/sign")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hi done");

		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String psw = request.getParameter("psw");
		String cpsw = request.getParameter("psw-repeat");

		if (psw.equals(cpsw)) {
			User_Dao userdao = new User_Dao();
			int r = new Random().nextInt(999999);
			OtpVerify abc = new OtpVerify();
			abc.getOtp(r);

			abc.getData(fname, lname, gender, email, psw, cpsw);

			EmailNotifiaction abcd = new EmailNotifiaction();
			String number = String.valueOf(r);
			abcd.sendotpemail(email, number);
			response.sendRedirect("otpchecking.html");
			userdao.InsertData(fname, lname, gender, email, psw, cpsw);
		} else {
			PrintWriter pw = response.getWriter();
			pw.write("<h1>Password and cpass is not matching</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);

		}

	}
}
