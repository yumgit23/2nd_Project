package qna.mvc.control;

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

import mvc.domain.Qna;
import qna.mvc.model.QnaService;

@WebServlet("/qna/qna.do")
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	private String m = "";
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			switch(m){
				case "list": list(request, response); break;
				case "listD": listD(request, response); break;
				case "del": del(request, response); break;
				case "content": content(request, response); break;
				case "write": write(request, response); break;
				case "insert": insert(request, response); break;
				case "insert_re": insert_re(request, response); break;
			}
		}else {
			list(request, response);
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException,NumberFormatException {
		HttpSession session = request.getSession();
		QnaService service = QnaService.getInstance();
		ArrayList<Qna> list = service.listS();
		request.setAttribute("list", list);
		String view = "qna.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
	}
	private void listD(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException,NumberFormatException {
		HttpSession session = request.getSession();
    	String id = request.getParameter("pd_id");
    	int pd_id = -1;
		if(id != null) {
			id = id.trim();
			try {
				pd_id = Integer.parseInt(id);
				QnaService service = QnaService.getInstance();
				ArrayList<Qna> list = service.listDS(pd_id);
				request.setAttribute("list", list);
			}catch(NumberFormatException ne) {
				ne.printStackTrace();
			}
			String view = "qna.jsp";
	    	RequestDispatcher rd = request.getRequestDispatcher(view);
	    	rd.forward(request, response);
		}
	}
	private void del(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String id = request.getParameter("qna_id");
    	int qna_id = -1;
		if(id != null) {
			id = id.trim();
			try {
				qna_id = Integer.parseInt(id);
				QnaService service = QnaService.getInstance();
				service.delS(qna_id);
		}catch(NumberFormatException ne) {
			ne.printStackTrace();
		}
		
		String view = "qna.do";
		response.sendRedirect(view);
		}
	}
	private void content(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String id = request.getParameter("qna_id");
    	int qna_id = -1;
		if(id != null) {
			id = id.trim();
			try {
				qna_id = Integer.parseInt(id);
				QnaService service = QnaService.getInstance();
			Qna content = service.contentS(qna_id);
			request.setAttribute("content", content);
			}catch(NumberFormatException ne) {
				ne.printStackTrace();
			}
			String view = "";
			if(m.equals("content")) {
				view = "content.jsp";
			}else { //m.equals("update").m,
				view = "update.jsp";
			}
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}else {
			String view = "qna.do";
			response.sendRedirect(view);
		}
	}
	private void write(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String view = "write.jsp";
		response.sendRedirect(view);
		
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		
    	String qna_title = request.getParameter("qna_title");
    	String ct_id = request.getParameter("ct_id");
    	String qna_content = request.getParameter("qna_content");
    	
    	//String content = request.getParameter("content");
    	Qna dto = new Qna(-1, -1, 0, 0, qna_title, qna_content, null, 1,ct_id);
    	QnaService service = QnaService.getInstance();
    	service.insertS(dto);
    	
    	String view = "qna.do";
    	response.sendRedirect(view);
    }
	private void insert_re(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		
    	String qna_title = request.getParameter("qna_title");
    	String ct_id = request.getParameter("ct_id");
    	String qna_content = request.getParameter("qna_content");
    	String qna_mgrpS = request.getParameter("qna_mgrp");
    	int qna_mgrp = -1;
		if(qna_mgrpS != null) {
			qna_mgrpS = qna_mgrpS.trim();
			try {
				qna_mgrp = Integer.parseInt(qna_mgrpS);
		    	Qna dto = new Qna(-1, qna_mgrp, 0,0, qna_title, qna_content, null, 1,ct_id);
		    	QnaService service = QnaService.getInstance();
		    	service.insert_reS(dto);
			}catch(NumberFormatException ne) {
				ne.printStackTrace();
			}
		}
    	String view = "qna.do";
    	response.sendRedirect(view);
    }
}



