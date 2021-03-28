package product.model;

import static product.model.ProductSQL.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import domain.Product;

public class ProductDAO {
	private DataSource ds;
	ProductDAO(){
		try {
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		ds = (DataSource)envContext.lookup("jdbc/myoracle");
		
		}catch(NamingException ne) {
			System.out.println("Apache DBCP ne");
		}
	}
	
	ArrayList<Product> list(){
			ArrayList<Product> list = new ArrayList<Product>();
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
		    String sql = "select * from pd";
		
		    		
		    try {
		    		con = ds.getConnection();
		    		stmt = con.createStatement();
		    		rs = stmt.executeQuery(sql);
		    		while(rs.next()) {
		    			int pd_id = rs.getInt("pd_id");
		    			String pd_name = rs.getString("pd_name");
		    			int pd_price = rs.getInt("pd_price");
		    			String pd_thumbnail = rs.getString("pd_thumbnail");//blob
		    			String pd_hover = rs.getString("pd_hover");
		    			String pd_type = rs.getString("pd_type");
		    			String pd_infoimg = rs.getString("pd_infoimg");
		    			String pd_disc = rs.getString("pd_disc");
		    			list.add(new Product(pd_id, pd_name, pd_price, pd_thumbnail, pd_hover, pd_type, pd_infoimg, pd_disc));
		    		}
		    		return list;
		    }catch(SQLException se) {
		    	System.out.println("ArrayList<Product> list() se: " + se);
		    		return null;
		    }finally{
				try{
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null)  con.close();
				}catch(SQLException se){}
			}  
	}	


	ArrayList<Product> contents(int pd_id){
		 ArrayList<Product> contents = new ArrayList<Product>();
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
		    String sql = "select * from PD where pd_id ="+ pd_id;
		    
		    try{
				con = ds.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()){
					pd_id = rs.getInt("pd_id");// 타입 안쓰니 해결?
					String pd_name = rs.getString("pd_name");
	    			int pd_price = rs.getInt("pd_price");
	    			String pd_thumbnail = rs.getString("pd_thumbnail");//blob
	    			String pd_hover = rs.getString("pd_hover");
	    			String pd_type = rs.getString("pd_type");
	    			String pd_infoimg = rs.getString("pd_infoimg");
	    			String pd_disc = rs.getString("pd_disc");
					contents.add(new Product(pd_id, pd_name, pd_price, pd_thumbnail, pd_hover, pd_type, pd_infoimg, pd_disc));
				}
				return contents;
			}catch(SQLException se){
				System.out.println(se);
				return null;
			}finally{
					try{
						if(rs != null) rs.close();
						if(stmt != null) stmt.close();
						if(con != null)  con.close();
					}catch(SQLException se){}
				}  
	 }
	
}
/////분류별 리스트 만들면 좋을듯(목걸이, 귀걸이, 헤어, 팔찌)

