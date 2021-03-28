package ct.mvc.model;

class CtSQL {
	final static String LIST="select * from BOARD order by SEQ desc";
	final static String INSERT
	    ="insert into ct values(?,?,?,?,?,?,?,?,SYSDATE)";
	final static String CONTENT="select * from BOARD where SEQ=?";
	final static String UPDATE
	    ="update BOARD set EMAIL=?, SUBJECT=?, CONTENT=?, FNAME=?, OFNAME=?, FSIZE=? where SEQ=?";
	final static String DEL= "delete from BOARD where SEQ=?";
	
	final static String LIST_PAGE
	="select * from (select ROWNUM rnum, aa.* from (select * from BOARD order by SEQ desc) aa) "
	+"where rnum>? and rnum<=?";
	final static String COUNT
	="select max(ROWNUM) from BOARD"; //select count(SEQ) from BOARD
	final static String MEMBER = "select * from ct WHERE ct_id = ?";
	final static String CART="select od_id , pd_id , pd_thumbnail, pd_name, pd_disc, od_pd_quantity, od_pd_price, deliveryfee, totalprice, od_date from orders natural join pd where ct_id=?";
}
