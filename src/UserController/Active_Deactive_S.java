package UserController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Active_Deactive_S")
public class Active_Deactive_S extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static int uid;
	static Connection con;

	

	public static void ActiveUpdate() {
		String active;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/all_functiontryout", "root", "root");
			stm = con.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);

			rs = stm.executeQuery("select * from td_table");

			while (rs.next()) {
				if (uid == rs.getInt("id")) {

					active = rs.getString("Active");

					if (active.equals("yes")) {
						rs.updateString(8, "not");
						active = "not";
					} else {
						rs.updateString(8, "yes");
						active = "yes";
					}
					rs.updateRow();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex);
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
			if(stm!=null)
			{
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		uid = Integer.parseInt(request.getParameter("id"));
		ActiveUpdate();
		 
		request.getRequestDispatcher("Admi_C").forward(request, response);

		out.close();
	}

}
