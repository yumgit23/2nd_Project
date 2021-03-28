package mvc.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardService;
import domain.Board;
import domain.Orders;
import domain.Product;
import od.mvc.model.OdService;
import product.model.ProductService;

/**
 * Servlet implementation class IndexController
 */
@WebServlet("/index.do")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				String m = request.getParameter("m");
				if(m != null) {
					m = m.trim();
					if(m.equals("list")){
						list(request, response);
					}if(m.equals("board")){ 
						board(request, response);
					}else {
						index(request, response);
					}
				}
	}
	public void index(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String view = "index.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ProductService service = ProductService.getInstance();
		ArrayList<Product> list = service.listS();
		request.setAttribute("list", list);
		
		String view = "product/product.do";
        RequestDispatcher rd = request.getRequestDispatcher(view);
        rd.forward(request, response);
	}
        
    private void board(HttpServletRequest request, HttpServletResponse response) 
    			throws ServletException, IOException {
    		BoardService service = BoardService.getInstance();
    		ArrayList<Board> qlist = service.qlistS();
    		request.setAttribute("qlist", qlist);
    		
    		String view = "qna/qna.do";
            RequestDispatcher rd = request.getRequestDispatcher(view);
            rd.forward(request, response);
    }
   
 
}

	
    