package ydmusic.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLUser {

	DBhelper dbhelper = new DBhelper();

	public boolean isUser(String name, String password) {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		boolean flag = false;
		try {
			conn = dbhelper.getConnection();
			String sql = "SELECT * FROM musicuser WHERE username = ? AND password = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, name);
			preStmt.setString(2, password);
			rs = preStmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, rs);
		}
		return flag;
	}


	public boolean addUser(String name, String password, String telnumber) {
		PreparedStatement preStmt = null;
		int rs = 0;
		Connection conn = null;
		boolean flag = false;
		try {
			conn = dbhelper.getConnection();

			String sql = "insert into musicuser (username,password,telnumber) values(?,?,?)";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, name);
			preStmt.setString(2, password);
			preStmt.setString(3, telnumber);
			System.out.println(preStmt);
			rs = preStmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbhelper.closeAll(conn, preStmt, null);
		}
		return rs > 0;
	}

	public static void main(String[] args) {
		MySQLUser mySQLUser = new MySQLUser();
//		boolean user = mySQLUser.isUser("古才良1", "123456");
//		System.out.println(user);
		
		boolean addUser = mySQLUser.addUser("5", "123456", "123456");
		System.out.println(addUser);
		
	}

}
