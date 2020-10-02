package UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Login_bean;

public class Login_Dao {
	static Connection con;
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/all_functiontryout", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	public boolean validate(String username, String password) {
		
		boolean status = false;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement("select * from td_table where fname = ? and psw = ?;");
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();
			status = rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			if(pStmt!=null)
			{
				try {
					pStmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return status;

	}

}
