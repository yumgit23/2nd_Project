package board.model;

class BoardSQL {
	final static String LIST = "select q_id, q_category, q_title, q_date, q_content, pd_id, ct_id, pd_name, pd_thumbnail from qboard natural join pd natural join ct order by q_id desc";
	final static String DEL = "delete from qboard where q_id=?";
	final static String INSERT = "insert into qboard (q_id, q_title, q_date, q_content, pd_name, ct_id) values (qboard_q_id.nextval, ? , SYSDATE, ?, ?,?)";
	final static String CONTENT = "select q_id, q_category, q_title, q_date, q_content, pd_id, ct_id, pd_name, pd_thumbnail from qboard natural join pd natural join ct where q_id=? order by q_id desc";
}
