package UserController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Add_bean;
import Model.User_bean;
import UserDao.Show_taskdao;

@WebServlet("/Admi_C")
public class Admi_C extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Admi_C() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Show_taskdao abc = new Show_taskdao();
		List<User_bean> list = abc.getuser();
		out.println("<html><head></head><body bgcolor='#ffcccc'>");
		out.println("<h1>Users Information</h1>");
		out.println("<form name='form'>");
		out.print("<br/><a href=\"HomeServlet\">Logout</a>");
		out.print("<br/><a href=\"Report_Servlet\">Graph</a>");
		out.print("<table border='1' width='100%'");

		out.print("<tr><th>Id</th><th>fanme</th><th>lname</th><th>Status</th><th>Activate_Deactivate</th></tr>");
		for (User_bean a : list) {

			out.print("<tr><td>" + a.getId() + "</td><td>" + a.getFname() + "</td><td>" + a.getLname() + "</td><td>"
					+ a.getActive() + "</td><td><a href='Active_Deactive_S?id=" + a.getId()
					+ "'>Change_Status</td></tr>");
		}
		out.print("</table>");
		out.println("<form>");
		out.println("</html>");
	}

}
