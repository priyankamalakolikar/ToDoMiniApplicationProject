package UserController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Add_bean;

/**
 * Servlet implementation class Change_Status
 */
@WebServlet("/Change_Status")
public class Change_Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static int tid;
	static Connection con;

	public static int updatestaus(int tid) {
		int status = 0;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		System.out.println(tid);
		// Add_bean a=new Add_bean ();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/all_functiontryout", "root", "root");
			
			pstmt1 = con.prepareStatement("select * from todo_task where tid=?");
			pstmt1.setInt(1, tid);

			rs = pstmt1.executeQuery();
			PreparedStatement pstmt = null;
			String qry = "update todo_task set Status=? where tid=?";
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(2, tid);
			rs.next();
			if (rs.getString("Status").equals("Completed")) {
				pstmt.setString(1, "Pending");

			}

			else {
				pstmt.setString(1, "Completed");

			}

			status = pstmt.executeUpdate();
			if (status > 0) {
				System.out.println("updated");

				return status;
			} else {
				return status;
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("Sorryyyyyyyyyyyy");
			return status;
		}
		finally{
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt1!=null)
			{
				try {
					pstmt1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// System.out.println("yeyeyeye");
		PrintWriter out = response.getWriter();
		out.println("<html><head></head><body onload=\"alert('hello')\"></body></html>");

		tid = Integer.parseInt(request.getParameter("tid"));
		if (updatestaus(tid) == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("Show_Task");
			rd.forward(request, response);

		}

	}

}
