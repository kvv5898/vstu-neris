package src.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import src.neris.tabl.Groups;
import src.neris.tabl.Guarantee;
import src.neris.tabl.Org;
import src.neris.tabl.Received;
import src.neris.tabl.Validity;




public class Equipment {

	public static List<Groups> findgroups(Connection conn) throws SQLException {
		String sql = "Select * from groups";
		System.out.println("Search info groups in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Groups> list = new ArrayList<Groups>();
		while (rs.next()) {

			Integer group_id = rs.getInt("group_id");
			String description = rs.getString("description");
			String model = rs.getString("model");
			String group_info = rs.getString("group_info");

			Groups us = new Groups(group_id, description, model, group_info);

			us.setgroup_id(group_id);
			us.setdescription(description);
			us.setmodel(model);
			us.setgroup_info(group_info);
			list.add(us);
		}
		return list;
	}
	
	public static List<Org> findorg(Connection conn) throws SQLException {
		String sql = "Select * from organization";
		System.out.println("Search info organization in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Org> list = new ArrayList<Org>();
		while (rs.next()) {

			Integer organization_id = rs.getInt("organization_id");
			String org_info = rs.getString("org_info");
			String tel = rs.getString("tel");
			String address = rs.getString("address");
			String organization_info = rs.getString("organization_info");

			Org us = new Org(organization_id, org_info, tel, address, organization_info);

			us.setorganization_id(organization_id);
			us.setorg_info(org_info);
			us.settel(tel);
			us.setaddress(address);
			us.setorganization_info(organization_info);
			list.add(us);
		}
		return list;
	}
	
	public static List<Validity> findvalidity(Connection conn) throws SQLException {
		String sql = "Select * from validity";
		System.out.println("Search info validity in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Validity> list = new ArrayList<Validity>();
		while (rs.next()) {
			
			Integer validity_id = rs.getInt("validity_id");
			String date = rs.getString("date");
			Integer month = rs.getInt("month");
			String org_info = rs.getString("org_info");
			String contract = rs.getString("contract");
			String validity_info = rs.getString("validity_info");
			

			Validity us = new Validity(validity_id, date, month, org_info, contract, validity_info);

			us.setvalidity_id(validity_id);
			us.setdate(date);
			us.setmonth(month);
			us.setorg_info(org_info);
			us.setcontract(contract);
			us.setvalidity_info(validity_info);
			list.add(us);
		}
		return list;
	}
	
	
	public static List<Validity> findvalidityfororg(Connection conn, String org_info) throws SQLException {
		String sql = "SELECT * from validity WHERE org_info=? ORDER by date";
		System.out.println("Search info findvalidityfororg in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, org_info);
		ResultSet rs = pstm.executeQuery();
		List<Validity> list = new ArrayList<Validity>();
		while (rs.next()) {
			
			Integer validity_id = rs.getInt("validity_id");
			System.out.println("validity_id - " + validity_id);
			String date = rs.getString("date");
			Integer month = rs.getInt("month");
			String org_info2 = rs.getString("org_info");
			String contract = rs.getString("contract");
			String validity_info = rs.getString("validity_info");

			Validity us = new Validity(validity_id, date, month, org_info2, contract, validity_info);

			us.setvalidity_id(validity_id);
			us.setdate(date);
			us.setmonth(month);
			us.setorg_info(org_info2);
			us.setcontract(contract);
			us.setvalidity_info(validity_info);
			list.add(us);
		}
		return list;
	}
	
	public static List<Guarantee> findguar(Connection conn) throws SQLException {
		String sql = "SELECT  g.guarantee_id, v.date, o.org_info, v.month, v.contract "
				+ "FROM guarantee g " 
				+ "INNER JOIN validity v ON v.validity_id=g.validity_id "
				+ "INNER JOIN organization o ON o.organization_id=g.organization_id "
				+ "ORDER BY v.date";
		System.out.println("Search info Guarantee in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Guarantee> list = new ArrayList<Guarantee>();
		while (rs.next()) {
			
			Integer guarantee_id = rs.getInt("guarantee_id");
			String date = rs.getString("date");
			String org_info = rs.getString("org_info");
			Integer month = rs.getInt("month");
			String contract = rs.getString("contract");

			Guarantee us = new Guarantee(guarantee_id, date, org_info, month,contract);

			us.setguarantee_id(guarantee_id);
			us.setdate(date);
			us.setorg_info(org_info);
			us.setmonth(month);
			us.setcontract(contract);
			list.add(us);
		}
		return list;
	}
	
	public static void validity_add(Connection conn, Validity validity) throws SQLException {
        String sql = "Insert into validity (date, month, contract,  validity_info) values (?,?,?,?)";
 
        PreparedStatement add = conn.prepareStatement(sql);
        
        add.setString(1, validity.getdate());
        add.setInt(2, validity.getmonth());
        add.setString(3, validity.getcontract());
        add.setString(4, validity.getvalidity_info());
 
        add.executeUpdate();
	
}
		
		public static void new_add(Connection conn, Received new_add) throws SQLException {
	        String sql = "Insert into received (sn,  group_id, organization_id) values (?,?,?)";
	 
	        PreparedStatement add = conn.prepareStatement(sql);
	 
	        System.out.println("getsn() - " + new_add.getsn());
	        System.out.println("getgroup_id() - " + new_add.getgroup_id());
	        System.out.println("getorganization_id() - " + new_add.getorganization_id());
	        
	        add.setString(1, new_add.getsn());
	        add.setInt(2, new_add.getgroup_id());
	        add.setInt(3, new_add.getorganization_id());
	 
	        add.executeUpdate();
		
		
	
	}
		
		public static List<Received> find_er(Connection conn) throws SQLException {
			String sql = "SELECT r.equipment_id, r.sn, g.group_info AS group_info, o.organization_info AS organization_info "
					+ "FROM received r INNER JOIN groups g ON r.group_id = g.group_id "
					+ "INNER JOIN organization o ON r.organization_id = o.organization_id";
			System.out.println("Search info Received in DB");
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			List<Received> list = new ArrayList<Received>();
			while (rs.next()) {
		
				Integer equipment_id = rs.getInt("equipment_id");
				String sn = rs.getString("sn");
				String group_info = rs.getString("group_info");
				String organization_info = rs.getString("organization_info");

				Received us = new Received(equipment_id, sn, group_info, organization_info);

				us.setequipment_id(equipment_id);
				us.setsn(sn);
				us.setgroup_info(group_info);
				us.setorganization_info(organization_info);
				list.add(us);
			}
			return list;
		}
		
		public static void group_add(Connection conn, Groups groups) throws SQLException {
	        String sql = "Insert into groups (description,  model, group_info) values (?,?,?)";
	 
	        PreparedStatement add = conn.prepareStatement(sql);
	 
	        
	        add.setString(1, groups.getdescription());
	        add.setString(2, groups.getmodel());
	        add.setString(3, groups.getgroup_info());
	 
	        add.executeUpdate();
		
		
	
	}
		
		public static void org_add(Connection conn, Org org) throws SQLException {
	        String sql = "Insert into organization (org_info, tel, address, organization_info) values (?,?,?,?)";
	 
	        PreparedStatement add = conn.prepareStatement(sql);
	 
	        
	        add.setString(1, org.getorg_info());
	        add.setString(2, org.gettel());
	        add.setString(3, org.getaddress());
	        add.setString(4, org.getorganization_info());
	 
	        add.executeUpdate();
		
		
	
	}
}
