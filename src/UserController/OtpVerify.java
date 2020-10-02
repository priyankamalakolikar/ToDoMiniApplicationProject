package UserController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserDao.User_Dao;

@WebServlet("/OtpVerify")
public class OtpVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static int otp;
	String fname;
	String lname;
	String gender;
	String email;
	String psw;
	String cpsw;

	public void getData(String firstname, String lastname, String gender1, String email1, String password1,
			String confirmpass1) {

		fname = firstname;
		lname = lastname;
		gender = gender1;
		email = email1;
		psw = password1;
		cpsw = confirmpass1;

	}

	public void getOtp(int i) {
		otp = i;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		String uotp = request.getParameter("otp");

		if (otp == Integer.parseInt(uotp)) {
			System.out.println("verifed otp");
			User_Dao userdao = new User_Dao();
			response.sendRedirect("Login.html");
		}

		else {
			response.sendRedirect("Wrongmsg.html");
			System.out.println("Sorry ");
		}
	}

}
