package product.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.Product;
import product.model.ProductService;
	
@WebServlet("/product/product.do")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				String m = request.getParameter("m");
				if(m != null) {	
					m = m.trim();
					if(m.equals("list")){
						list(request, response);
					}
					if(m.equals("detail")){
						detail(request, response);
					}if(m.equals("pt")){
						pt(request, response);
					}else{
						list(request, response);
					}
				}
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ProductService service = ProductService.getInstance();
		ArrayList<Product> list = service.listS();
		request.setAttribute("list", list);
		
		String view = "product.jsp";//product.jsp
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }
	
	private void detail(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ProductService service = ProductService.getInstance();
		String codeStr =  request.getParameter("pd_id");
		if(codeStr != null) codeStr = codeStr.trim();
				int pd_id = Integer.parseInt(codeStr);
		
		
		ArrayList<Product> contents = service.contentsS(pd_id);
		request.setAttribute("contents", contents);
		
		String view = "productdetail.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
    }
	private void pt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				String view = "in.jsp";
			
				response.sendRedirect(view);
		}
}
			