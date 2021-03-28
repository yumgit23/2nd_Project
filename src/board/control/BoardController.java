package board.control;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardService;
import domain.Board;


@WebServlet("/board/board.do")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			String m = request.getParameter("m");
			if(m !=null) {
				m = m.trim();
				switch(m){
				case "qlist": qlist(request, response); break;
				case "write": write(request, response); break;
				case "insert": insert(request, response); break;
				case "content": content(request, response); break;
				case "del": del(request, response); break;
	


				
				default: qlist(request, response);
			}
		}else {
			qlist(request, response);
		}
	}
    
	private void qlist(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		BoardService service = BoardService.getInstance();
		ArrayList<Board> qlist = service.qlistS();
		request.setAttribute("qlist", qlist);//???????????
		
		String view = "board.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void content(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String seqStr = request.getParameter("q_id");
		long q_id = -1L;
		System.out.println(seqStr);
		if(seqStr != null) {
	          seqStr = seqStr.trim();
	          try {
	        	  q_id = Long.parseLong(seqStr);
				BoardService service = BoardService.getInstance();
				ArrayList<Board> content = service.contentS(q_id);
				request.setAttribute("content", content);//???????????
	          }catch(NumberFormatException ne) {}
		}
		String view = "content.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	private void write(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String view = "write.jsp";
		
		response.sendRedirect(view);
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String q_title = request.getParameter("q_title");
		String q_content = request.getParameter("q_content");
		String ct_id = request.getParameter("ct_id");

		Board board = new Board(-1, null, q_title, null, q_content, -1, ct_id, null, null);
	
		BoardService service = BoardService.getInstance();
		service.insertS(board);
		
		String view = "board.do";
		response.sendRedirect(view);
	}
	
	private void del(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String seqStr = request.getParameter("q_id");
		long q_id = -1L;
		System.out.println(seqStr);
		if(seqStr != null) {
	          seqStr = seqStr.trim();
	          try {
	        	  q_id = Long.parseLong(seqStr);
			System.out.println("del1");
			BoardService service = BoardService.getInstance();
			service.delS(q_id);
	          }catch(NumberFormatException ne) {}
		}
		System.out.println("del2 if ½ÇÇà¾ÈµÊ");
		String view = "board.do";// "board.do?m=del&seq="+q_id
		response.sendRedirect(view);
		
	}
	

	private long getSeq(HttpServletRequest request) {
		String seqStr = request.getParameter("seq");
		long seq = 0L;
		if(seqStr == null) {
			return -1L;
		}else {
			seqStr = seqStr.trim();
			try {
				seq = Integer.parseInt(seqStr);//·ÎÁ÷ÀÌÇØ¾ÈµÅ
				
				return seq;
			}catch(NumberFormatException ne) {
				return -1L;
			}
		}
	}
	

}

	/*
	 * private long getSeq(HttpServletRequest request) { String seqStr =
	 * request.getParameter("seq"); System.out.println(seqStr); long seq = 0L;
	 * if(seqStr == null) { System.out.println("getSeq1"); return -1L; }else {
	 * 
	 * seqStr = seqStr.trim(); try { seq = Long.parseLong("seq");
	 * System.out.println("getSeq2"); return seq; }catch(NumberFormatException ne) {
	 * System.out.println("getSeq"+ne); return -1L; } } }
	 */
	 


