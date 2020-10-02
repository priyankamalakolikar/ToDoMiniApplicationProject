package UserController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Add_bean;
import UserDao.Show_taskdao;

/**
 * Servlet implementation class Show_Task
 */
@WebServlet("/Show_Task")
public class Show_Task extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		// uid=Integer.parseInt(request.getParameter("id"));
		Show_taskdao abc = new Show_taskdao();

		List<Add_bean> TaskList = abc.gettoalList();

		out.print("<br/><a href=\"TodoTask.html\">back</a>");
		out.print("<br/><a href=\"HomeServlet\">Logout</a>");

		Add_bean pqr = new Add_bean();

		System.out.println("Helloooooooooo");
		out.println("<html><head></head><body bgcolor='#ffcccc'>");
		out.println("<h1>List Of Todos</h1>");
		out.println("<form name='form'>");
		out.println("<table border='1' width='100%'");
		out.println(
				"<tr><th>check</th><th>Id</th><th>Task_Name</th><th>Description</th><th>Status</th><th>Edit</th><th>Delete</th></tr>");

		for (Add_bean a : TaskList) {

			out.println("<tr><td><input type='checkbox' onChange='self.location.href=\"Change_Status?tid=" + a.getId()
					+ "\"'></td>");
			out.println("<td>" + a.getId() + "</td><td>" + a.getTaskname() + "</td><td>" + a.getTaskDiscriptin()
					+ "</td><td><p id='text' style='display:none'>completed</p>" + a.getStatus()
					+ "</td><td><a href='Editservlet2_c?id=" + a.getId() + "'>edit</a></td>  <td><a href='Delete_C?id="
					+ a.getId() + "'>delete</a></td></tr>");
		}

		// out.print("</table></body></html>");
		out.println("</table>");
		out.println("<form>");
		out.println("</html>");
	}

}
