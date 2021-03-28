package board.model;

import static board.model.BoardSQL.*;


import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Board;

public class BoardDAO {
	private DataSource ds;
	BoardDAO(){
		try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		ds = (DataSource)envContext.lookup("jdbc/myoracle");
		
		}catch(NamingException ne) {
			System.out.println("Apache DBCP ne");
		}
	}
	
	
	ArrayList<Board> qlist(){
		ArrayList<Board> qlist = new ArrayList<Board>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = LIST;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				long q_id = rs.getLong("q_id");
				String q_category = rs.getString("q_category");
				String q_title = rs.getString("q_title");
				Date q_date = rs.getDate("q_date");
				String q_content = rs.getString("q_content");
				int pd_id = rs.getInt("pd_id");
				String ct_id = rs.getString("ct_id");
				String pd_name = rs.getString("pd_name");
				String pd_thumbnail = rs.getString("pd_thumbnail");
				qlist.add(new Board(q_id, q_category, q_title, q_date, q_content, pd_id, ct_id, pd_name, pd_thumbnail));	
			}
			
			return qlist;
		}catch(SQLException se) {
			System.out.println("ArrayList<Board> qlist() se: " + se);
				return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	void insert(Board board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getQ_title());
			//pstmt.setDate(2, board.getQ_date());
			pstmt.setString(2, board.getQ_content());
			pstmt.setString(3, board.getPd_name());
			pstmt.setString(4, board.getCt_id());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("BoardDAO insert() se: "+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	ArrayList<Board> content(long q_id){
		 ArrayList<Board> content = new ArrayList<Board>();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = CONTENT;
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setLong(1,q_id);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					//q_id = rs.getLong("q_id");
					String q_category = rs.getString("q_category");
					String q_title = rs.getString("q_title");
					Date q_date = rs.getDate("q_date");
					String q_content = rs.getString("q_content");
					int pd_id = rs.getInt("pd_id");
					String ct_id = rs.getString("ct_id");
					String pd_name = rs.getString("pd_name");
					String pd_thumbnail = rs.getString("pd_thumbnail");
					content.add(new Board(q_id, q_category, q_title, q_date, q_content, pd_id, ct_id, pd_name, pd_thumbnail));	
				}
				
				return content;
			}catch(SQLException se) {
				System.out.println("ArrayList<Board> qlist() se: " + se);
					return null;
			}finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(con != null) con.close();
				}catch(SQLException se) {}
			}
		}
			
			
			
	
	Board getBoard(long q_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from qboard where q_id=?";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, q_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				q_id = rs.getLong("q_id");
				String q_category = rs.getString("q_category");
				String q_title = rs.getString("q_title");
				Date q_date = rs.getDate("q_date");
				String q_content = rs.getString("q_content");
				int pd_id = rs.getInt("pd_id");
				String ct_id = rs.getString("ct_id");
				String pd_name = rs.getString("pd_name");
				String pd_thumbnail = rs.getString("pd_thumbnail");
				
				Board b = new Board(q_id, q_category, q_title, q_date, q_content, pd_id, ct_id, pd_name, pd_thumbnail);
				return b;
				
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println("BoardDAO getBoard() se: " + se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	void del(long q_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = DEL;
		
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, q_id);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println(" BoardDAO del() se: "+ se);	
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {se.printStackTrace();}		
		}
	}
}