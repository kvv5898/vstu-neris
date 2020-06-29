package src.neris.tabl;

public class Received {

	private Integer equipment_id;
	private String sn;
	private Integer group_id;
	private Integer organization_id;
	

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

}
