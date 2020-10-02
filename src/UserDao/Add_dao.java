package UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Add_dao {
	static Connection con;
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/all_functiontryout", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void AddData(String tname,String Discription)
	{
		PreparedStatement pStmt =null;
		String qry ="insert into todo_task(Task_name, Description,Status) values(?,?,?);";
		
		try {
			pStmt=con.prepareStatement(qry);
			pStmt.setString(1,tname);
			pStmt.setString(2, Discription);
			pStmt.setString(3, "pending");
			int done = pStmt.executeUpdate();
			if(done>0)
			{
				System.out.println("added successfully ");
			}
			else
			{
				System.out.println("Sorry failed. . .");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
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
