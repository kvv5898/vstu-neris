package src.neris.tabl;

public class Received {

	private Integer equipment_id;
	private String sn;
	private Integer group_id;
	private Integer guarantee_id;
	private String group_info;
	private String org_name;
	private String contract;
	
	

	public Received (Integer equipment_id, String sn, Integer group_id, Integer guarantee_id) 
	{
		this.equipment_id = equipment_id;
		this.sn = sn;
		this.group_id = group_id;
		this.guarantee_id = guarantee_id;
	}

	public Received () {
		// TODO Auto-generated constructor stub
	}
	
	public Received (Integer equipment_id, String sn, String group_info, String org_name, String contract) 
	{
		this.equipment_id = equipment_id;
		this.sn = sn;
		this.group_info = group_info;
		this.org_name = org_name;
		this.contract = contract;
	}

	public Integer getequipment_id() {
		return equipment_id;
	}

	public void setequipment_id(Integer equipment_id) {
		this.equipment_id = equipment_id;
	}

	public String getsn() {
		return sn;
	}

	public void setsn(String sn) {
		this.sn = sn;
	}

	public Integer getgroup_id() {
		return group_id;
	}

	public void setgroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public Integer getguarantee_id() {
		return guarantee_id;
	}

	public void setguarantee_id(Integer guarantee_id) {
		this.guarantee_id = guarantee_id;
	}


public String getgroup_info() {
	return group_info;
}

public void setgroup_info(String group_info) {
	this.group_info = group_info;
}

public String getorg_name() {
	return org_name;
}

public void setorg_name(String org_name) {
	this.org_name = org_name;
}

public String getcontract() {
	return contract;
}

public void setcontract(String contract) {
	this.contract = contract;
}

}
