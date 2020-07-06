package src.neris.tabl;

public class Received {

	private Integer equipment_id;
	private String sn;
	private Integer group_id;
	private Integer organization_id;
	private String group_info;
	private String organization_info;
	

	public Received (Integer equipment_id, String sn, Integer group_id, Integer organization_id) 
	{
		this.equipment_id = equipment_id;
		this.sn = sn;
		this.group_id = group_id;
		this.organization_id = organization_id;
	}

	public Received () {
		// TODO Auto-generated constructor stub
	}
	
	public Received (Integer equipment_id, String sn, String group_info, String organization_info) 
	{
		this.equipment_id = equipment_id;
		this.sn = sn;
		this.group_info = group_info;
		this.organization_info = organization_info;
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

	public Integer getorganization_id() {
		return organization_id;
	}

	public void setorganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}


public String getgroup_info() {
	return group_info;
}

public void setgroup_info(String group_info) {
	this.group_info = group_info;
}

public String getorganization_info() {
	return organization_info;
}

public void setorganization_info(String organization_info) {
	this.organization_info = organization_info;
}

}
