package od.mvc.model;

import od.mvc.model.OdDAO;

import java.util.ArrayList;

import mvc.domain.Board;
import mvc.domain.Orders;

public class OdService {
private OdDAO dao;
	
	private static final OdService instance = new OdService();
	private OdService(){
		dao = new OdDAO();
	} 
	public static OdService getInstance() {
		return instance;
	}
	public ArrayList<Orders> listS(String id){
		return dao.list(id);
	}
	public void delS(int od_id) {
		dao.del(od_id);
	}
	public void update_pS(Orders dto){
		dao.update_p(dto);
	}
	public void update_mS(Orders dto){
		dao.update_m(dto);
	}
	public ArrayList<Orders> getOrderlistS(String id){
		return dao.list(id);
	}
	public void addS(Orders od) {
	      dao.add(od);
	   }
}
