package mvc.domain;

public class Product {
	private int pd_id;
	private String pd_name;
	private int pd_price;
	private String pd_thumbnail;
	private String pd_hover;
	private String pd_type;
	private String pd_infoimg;
	private String pd_disc;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pd_id, String pd_name, int pd_price, String pd_thumbnail, String pd_hover, String pd_type,
			String pd_infoimg, String pd_disc) {
		super();
		this.pd_id = pd_id;
		this.pd_name = pd_name;
		this.pd_price = pd_price;
		this.pd_thumbnail = pd_thumbnail;
		this.pd_hover = pd_hover;
		this.pd_type = pd_type;
		this.pd_infoimg = pd_infoimg;
		this.pd_disc = pd_disc;
	}
	public int getPd_id() {
		return pd_id;
	}
	public void setPd_id(int pd_id) {
		this.pd_id = pd_id;
	}
	public String getPd_name() {
		return pd_name;
	}
	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}
	public int getPd_price() {
		return pd_price;
	}
	public void setPd_price(int pd_price) {
		this.pd_price = pd_price;
	}
	public String getPd_thumbnail() {
		return pd_thumbnail;
	}
	public void setPd_thumbnail(String pd_thumbnail) {
		this.pd_thumbnail = pd_thumbnail;
	}
	public String getPd_hover() {
		return pd_hover;
	}
	public void setPd_hover(String pd_hover) {
		this.pd_hover = pd_hover;
	}
	public String getPd_type() {
		return pd_type;
	}
	public void setPd_type(String pd_type) {
		this.pd_type = pd_type;
	}
	public String getPd_infoimg() {
		return pd_infoimg;
	}
	public void setPd_infoimg(String pd_infoimg) {
		this.pd_infoimg = pd_infoimg;
	}
	public String getPd_disc() {
		return pd_disc;
	}
	public void setPd_disc(String pd_disc) {
		this.pd_disc = pd_disc;
	}
	
}
