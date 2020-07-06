package src.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import src.neris.tabl.Groups;
import src.neris.tabl.Guarantee;
import src.neris.tabl.Received;
import src.neris.tabl.Org;



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
	
	public static List<Org> findgorg(Connection conn) throws SQLException {
		String sql = "Select * from organization";
		System.out.println("Search info organization in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Org> list = new ArrayList<Org>();
		while (rs.next()) {

			Integer organization_id = rs.getInt("organization_id");
			String description = rs.getString("description");
			String tel = rs.getString("tel");
			String address = rs.getString("address");
			Integer guarantee_id = rs.getInt("guarantee_id");
			String organization_info = rs.getString("organization_info");

			Org us = new Org(organization_id, description, tel, address,guarantee_id,organization_info);

			us.setorganization_id(organization_id);
			us.setdescription(description);
			us.settel(tel);
			us.setaddress(address);
			us.setguarantee_id(guarantee_id);
			us.setorganization_info(organization_info);
			list.add(us);
		}
		return list;
	}
	
	public static List<Guarantee> findguarantee(Connection conn) throws SQLException {
		String sql = "Select * from guarantee";
		System.out.println("Search info guarantee in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Guarantee> list = new ArrayList<Guarantee>();
		while (rs.next()) {
			
			Integer guarantee_id = rs.getInt("guarantee_id");
			String date = rs.getString("date");
			String grant_period = rs.getString("grant_period");
			String guarantee_info = rs.getString("guarantee_info");
			

			Guarantee us = new Guarantee(guarantee_id, date, grant_period, guarantee_info);

			us.setguarantee_id(guarantee_id);
			us.setdate(date);
			us.setgrant_period(grant_period);
			us.setguarantee_info(guarantee_info);
			list.add(us);
		}
		return list;
	}
	
	public static void guarantee_add(Connection conn, Guarantee guarantee) throws SQLException {
        String sql = "Insert into guarantee (date, grant_period, guarantee_info) values (?,?,?)";
 
        PreparedStatement add = conn.prepareStatement(sql);
        
        add.setString(1, guarantee.getdate());
        add.setString(2, guarantee.getgrant_period());
        add.setString(3, guarantee.getguarantee_info());
 
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
			String sql = "SELECT r.equipment_id, r.sn, g.group_info AS group_info, o.organization_info AS organization_info FROM received r INNER JOIN groups g ON r.group_id = g.group_id INNER JOIN organization o ON r.organization_id = o.organization_id";
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
	        String sql = "Insert into organization (description, tel, address, guarantee_id, organization_info) values (?,?,?,?,?)";
	 
	        PreparedStatement add = conn.prepareStatement(sql);
	 
	        
	        add.setString(1, org.getdescription());
	        add.setString(2, org.gettel());
	        add.setString(3, org.getaddress());
	        add.setInt(4, org.guarantee_id());
	        add.setString(5, org.getorganization_info());
	 
	        add.executeUpdate();
		
		
	
	}
}
