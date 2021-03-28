package board.model;

import java.util.ArrayList;

import domain.Board;

public class BoardService {
	private BoardDAO dao;
	private static final BoardService instance = new BoardService();
	
	private BoardService() {
		dao = new BoardDAO();
	}
	
	public static final BoardService getInstance() {
		return instance;
	}
	
	public ArrayList<Board> qlistS() {
		return dao.qlist();
	}
	public void insertS(Board board) {
		dao.insert(board);
	}
	public Board getBoardS(long q_id) {
		return dao.getBoard(q_id);
	}
	public void delS(long q_id) {
		dao.del(q_id);
	}
	public ArrayList<Board> contentS(long q_id) {
		return dao.content(q_id);
	}
}
