package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.study.model.Member;
import org.study.model.Sale;


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
	
	public Member getMemberInfo(Integer id) throws Exception {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = null;
		
		if (conn != null) {
			String sql = "select * from MEMBER_TBL_02 where CUSTNO=? ";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				member = new Member();
				member.setId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setPhone(rs.getString(3));
				member.setAddress(rs.getString(4));
				member.setJoin_date(rs.getDate(5));
				member.setGrade(rs.getString(6));
				member.setCity_code(rs.getString(7));
			}
			
			if (ps != null) {
				ps.close();
			}
			
			if (rs != null) {
				rs.close();
			}
			
			conn.close();
		}
		
		return member;
	}
	public boolean registerMember(Member member) throws Exception  {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int result = 0;

		System.out.println(member);
		
		if (conn != null) {
			String sql = "INSERT INTO member_tbl_02(" + 
					"custno , custname , phone , address , joindate , grade , city)"+ 
					" VALUES (?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, member.getId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getPhone());
			ps.setString(4, member.getAddress());
			ps.setDate(5, member.getJoin_date());
			ps.setString(6, member.getGrade());
			ps.setString(7, member.getCity_code());
			
			result = ps.executeUpdate();
			
			if (ps != null) {
				ps.close();
			}
			
			
			
			conn.close();
		}
		
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Member> getMemberList() throws Exception {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		List<Member> list = null;

		if (conn != null) {
			String sql = "SELECT * FROM member_tbl_02 " + 
					"ORDER BY custno desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			 list = new ArrayList<> ();
			while(rs.next()) {
				Member member = new Member();
				member.setId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setPhone(rs.getString(3));
				member.setAddress(rs.getString(4));
				member.setJoin_date(rs.getDate(5));
				member.setGrade(rs.getString(6));
				member.setCity_code(rs.getString(7));
				
				list.add(member);
			}
			
			if (ps != null) {
				ps.close();
			}
			
			if (rs != null) {
				rs.close();
			}
			
			conn.close();
		}
		return list;
	}
	
	public List<Sale> getsaleList() throws Exception {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		List<Sale> list = null;

		if (conn != null) {
			String sql = "SELECT m.CUSTNO, m.CUSTNAME, m.GRADE, e.pcist "+ 
					" FROM member_tbl_02 m ,money_tbl_02 e " + 
					"where m.CUSTNO = e.CUSTNO " + 
					"order by pcist desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			 list = new ArrayList<> ();
			 System.out.println("getsalelist() ");
			while(rs.next()) {
				Sale sale = new Sale();
				sale.setId(rs.getInt(1));
				sale.setName(rs.getString(2));
				sale.setGrade(rs.getString(3));
				sale.setSales(rs.getInt(4));
				
				
				list.add(sale);
			}
			
			if (ps != null) {
				ps.close();
			}
			
			if (rs != null) {
				rs.close();
			}
			
			conn.close();
		}
		return list;
	}	
	public boolean updateMember(Member member) throws Exception {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int result = 0;
		
		if (conn != null && member != null) {
			String sql = "update member_tbl_02 set CUSTNAME=?, phone=?, address=?, " + 
					"joindate=?, grade=?, city=? where custno=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, member.getName());
			ps.setString(2, member.getPhone());
			ps.setString(3, member.getAddress());
			ps.setDate(4, member.getJoin_date());
			ps.setString(5, member.getGrade());
			ps.setString(6, member.getCity_code());
			ps.setInt(7, member.getId());
			
			result = ps.executeUpdate();
			
			if (ps != null) {
				ps.close();
			}
			
			conn.close();
		}
		
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
}
