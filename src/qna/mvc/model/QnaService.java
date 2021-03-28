package qna.mvc.model;

import qna.mvc.model.QnaDAO;

import java.util.ArrayList;

import mvc.domain.Customer;
import mvc.domain.Qna;

public class QnaService {
private QnaDAO dao;
	
	private static final QnaService instance = new QnaService();
	private QnaService(){
		dao = new QnaDAO();
	} 
	public static QnaService getInstance() {
		return instance;
	}
	public ArrayList<Qna> listS(){
		return dao.list();
	}
	public ArrayList<Qna> listDS(int pd_id){
		return dao.listD(pd_id);
	}
	public void delS(int pd_id) {
		dao.del(pd_id);
	}
	public Qna contentS(int qna_id){
		return dao.content(qna_id);
	}
	public void insertS(Qna dto) {
		dao.insert(dto);
	}
	public void insert_reS(Qna dto) {
		dao.insert_re(dto);
	}
}
