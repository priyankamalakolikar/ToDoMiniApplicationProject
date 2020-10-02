package UserController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserDao.Show_taskdao;

@WebServlet("/Delete_C")
public class Delete_C extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Delete_C() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		String tid = request.getParameter("id");
		int id = Integer.parseInt(tid);
		Show_taskdao st = new Show_taskdao();
		st.deletetask(id);
		response.sendRedirect("Show_Task");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
