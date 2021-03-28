package mvc.domain;

import java.sql.Date;

public class Qna {
	private int qna_id;
	private int qna_mgrp;
	private int qna_mseq;
	private int qna_mlvl;
	private String qna_title;
	private String qna_content;
	private Date qna_date;
	private int pd_id;
	private String ct_id;
	public Qna() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Qna(int qna_id, int qna_mgrp, int qna_mseq, int qna_mlvl, String qna_title, String qna_content,
			Date qna_date, int pd_id, String ct_id) {
		super();
		this.qna_id = qna_id;
		this.qna_mgrp = qna_mgrp;
		this.qna_mseq = qna_mseq;
		this.qna_mlvl = qna_mlvl;
		this.qna_title = qna_title;
		this.qna_content = qna_content;
		this.qna_date = qna_date;
		this.pd_id = pd_id;
		this.ct_id = ct_id;
	}
	public int getQna_id() {
		return qna_id;
	}
	public void setQna_id(int qna_id) {
		this.qna_id = qna_id;
	}
	public int getQna_mgrp() {
		return qna_mgrp;
	}
	public void setQna_mgrp(int qna_mgrp) {
		this.qna_mgrp = qna_mgrp;
	}
	public int getQna_mseq() {
		return qna_mseq;
	}
	public void setQna_mseq(int qna_mseq) {
		this.qna_mseq = qna_mseq;
	}
	public int getQna_mlvl() {
		return qna_mlvl;
	}
	public void setQna_mlvl(int qna_mlvl) {
		this.qna_mlvl = qna_mlvl;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public Date getQna_date() {
		return qna_date;
	}
	public void setQna_date(Date qna_date) {
		this.qna_date = qna_date;
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
	
}
