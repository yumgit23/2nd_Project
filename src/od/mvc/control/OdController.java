package od.mvc.control;

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

import mvc.domain.Orders;
import od.mvc.model.OdService;
import mvc.domain.Customer;
import ct.mvc.model.CtService;
import ct.mvc.model.*;

@WebServlet("/mypage/mypage.do")
public class OdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String m = "";

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		m = request.getParameter("m");
		if (m != null) {
			m = m.trim();
			switch (m) {
			case "list":
				list(request, response);
				break;
			case "del":
				del(request, response);
				break;
			case "update_p":
				update_p(request, response);
				break;
			case "update_m":
				update_m(request, response);
				break;
			case "add":
				add(request, response);
				break;
			}
		} else {
			list(request, response);
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		try {
			HttpSession session = request.getSession();
			OdService service = OdService.getInstance();
			String id = request.getParameter("ct_id");
			ArrayList<Orders> list = service.listS(id);
			for (Orders dto : list)
				request.setAttribute("dto", dto);

			request.setAttribute("list", list);

			request.setAttribute("id", id);

			String view = "mypage.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		} catch (NumberFormatException ne) {
			ne.printStackTrace();
		}
	}

	private void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		String ot_id = request.getParameter("od_id");
		String ct_id = request.getParameter("ct_id");
		int id = -1;
		if (ot_id != null) {
			ot_id = ot_id.trim();
			try {
				id = Integer.parseInt(ot_id);
				OdService service = OdService.getInstance();
				service.delS(id);
			} catch (NumberFormatException ne) {
				ne.printStackTrace();
			}

		}
		String view = "mypage.do?m=list&ct_id=";
		RequestDispatcher rd = request.getRequestDispatcher(view + ct_id);
		rd.forward(request, response);
	}

	private void update_p(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		int odN = -1;
		Orders dto = new Orders();
		String od_id = request.getParameter("od_id");
		String ct_id = request.getParameter("ct_id");
		if (od_id != null) {
			od_id = od_id.trim();
			if (od_id.length() != 0) {
				try {
					odN = Integer.parseInt(od_id);
				} catch (NumberFormatException ne) {
				}
			}
		}
		dto = new Orders(odN, dto.getPd_id(), dto.getCt_id(), dto.getOd_date(), dto.getTotalprice(),
				dto.getDeliveryfee(), dto.getOd_pd_quantity(), dto.getOd_pd_price(), dto.getPd_thumbnail(),
				dto.getPd_name(), dto.getPd_disc());
		OdService service = OdService.getInstance();
		service.update_pS(dto);

		String view = "mypage.do?m=list&ct_id=";
		RequestDispatcher rd = request.getRequestDispatcher(view + ct_id);
		rd.forward(request, response);
	}

	private void update_m(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		int odN = -1;
		Orders dto = new Orders();
		String od_id = request.getParameter("od_id");
		String ct_id = request.getParameter("ct_id");
		if (od_id != null) {
			od_id = od_id.trim();
			if (od_id.length() != 0) {
				try {
					odN = Integer.parseInt(od_id);
				} catch (NumberFormatException ne) {
				}
			}
		}
		dto = new Orders(odN, dto.getPd_id(), dto.getCt_id(), dto.getOd_date(), dto.getTotalprice(),
				dto.getDeliveryfee(), dto.getOd_pd_quantity(), dto.getOd_pd_price(), dto.getPd_thumbnail(),
				dto.getPd_name(), dto.getPd_disc());
		OdService service = OdService.getInstance();
		service.update_mS(dto);

		String view = "mypage.do?m=list&ct_id=";
		RequestDispatcher rd = request.getRequestDispatcher(view + ct_id);
		rd.forward(request, response);
	}

	
	
	
	
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException {
		/*
		 * HttpSession session = request.getSession(); int od_id = 1; String ct_id =
		 * (String)session.getAttribute("loginPassUser"); System.out.println(ct_id); int
		 * pd_id = 1 ; int od_pd_quantity = 1; Boolean flag2 = false;
		 * 
		 * session.setAttribute(ct_id, flag2); Customer loginUser =
		 * (Customer)session.getAttribute("ct_id");
		 * 
		 * if(ct_id !=null) { flag2 = true; System.out.println(ct_id);
		 * 
		 * }else System.out.println("실패");
		 */
		int pd_id = 1 ; 
		int od_pd_price = 1;
		String ct_id = request.getParameter("ct_id");
		String pd_priceStr = request.getParameter("pd_price");
		String pd_idStr = request.getParameter("pd_id");
		System.out.println(ct_id+pd_priceStr+pd_idStr);
		if (pd_priceStr != null || pd_idStr != null) {
			try {
				if (pd_idStr != null)
					pd_idStr = pd_idStr.trim();
				if (pd_priceStr != null)
					pd_priceStr = pd_priceStr.trim();
				pd_id = Integer.parseInt(pd_idStr);
				od_pd_price = Integer.parseInt(pd_priceStr);
			} catch (NumberFormatException ne) {
			}
			Orders od = new Orders(-1, pd_id, ct_id,null, 0, 2500,1,od_pd_price,null,null,null);
		      OdService service = OdService.getInstance();
		      service.addS(od);
		      System.out.println("con 수행 완료");
		      String view = "mypage.do?m=list&ct_id=";
		      response.sendRedirect(view+ct_id);
			
			
			/*Boolean flag = service.addS(od_id, ct_id, pd_id, od_pd_quantity);
			session.setAttribute("cFlag", flag);
			session.setAttribute("lFlag", flag2);
			String view = "addmsg.jsp";
			response.sendRedirect(view);*/
		}
	}

}
