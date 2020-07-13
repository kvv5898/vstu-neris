package src.neris.tabl;

public class Validity {

	private Integer validity_id;
	private String date;
	private Integer month;
	private String org_info;
	private String contract;
	private String validity_info;
	

	public Validity (Integer validity_id, String date, Integer month, String org_info, String contract,  String validity_info) 
	{
		this.validity_id = validity_id;
		this.date = date;
		this.month = month;
		this.org_info = org_info;
		this.contract = contract;
		this.validity_info = validity_info;
	}


	public Integer getvalidity_id() {
		return validity_id;
	}

	public void setvalidity_id(Integer validity_id) {
		this.validity_id = validity_id;
	}

	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public Integer getmonth() {
		return month;
	}

	public void setmonth(Integer month) {
		this.month = month;
	}
	
	public String getorg_info() {
		return org_info;
	}

	public void setorg_info(String org_info) {
		this.org_info = org_info;
	}
	
	public String getcontract() {
		return contract;
	}

	public void setcontract(String contract) {
		this.contract = contract;
	}

	public String getvalidity_info() {
		return validity_info;
	}

	public void setvalidity_info(String validity_info) {
		this.validity_info = validity_info;
	}

}
