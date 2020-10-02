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

@WebServlet("/Edit_C")
public class Edit_C extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Edit_C() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();
		// System.out.println("hello");
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String taskname = request.getParameter("tname");
		String description = request.getParameter("tdesc");
		String sta = request.getParameter("status");

		Add_bean add_bean = new Add_bean();
		add_bean.setId(id);
		add_bean.setTaskname(taskname);
		add_bean.setTaskDiscriptin(description);
		add_bean.setStatus(sta);

		Show_taskdao st = new Show_taskdao();
		int status = st.updatetask(add_bean);
		// System.out.println(status);
		if (status > 0) {
			response.sendRedirect("Show_Task");
		} else {
			out.println("Sorry! unable to update record");
		}
	}

}
