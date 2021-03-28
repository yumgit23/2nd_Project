package od.mvc.model;

import static od.mvc.model.OdSQL.*;

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

import mvc.domain.Orders;

class OdDAO {
	private DataSource ds;
	OdDAO(){
		try {
			Context initContext = new InitialContext();
		    Context envContext  = (Context)initContext.lookup("java:/comp/env");
		    ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
   ArrayList<Orders> list(String id){
	      ArrayList<Orders> list = new ArrayList<Orders>();
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String sql = LIST;
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
   void del(int od_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = DEL;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, od_id);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("OdDAO del() se: "+se);
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(SQLException se) {}
		}
	}   
   public void update_p(Orders dto) {
		String sql = UPDATE_P;
		Connection con= null;
		PreparedStatement pstmt=null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getOd_id());
			pstmt.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
	        	if(con != null) con.close();
			} catch (SQLException se){}
		}
	}
   public void update_m(Orders dto) {
		String sql = UPDATE_M;
		Connection con= null;
		PreparedStatement pstmt=null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getOd_id());
			pstmt.executeUpdate();	
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
	        	if(con != null) con.close();
			} catch (SQLException se){}
		}
	}
   
   void add(Orders od) {
	      Connection con = null;
	      PreparedStatement pstmt = null;
	      String sql = ADD;
	      try {
	    	  System.out.println("dao 수행1");
	         con = ds.getConnection();
	         pstmt = con.prepareStatement(sql);
	         //pstmt.setInt(1, od.getOd_id());
	         pstmt.setInt(1, od.getPd_id());
	         pstmt.setString(2, od.getCt_id());
	         //pstmt.setString(4, od.getPd_thumbnail()); 
	         //pstmt.setString(5, od.getPd_name());
	         //pstmt.setDate(4, od.getOd_date());
	         //pstmt.setInt(5, od.getTotalprice());
	         //pstmt.setInt(6, od.getDeliveryfee());
	         //pstmt.setInt(7, od.getOd_pd_quantity());
	         pstmt.setInt(3, od.getOd_pd_price());
	      //   pstmt.setString(9, od.getPd_thumbnail()); 
	     //    pstmt.setString(10, od.getPd_name());
	      //   pstmt.setString(11, od.getPd_disc());
	         pstmt.executeUpdate();
	         System.out.println("#수행완료");
	      }catch(SQLException se) {
	         System.out.println("OdDAO insert() se: "+se);
	      }finally {
	         try {
	            if(pstmt != null) pstmt.close();
	            if(con != null) con.close();
	         }catch(SQLException se) {}
	      }
	   }
   
   
   
/*   Boolean add(int od_id, String ct_id, int pd_id, int od_pd_quantity) {
	   String sql = ADD;
		Connection con= null;
		PreparedStatement pstmt=null;
		
		try {
			con = ds.getConnection();	
			System.out.println("1");
			pstmt = con.prepareStatement(sql);
			System.out.println("2");
			pstmt.setInt(1, od_id);
			System.out.println("3");
			System.out.println(od_id);
			pstmt.setInt(2, pd_id);
			System.out.println("4");	
			System.out.println(pd_id);
			pstmt.setString(3, ct_id);
			System.out.println("5");
			System.out.println(ct_id);
			pstmt.setInt(4, od_pd_quantity);
			System.out.println(od_pd_quantity);
			int i = pstmt.executeUpdate();
	    	if(i>0) return true;
				else return false;
	    }catch(SQLException se) {
	    	System.out.println(se);
	    	return false;
	    }finally {
	    	try {
	    		if(pstmt != null) pstmt.close();
	    		if(con != null) con.close();
	    	}catch(SQLException se) {}
	    }
	}*/
   }

