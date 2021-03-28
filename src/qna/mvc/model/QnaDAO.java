package qna.mvc.model;

import static qna.mvc.model.QnaSQL.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import mvc.domain.Qna;

class QnaDAO {
	private DataSource ds;
	QnaDAO(){
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
   ArrayList<Qna> list(){
	      ArrayList<Qna> list = new ArrayList<Qna>();
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = LIST;
	      Qna m = new Qna();
	      try {
	         con = ds.getConnection();
	         pstmt = con.prepareStatement(sql);  
	         rs = pstmt.executeQuery();  
	         while(rs.next()) {
	            int qna_id = rs.getInt(1);
	            int qna_mgrp = rs.getInt(2);
	            int qna_mseq = rs.getInt(3);
	            int qna_mlvl = rs.getInt(4);
	            String qna_title = rs.getString(5);
	            String qna_content = rs.getString(6);
	            Date qna_date = rs.getDate(7);
	            int pd_id = rs.getInt(8);
	            String ct_id = rs.getString(9);     
	            m = new Qna(qna_id, qna_mgrp, qna_mseq, qna_mlvl, qna_title, qna_content, qna_date,pd_id, ct_id);
	            list.add(m);
	         }
	         return list;
	      }catch(SQLException se) {
	         System.out.println("# QnaDAO SQLException : "+se);
	         return null;
	      }finally {
	         try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(con != null) con.close();
	         }catch(SQLException se) {}
	      }
	   }
   ArrayList<Qna> listD(int pd_id){
	      ArrayList<Qna> list = new ArrayList<Qna>();
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = LIST_D;
	      Qna m = new Qna();
	      try {
	         con = ds.getConnection();
	         pstmt = con.prepareStatement(sql);  
	         pstmt.setInt(1, pd_id);
	         rs = pstmt.executeQuery();  
	         while(rs.next()) {
	            int qna_id = rs.getInt(1);
	            int qna_mgrp = rs.getInt(2);
	            int qna_mseq = rs.getInt(3);
	            int qna_mlvl = rs.getInt(4);
	            String qna_title = rs.getString(5);
	            String qna_content = rs.getString(6);
	            Date qna_date = rs.getDate(7);
	            //int pd_id = rs.getInt(8);
	            String ct_id = rs.getString(9);     
	            m = new Qna(qna_id, qna_mgrp, qna_mseq, qna_mlvl, qna_title, qna_content, qna_date,pd_id, ct_id);
	            list.add(m);
	         }
	         return list;
	      }catch(SQLException se) {
	         System.out.println("# QnaDAO SQLException : "+se);
	         return null;
	      }finally {
	         try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(con != null) con.close();
	         }catch(SQLException se) {}
	      }
	   }
   void del(int qna_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = DEL;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_id);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("QnaDAO del() se: "+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}   
   Qna content(int qna_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = CONTENT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qna_id);
			System.out.println(qna_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//int qna_id = rs.getInt(1);
	            int qna_mgrp = rs.getInt(2);
	            int qna_mseq = rs.getInt(3);
	            int qna_mlvl = rs.getInt(4);
	            String qna_title = rs.getString(5);
	            String qna_content = rs.getString(6);
	            Date qna_date = rs.getDate(7);
	            int pd_id = rs.getInt(8);
	            String ct_id = rs.getString(9);     
	            Qna qna = new Qna(qna_id, qna_mgrp, qna_mseq, qna_mlvl, qna_title, qna_content, qna_date,pd_id, ct_id);
	            System.out.println("수행완료");
	            return qna;
			}else {
				return null;
			}
		}catch(SQLException se) {
			System.out.println("qnaDAO content() se: " + se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
   void insert(Qna dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getQna_title());
			pstmt.setString(2, dto.getQna_content());
			pstmt.setString(3, dto.getCt_id());
			pstmt.executeUpdate();
		}catch(SQLException se) {	
			System.out.println("QnaDAO insert se: "+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
   void insert_re(Qna dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT_RE;
		System.out.println("#"+dto.getQna_mgrp());
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getQna_mgrp());
			pstmt.setString(2, dto.getQna_title());
			pstmt.setString(3, dto.getQna_content());
			pstmt.setString(4, dto.getCt_id());
			pstmt.executeUpdate();
		}catch(SQLException se) {	
			System.out.println("QnaDAO insert se: "+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
}
