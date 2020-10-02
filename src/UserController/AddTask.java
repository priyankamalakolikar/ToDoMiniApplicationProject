package UserController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserDao.Add_dao;

/**
 * Servlet implementation class AddTask
 */
@WebServlet("/AddTask")

public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddTask() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String tname = request.getParameter("tuname");
		String tdic = request.getParameter("tdiscription");
		Add_dao addt = new Add_dao();
		addt.AddData(tname, tdic);

		RequestDispatcher rd = request.getRequestDispatcher("TodoTask.html");
		rd.forward(request, response);
	}

}
