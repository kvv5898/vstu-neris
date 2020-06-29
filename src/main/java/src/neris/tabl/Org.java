package src.neris.tabl;

public class Org {

	private Integer organization_id;
	private String description;
	private String tel;
	private String address;
	private Integer guarantee_id;
	private String organization_info;
	

	public Org (Integer organization_id, String description, String tel, String address, Integer guarantee_id, String organization_info) 
	{
		this.organization_id = organization_id;
		this.description = description;
		this.tel = tel;
		this.address = address;
		this.guarantee_id = guarantee_id;
		this.organization_info = organization_info;
	}

	public Org() {
		// TODO Auto-generated constructor stub
	}

	public Integer getorganization_id() {
		return organization_id;
	}

	public void setorganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public String gettel() {
		return tel;
	}

	public void settel(String tel) {
		this.tel = tel;
	}

	public String getaddress() {
		return address;
	}

	public void setaddress(String address) {
		this.address = address;
	}
	
	public Integer guarantee_id() {
		return guarantee_id;
	}

	public void setguarantee_id(Integer guarantee_id) {
		this.guarantee_id = guarantee_id;
	}
	
	public String getorganization_info() {
		return organization_info;
	}

	public void setorganization_info(String organization_info) {
		this.organization_info = organization_info;
	}

}
