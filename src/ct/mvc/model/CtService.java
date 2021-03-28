package ct.mvc.model;

import static ct.mvc.model.loginCase.*;

import java.util.ArrayList;

import ct.mvc.model.CtDAO;
import mvc.domain.Customer;
import mvc.domain.Orders;

public class CtService {
private CtDAO dao;
	
	private static final CtService instance = new CtService();
	private CtService(){
		dao = new CtDAO();
	} 
	public static CtService getInstance() {
		return instance;
	}
	public void insertS(Customer ct) {
		dao.insert(ct);
	}
	public int checkMember(String id,String pwd) {
		Customer m = dao.getMember(id);
		if(m == null) {
			return NO_ID;
		}else {
			String pwdDb = m.getCt_pw();
			if(pwdDb != null) pwdDb.trim();
			if(pwd.equals(pwdDb)) {
				return NO_PWD;
			}else {
				return PASS;
			}
		}
	}
	public Customer getMemberS(String id) {
		Customer m = dao.getMember(id);
		m.setCt_pw(""); //[보안] 패쓰워드를 공백으로 처리해서 뷰(클라이언트)에 전송
		
		return m;
	}
	public ArrayList<Orders> listS(String id){
		return dao.list(id);
	}
}
