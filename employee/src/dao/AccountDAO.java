package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {
	public Account findByLogin(Login login) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Account account = null;
		String sql = "SELECT * FROM employee WHERE employee_id = ? AND pass = ?";

		try {
			String url = "jdbc:mysql://localhost/system?characterEncoding=UTF-8&serverTimezone=Japan&useSSL=false";

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, "root", "pass");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login.getEmployeeId());
			pstmt.setString(2, login.getPass());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String employeeId = rs.getString("employee_id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String address = rs.getString("address");
				String department = rs.getString("department");
				account = new Account(employeeId, name, age, sex, address, department);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return account;
	}
}