package domain;

import java.sql.Date;

public class Board {
	private long q_id;
	private String q_category;
	private String q_title;
	private Date q_date;
	private String q_content;
	private int pd_id;
	private String ct_id;
	private String pd_name;
	private String pd_thumbnail;

	public Board() {}	
	public Board(long q_id, String q_category, String q_title, Date q_date, String q_content, int pd_id, String ct_id,
			String pd_name, String pd_thumbnail) {
		super();
		this.q_id = q_id;
		this.q_category = q_category;
		this.q_title = q_title;
		this.q_date = q_date;
		this.q_content = q_content;
		this.pd_id = pd_id;
		this.ct_id = ct_id;
		this.pd_name = pd_name;
		this.pd_thumbnail = pd_thumbnail;
	}
	public long getQ_id() {
		return q_id;
	}


	public void setQ_id(long q_id) {
		this.q_id = q_id;
	}


	public String getQ_category() {
		return q_category;
	}


	public void setQ_category(String q_category) {
		this.q_category = q_category;
	}


	public String getQ_title() {
		return q_title;
	}


	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}


	public Date getQ_date() {
		return q_date;
	}


	public void setQ_date(Date q_date) {
		this.q_date = q_date;
	}


	public String getQ_content() {
		return q_content;
	}


	public void setQ_content(String q_content) {
		this.q_content = q_content;
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


	public String getPd_name() {
		return pd_name;
	}


	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}


	public String getPd_thumbnail() {
		return pd_thumbnail;
	}


	public void setPd_thumbnail(String pd_thumbnail) {
		this.pd_thumbnail = pd_thumbnail;
	}

}