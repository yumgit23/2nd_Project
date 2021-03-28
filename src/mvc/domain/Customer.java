package mvc.domain;

import java.sql.Date;

public class Customer {
	private String ct_id;
	private String ct_pw;
	private String name;
	private String address;
	private String phone;
	private String gender;
	private String email;
	private String birth;
	private Date joindate;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String ct_id, String ct_pw, String name, String address, String phone, String gender,
			String email, String birth, Date joindate) {
		super();
		this.ct_id = ct_id;
		this.ct_pw = ct_pw;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.email = email;
		this.birth = birth;
		this.joindate = joindate;
	}
	
	public String getCt_id() {
		return ct_id;
	}
	public void setCt_id(String ct_id) {
		this.ct_id = ct_id;
	}
	public String getCt_pw() {
		return ct_pw;
	}
	public void setCt_pw(String ct_pw) {
		this.ct_pw = ct_pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public Date getJoindate() {
		return joindate;
	}
	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}
	
}
