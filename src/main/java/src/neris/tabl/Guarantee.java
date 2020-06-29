package src.neris.tabl;

public class Guarantee {

	private Integer guarantee_id;
	private String date;
	private String grant_period;
	private String guarantee_info;
	

	public Guarantee (Integer guarantee_id, String date, String grant_period, String guarantee_info) 
	{
		this.guarantee_id = guarantee_id;
		this.date = date;
		this.grant_period = grant_period;
		this.guarantee_info = guarantee_info;
	}

	public Guarantee() {
		// TODO Auto-generated constructor stub
	}

	public Integer getguarantee_id() {
		return guarantee_id;
	}

	public void setguarantee_id(Integer guarantee_id) {
		this.guarantee_id = guarantee_id;
	}

	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public String getgrant_period() {
		return grant_period;
	}

	public void setgrant_period(String grant_period) {
		this.grant_period = grant_period;
	}

	public String getguarantee_info() {
		return guarantee_info;
	}

	public void setguarantee_info(String guarantee_info) {
		this.guarantee_info = guarantee_info;
	}

}
