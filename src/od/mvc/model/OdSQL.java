package od.mvc.model;

class OdSQL {
	final static String LIST="select od_id , pd_id , pd_thumbnail, pd_name, pd_disc, od_pd_quantity, od_pd_price, deliveryfee, totalprice, od_date from orders natural join pd where ct_id=?";
	final static String UPDATE_P
	    ="update ORDERS set od_pd_quantity=od_pd_quantity+1, totalprice=(od_pd_price*(od_pd_quantity+1)) where od_id=?";
	final static String UPDATE_M
    ="update ORDERS set od_pd_quantity=od_pd_quantity-1, totalprice=(totalprice-od_pd_price) where od_id=?";
	final static String DEL= "delete from ORDERS where od_id=?";
	final static String DEL_ALL= "delete from ORDERS where ct_id=?";
	final static String ADD = "insert into orders(od_id, pd_id, ct_id, od_date, totalprice, deliveryfee, od_pd_quantity, od_pd_price) "
			+ "values(od_od_id.nextval,?,?,SYSDATE,0,2500,1,?)";
	final static String GET_ID  = "select count(od_id) from orders";
}



insert into orders(od_id, pd_id, ct_id, od_date, totalprice, deliveryfee, od_pd_quantity, od_pd_price) values(od_od_id.nextval,1,'°ü¸®ÀÚ',SYSDATE,0,2500,1,150000);