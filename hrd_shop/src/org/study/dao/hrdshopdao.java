package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class hrdshopdao {
	
	
	public static Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@//localhost:1521/xe", 
				"sys_user", 
				"1234");
		return con;
	}
	
	
	
	
	
	
	public int getNextMemberId() throws Exception {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;

		if (conn != null) {
			String sql = "select * from (" + 
					"select custno from MEMBER_TBL_02 " + 
					"order by custno desc) " + 
					"where rownum = 1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			} else {
				result = -1;
			}
			
			if (ps != null) {
				ps.close();
			}
			
			if (rs != null) {
				rs.close();
			}
			
			conn.close();
		}
		
		return result + 1;
	}
}
