 package product.model;

import java.util.ArrayList;


import domain.Product;

public class ProductService {
	private ProductDAO dao;
	private static final ProductService instance = new ProductService();//Singletone
	
	private ProductService() {
		dao = new ProductDAO();
	}
	
	public static final ProductService getInstance() {
		return instance;
	}	
	
	public ArrayList<Product> listS() {
		return dao.list();
	}
	
	public ArrayList<Product> contentsS(int pd_id){
		return dao.contents(pd_id);
	}
}
