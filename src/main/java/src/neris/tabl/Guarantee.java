package src.neris.tabl;

public class Guarantee {

	private Integer guarantee_id;
	private Integer organization_id;
	private Integer validity_id;
	private String date;
	private String org_info;
	private Integer month;
	private String contract;
	

	public Guarantee (Integer guarantee_id, Integer organization_id, Integer validity_id) 
	{
		this.guarantee_id = guarantee_id;
		this.organization_id = organization_id;
		this.validity_id = validity_id;
	}

	public Guarantee(Integer guarantee_id, String date, String org_info, Integer month, String contract) {
		this.guarantee_id = guarantee_id;
		this.date = date;
		this.org_info = org_info;
		this.month = month;
		this.contract = contract;
		
	}

	public Integer getguarantee_id() {
		return guarantee_id;
	}

	public void setguarantee_id(Integer guarantee_id) {
		this.guarantee_id = guarantee_id;
	}

	public Integer getorganization_id() {
		return organization_id;
	}

	public void setorganization_id(Integer organization_id) {
		this.organization_id = organization_id;
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
	
	public String getorg_info() {
		return org_info;
	}

	public void setorg_info(String org_info) {
		this.org_info = org_info;
	}
	
	public Integer getmonth() {
		return month;
	}

	public void setmonth(Integer month) {
		this.month = month;
	}

	public String getcontract() {
		return contract;
	}

	public void setcontract(String contract) {
		this.contract = contract;
	}
}
