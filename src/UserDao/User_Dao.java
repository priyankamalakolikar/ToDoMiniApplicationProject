package UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User_Dao {
	static Connection con;
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/all_functiontryout", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	//.user_logininfo

	public void InsertData(String fname, String lname,String gender,String email,String psw,String cpsw)
	{
		PreparedStatement pStmt =null;
		String qry = "insert into td_table(fname, lname, gender, email, psw, cpsw,Active) values(?,?,?,?,?,?,?);";
		try {
			pStmt=con.prepareStatement(qry);
			pStmt.setString(1, fname);
			pStmt.setString(2, lname);
			pStmt.setString(3, gender);
			pStmt.setString(4, email);
			pStmt.setString(5, psw);
			pStmt.setString(6, cpsw);
			pStmt.setString(7, "yes");
			
			int effectedRows = pStmt.executeUpdate();
			if(effectedRows>0)
			{
				System.out.println(" successfully registerd");
			}
			else
			{
				System.out.println("Sorry failed. . .");
			}

			
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


		
	}
}
