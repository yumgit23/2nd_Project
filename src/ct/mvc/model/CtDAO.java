package ct.mvc.model;

import static ct.mvc.model.CtSQL.*;

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

import mvc.domain.Customer;
import mvc.domain.Orders;

class CtDAO {
	private DataSource ds;
	CtDAO(){
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	Customer getMember(String id){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = MEMBER;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String pwd = rs.getString(1);
				String ct_name = rs.getString(2);
				String address = rs.getString(3);
				String phone = rs.getString(4);
				String gender = rs.getString(5);
				String email = rs.getString(6);
				String birth = rs.getString(7);
				Date joindate = rs.getDate(8);
				return new Customer(id, pwd, ct_name, address, phone, gender,email,birth,joindate);
			}else {
				return null;
			}
		}catch (SQLException se) {
			System.out.println("ct dao"+se);
			return null;
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
			}
		}
		
	}
	void insert(Customer ct) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = INSERT;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ct.getCt_id());
			pstmt.setString(2, ct.getCt_pw());
			pstmt.setString(3, ct.getName());
			pstmt.setString(4, ct.getAddress());
			pstmt.setString(5, ct.getPhone());
			pstmt.setString(6, ct.getGender());
			pstmt.setString(7, ct.getEmail());
			pstmt.setString(8, ct.getBirth());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("CtDAO insert() se: "+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}
	ArrayList<Orders> list(String id){
	      ArrayList<Orders> list = new ArrayList<Orders>();
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = CART;
	      Orders m = new Orders();
	      try {
	    	  System.out.println("수행완료 DAO1");
	         con = ds.getConnection();
	         pstmt = con.prepareStatement(sql);  
	         if(id!=null) id = id.trim();
	         pstmt.setString(1, id);
	         rs = pstmt.executeQuery();  
	         while(rs.next()) {
	            int od_id = rs.getInt("od_id");
	            int pd_id = rs.getInt("pd_id");
	            Date od_date = rs.getDate("od_date");
	            int totalprice = rs.getInt("totalprice");
	            int deliveryfee = rs.getInt("deliveryfee");
	            int od_pd_quantity = rs.getInt("od_pd_quantity");     
	            int od_pd_price = rs.getInt("od_pd_price");
	            String pd_thumbnail = rs.getString("pd_thumbnail");
	            String pd_name = rs.getString("pd_name"); 
	            String pd_disc = rs.getString("pd_disc");	            
	            m = new Orders(od_id, pd_id, id, od_date, totalprice, deliveryfee, od_pd_quantity,od_pd_price, pd_thumbnail, pd_name, pd_disc);
	            list.add(m);
	         }
	         return list;
	      }catch(SQLException se) {
	         System.out.println("#SQLException : "+se);
	         return null;
	      }finally {
	         try {
	            if(rs != null) rs.close();
	            if(pstmt != null) pstmt.close();
	            if(con != null) con.close();
	         }catch(SQLException se) {}
	      }
	   }
}
