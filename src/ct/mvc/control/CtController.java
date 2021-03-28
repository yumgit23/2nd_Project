package ct.mvc.control;

import static ct.mvc.model.loginCase.*;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ct.mvc.model.CtService;
import mvc.domain.Customer;
import mvc.domain.Orders;
import od.mvc.model.OdService;

@WebServlet("/main/main.do")
public class CtController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	private String m = "";
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m){
				case "main": main(request, response); break;
				case "signup": signup(request, response); break;
				case "login": login(request, response); break;
				case "logout": logout(request, response); break;
				case "cart": cart(request, response); break;
			}
		}else {
			main(request, response);
		}
	}
	private void main(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String view = "../index.jsp";
		response.sendRedirect(view);
	}
	private void signup(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String id = request.getParameter("ct_id");
		String pwd = request.getParameter("ct_pw");
		String name = request.getParameter("ct_name");
		String address = request.getParameter("ct_address");
		String phone = request.getParameter("ct_phone");
		String gender = request.getParameter("ct_gender");
		String email = request.getParameter("ct_email");
		String birth = request.getParameter("ct_birth");
		Customer ct = new Customer(id, pwd, name, address, phone, gender,email,birth,null);
		CtService service = CtService.getInstance();
		service.insertS(ct);
		
		String view = "../signup/signup.jsp";
		response.sendRedirect(view);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("ct_id");
		String pwd = request.getParameter("ct_pw");
		if(id != null) id = id.trim();
		if(pwd != null) pwd = pwd.trim();
		
		CtService service = CtService.getInstance();
		int rCode = service.checkMember(id, pwd);
		request.setAttribute("rCode", rCode);
		if(rCode == PASS) {
			HttpSession session = request.getSession();
			Customer m = service.getMemberS(id);
			session.setAttribute("loginPassUser", m);
		}
		String view = "login_msg.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//session.removeAttribute("loginPassUser");
		session.invalidate(); 
		
		String view = "../index.jsp";
		response.sendRedirect(view);
	}
	private void cart(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException,NumberFormatException {
		try {
		HttpSession session = request.getSession();
    	OdService service = OdService.getInstance();
    	String id = request.getParameter("ct_id");
    	ArrayList<Orders> list = service.listS(id);
    	for(Orders dto : list) request.setAttribute("dto", dto);
		request.setAttribute("list", list);
    	
    	request.setAttribute("id", id);
    	
    	String view = "../index.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
		}catch(NumberFormatException ne){
			ne.printStackTrace();
		}
    }
}



