package UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Add_bean;
import Model.User_bean;

public class Show_taskdao {
	static Connection con;
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/all_functiontryout", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	public List<Add_bean> gettoalList() {
		List<Add_bean> list = new ArrayList<Add_bean>();
		Statement stmt = null;
		ResultSet rs = null;
		String qry = "select * from  todo_task";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(qry);
			while (rs.next()) {
				int id = rs.getInt(1);
				String taskname = rs.getString(2);
				String description = rs.getString(3);
				String status = rs.getString(4);
				Add_bean add_bean = new Add_bean();
				add_bean.setId(id);
				add_bean.setTaskname(taskname);
				add_bean.setTaskDiscriptin(description);
				add_bean.setStatus(status);
				list.add(add_bean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;

	}

	public int updatetask(Add_bean a) {
		int status = 0;
		PreparedStatement pstmt = null;
		String qry = "update todo_task set Task_name=?,Description=? where tid=?";
		try {
			pstmt = con.prepareStatement(qry);
			pstmt.setString(1, a.getTaskname());
			pstmt.setString(2, a.getTaskDiscriptin());
			// pstmt.setString(3, a.getStatus());
			pstmt.setInt(3, a.getId());
			/*
			 * System.out.println(a.getId());
			 * System.out.println(a.getTaskname()+" "+a.getTaskDiscriptin()+" "
			 * +a.getStatus()+" "+a.getId());
			 */
			status = pstmt.executeUpdate();
			if (status > 0) {
				System.out.println("updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return status;

	}

	public int deletetask(int id) {
		int status = 0;
		PreparedStatement pstmt = null;
		String qry = "delete from todo_task where tid=?";

		try {
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			status = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return status;

	}

	public Add_bean getEmployeeById(int id) {
		Add_bean add_bean = new Add_bean();
		PreparedStatement pstmt = null;
		String qry = "select * from todo_task where tid=?";
		try {
			pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				add_bean.setId(rs.getInt(1));
				add_bean.setTaskname(rs.getString(2));
				add_bean.setTaskDiscriptin(rs.getString(3));
				/* add_bean.setStatus(rs.getBoolean(4)); */
				add_bean.setStatus(rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return add_bean;

	}

	public List<User_bean> getuser() {
		List<User_bean> list = new ArrayList<User_bean>();
		Statement stmt = null;
		ResultSet rs = null;
		String qry = "select * from  td_table";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(qry);
			while (rs.next()) {
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String gender = rs.getString(4);
				String email = rs.getString(5);
				String psw = rs.getString(6);
				String cpsw = rs.getString(7);
				String Active = rs.getString(8);
				User_bean user_bean = new User_bean();
				user_bean.setId(id);
				user_bean.setFname(fname);
				user_bean.setLname(lname);
				user_bean.setGender(gender);
				user_bean.setEmail(email);
				user_bean.setPsw(psw);
				user_bean.setConfirm_psw(cpsw);
				user_bean.setActive(Active);
				list.add(user_bean);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;

	}

}
