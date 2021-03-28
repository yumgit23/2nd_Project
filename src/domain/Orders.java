package domain;
import domain.Product.*;
import java.sql.Date;

public class Orders {
	private int od_id;
	private int pd_id;
	private String ct_id;
	private Date od_date;
	private int totalprice;
	private int deliveryfee;
	private int od_pd_quantity;
	private int od_pd_price;
	private String pd_thumbnail;
	private String pd_name;
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders(int od_id, int pd_id, String ct_id, String pd_thumbnail, String pd_name, Date od_date, int totalprice,
			int deliveryfee, int od_pd_quantity, int od_pd_price) {
		super();
		this.od_id = od_id;
		this.pd_id = pd_id;
		this.ct_id = ct_id;
		this.pd_thumbnail = pd_thumbnail;
		this.pd_name = pd_name;
		this.od_date = od_date;
		this.totalprice = totalprice;
		this.deliveryfee = deliveryfee;
		this.od_pd_quantity = od_pd_quantity;
		this.od_pd_price = od_pd_price;
	}

	/*
	 * public Orders(int od_id2, int pd_id2, String pd_thumbnail2, String pd_name2,
	 * int od_pd_quantity2, int deliveryfee2, int totalprice2, Date od_date2) {
	 * this.od_id = od_id2; this.pd_id = pd_id2; this.pd_thumbnail = pd_thumbnail2;
	 * this.pd_name = pd_name2; this.od_date = od_date2; this.totalprice =
	 * totalprice2; this.deliveryfee = deliveryfee2; this.od_pd_quantity =
	 * od_pd_quantity2; }
	 */
	public int getOd_id() {
		return od_id;
	}
	public void setOd_id(int od_id) {
		this.od_id = od_id;
	}
	public int getPd_id() {
		return pd_id;
	}
	public void setPd_id(int pd_id) {
		this.pd_id = pd_id;
	}
	public String getCt_id() {
		return ct_id;
	}
	public void setCt_id(String ct_id) {
		this.ct_id = ct_id;
	}
	public String getPd_thumbnail() {
		return pd_thumbnail;
	}
	public void setPd_thumbnail(String pd_thumbnail) {
		this.pd_thumbnail = pd_thumbnail;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public Date getOd_date() {
		return od_date;
	}
	public void setOd_date(Date od_date) {
		this.od_date = od_date;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getDeliveryfee() {
		return deliveryfee;
	}
	public void setDeliveryfee(int deliveryfee) {
		this.deliveryfee = deliveryfee;
	}
	public int getOd_pd_quantity() {
		return od_pd_quantity;
	}
	public void setOd_pd_quantity(int od_pd_quantity) {
		this.od_pd_quantity = od_pd_quantity;
	}
	public int getOd_pd_price() {
		return od_pd_price;
	}
	public void setOd_pd_price(int od_pd_price) {
		this.od_pd_price = od_pd_price;
	}
	
	
}
