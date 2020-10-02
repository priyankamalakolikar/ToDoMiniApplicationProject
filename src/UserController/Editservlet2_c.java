package UserController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Add_bean;
import UserDao.Show_taskdao;

@WebServlet("/Editservlet2_c")
public class Editservlet2_c extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Editservlet2_c() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Task</h1>");

		String tid = request.getParameter("id");
		int id = Integer.parseInt(tid);
		Show_taskdao pp = new Show_taskdao();
		Add_bean ab = pp.getEmployeeById(id);
		out.print("<form action='Edit_C' method='post'>");

		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='" + ab.getId() + "'/></td></tr>");
		out.print("<tr><td>TaskName:</td><td><input type='text' name='tname' value='" + ab.getTaskname()
				+ "'/></td></tr>");
		out.print("<tr><td>TaskDiscription:</td><td><input type='text' name='tdesc' value='" + ab.getTaskDiscriptin()
				+ "'/></td></tr>");
		// out.print("<tr><td>Status:</td><td><input type='text' name='status'
		// value='"+ab.getStatus()+"'/></td></tr>");
		out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
		out.print("</table>");
		out.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
