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

	public static List<Groups> find_groups(Connection conn) throws SQLException {
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

	public static Integer find_groups_duplicate(Connection conn, Groups groups) throws SQLException {
		
		String sql = "Select count(*) from groups WHERE description =? AND model =? AND group_info =?";
		System.out.println("Search find_groups_duplicate in DB: " + sql);
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, groups.getdescription());
		pstm.setString(2, groups.getmodel());
		pstm.setString(3, groups.getgroup_info());

		Integer count = null;
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			count = rs.getInt("count");
		}
		System.out.println("count: " + count);
		return count;
	}

	public static List<String> find_groups_name_column(Connection conn, String name_column) throws SQLException {
		String sql = "SELECT " + name_column + " FROM groups GROUP BY " + name_column + "";
		System.out.println("Search info find_groups_name_column in DB by " + name_column);
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<String> us = new ArrayList<String>();
		while (rs.next()) {
			String name = rs.getString(name_column);
			us.add(name);
		}
		
		return us;
	}

	public static List<Groups> find_id_gr(Connection conn, Integer group_id) throws SQLException {
		String sql = "Select * from groups WHERE group_id=?";
		System.out.println("Search info groups in DB by group_id");
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, group_id);
		ResultSet rs = pstm.executeQuery();
		List<Groups> list = new ArrayList<Groups>();
		while (rs.next()) {

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

	public static List<Org> find_org(Connection conn) throws SQLException {
		String sql = "Select * from organization";
		System.out.println("Search info organization in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Org> list = new ArrayList<Org>();
		while (rs.next()) {

			Integer organization_id = rs.getInt("organization_id");
			String org_name = rs.getString("org_name");
			String tel = rs.getString("tel");
			String address = rs.getString("address");
			String organization_info = rs.getString("organization_info");

			Org us = new Org(organization_id, org_name, tel, address, organization_info);

			us.setorganization_id(organization_id);
			us.setorg_name(org_name);
			us.settel(tel);
			us.setaddress(address);
			us.setorganization_info(organization_info);
			list.add(us);
		}
		return list;
	}

	public static List<Org> find_id_org(Connection conn, Integer organization_id) throws SQLException {
		String sql = "Select * from organization WHERE organization_id=?";
		System.out.println("Search info organization in DB by organization_id");
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, organization_id);
		ResultSet rs = pstm.executeQuery();
		List<Org> list = new ArrayList<Org>();
		while (rs.next()) {

			String org_name = rs.getString("org_name");
			String tel = rs.getString("tel");
			String address = rs.getString("address");
			String organization_info = rs.getString("organization_info");

			Org us = new Org(organization_id, org_name, tel, address, organization_info);

			us.setorganization_id(organization_id);
			us.setorg_name(org_name);
			us.settel(tel);
			us.setaddress(address);
			us.setorganization_info(organization_info);
			list.add(us);
		}
		return list;
	}

	public static List<Org> find_name_org(Connection conn, String org_name) throws SQLException {
		String sql = "Select * from organization WHERE org_name=?";
		System.out.println("Search info organization in DB by: " + org_name);
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, org_name);
		ResultSet rs = pstm.executeQuery();
		List<Org> list = new ArrayList<Org>();


		if (rs.next()) {
			System.out.println(org_name + " found successfully in the database");

			Integer organization_id = rs.getInt("organization_id");
			org_name = rs.getString("org_name");
			String tel = rs.getString("tel");
			String address = rs.getString("address");
			String organization_info = rs.getString("organization_info");

			Org us = new Org(organization_id, org_name, tel, address, organization_info);

			us.setorganization_id(organization_id);
			us.setorg_name(org_name);
			us.settel(tel);
			us.setaddress(address);
			us.setorganization_info(organization_info);
			list.add(us);
		}
		


else {
	System.out.println(org_name + " not found in the database");
		list = null;
		
		}
		
		return list;
	}
	
	public static List<Validity> find_validity(Connection conn) throws SQLException {
		String sql = "Select * from validity";
		System.out.println("Search info validity in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Validity> list = new ArrayList<Validity>();
		while (rs.next()) {

			Integer validity_id = rs.getInt("validity_id");
			String date = rs.getString("date");
			Integer month = rs.getInt("month");
			String org_name = rs.getString("org_name");
			String contract = rs.getString("contract");
			String validity_info = rs.getString("validity_info");

			Validity us = new Validity(validity_id, date, month, org_name, contract, validity_info);

			us.setvalidity_id(validity_id);
			us.setdate(date);
			us.setmonth(month);
			us.setorg_name(org_name);
			us.setcontract(contract);
			us.setvalidity_info(validity_info);
			list.add(us);
		}
		return list;
	}

	public static List<Validity> find_validity_for_org(Connection conn, String org_name) throws SQLException {
		String sql = "SELECT * from validity WHERE org_name=? ORDER by date";
		System.out.println("Search info find_validity_for_org in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, org_name);
		ResultSet rs = pstm.executeQuery();
		List<Validity> list = new ArrayList<Validity>();
		while (rs.next()) {

			Integer validity_id = rs.getInt("validity_id");
			System.out.println("validity_id - " + validity_id);
			String date = rs.getString("date");
			Integer month = rs.getInt("month");
			String org_name2 = rs.getString("org_name");
			String contract = rs.getString("contract");
			String validity_info = rs.getString("validity_info");

			Validity us = new Validity(validity_id, date, month, org_name2, contract, validity_info);

			us.setvalidity_id(validity_id);
			us.setdate(date);
			us.setmonth(month);
			us.setorg_name(org_name2);
			us.setcontract(contract);
			us.setvalidity_info(validity_info);
			list.add(us);
		}
		return list;
	}

	public static List<Guarantee> find_guar(Connection conn) throws SQLException {
		String sql = "SELECT  g.guarantee_id, v.date, o.org_name, v.month, v.contract " + "FROM guarantee g "
				+ "INNER JOIN validity v ON v.validity_id=g.validity_id "
				+ "INNER JOIN organization o ON o.organization_id=g.organization_id " + "ORDER BY v.date";
		System.out.println("Search info Guarantee in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Guarantee> list = new ArrayList<Guarantee>();
		while (rs.next()) {

			Integer guarantee_id = rs.getInt("guarantee_id");
			String date = rs.getString("date");
			String org_name = rs.getString("org_name");
			Integer month = rs.getInt("month");
			String contract = rs.getString("contract");

			Guarantee us = new Guarantee(guarantee_id, date, org_name, month, contract);

			us.setguarantee_id(guarantee_id);
			us.setdate(date);
			us.setorg_name(org_name);
			us.setmonth(month);
			us.setcontract(contract);
			list.add(us);
		}
		return list;
	}

	public static List<Guarantee> find_id_guar(Connection conn, Integer guarantee_id) throws SQLException {
		String sql = "SELECT  g.guarantee_id, v.date, o.org_name, v.month, v.contract " + "FROM guarantee g "
				+ "INNER JOIN validity v ON v.validity_id=g.validity_id "
				+ "INNER JOIN organization o ON o.organization_id=g.organization_id " + "WHERE g.guarantee_id=?";
		System.out.println("Search info Guarantee in DB by guarantee_id");
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, guarantee_id);
		ResultSet rs = pstm.executeQuery();
		List<Guarantee> list = new ArrayList<Guarantee>();
		while (rs.next()) {
			guarantee_id = rs.getInt("guarantee_id");
			String date = rs.getString("date");
			String org_name = rs.getString("org_name");
			Integer month = rs.getInt("month");
			String contract = rs.getString("contract");

			Guarantee us = new Guarantee(guarantee_id, date, org_name, month, contract);

			us.setguarantee_id(guarantee_id);
			us.setdate(date);
			us.setorg_name(org_name);
			us.setmonth(month);
			us.setcontract(contract);
			list.add(us);
		}
		return list;
	}

	public static List<String> find_guar_name_column(Connection conn, String name_column) throws SQLException {
		String sql = "SELECT " + name_column + " FROM guarantee GROUP BY " + name_column + "";
		System.out.println("Search info find_guar_name_column in DB by " + name_column);
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<String> us = new ArrayList<String>();
		while (rs.next()) {
			String name = rs.getString(name_column);
			us.add(name);
		}
		;
		return us;
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

	public static Integer find_received_sn(Connection conn, String sn) throws SQLException {
		String sql = "Select count(*) from received WHERE sn=?";
		System.out.println("Search find_received_sn in DB by sn");
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, sn);
		Integer count = null;
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			count = rs.getInt("count");
		}
		return count;
	}

	public static void add_received(Connection conn, Received add_received) throws SQLException {
		String sql = "Insert into received (sn,  group_id, guarantee_id) values (?,?,?)";

		PreparedStatement add = conn.prepareStatement(sql);

		System.out.println("getsn() - " + add_received.getsn());
		System.out.println("getgroup_id() - " + add_received.getgroup_id());
		System.out.println("guarantee_id() - " + add_received.getguarantee_id());

		add.setString(1, add_received.getsn());
		add.setInt(2, add_received.getgroup_id());
		add.setInt(3, add_received.getguarantee_id());

		add.executeUpdate();
	}

	public static List<Received> find_er(Connection conn) throws SQLException {
		String sql = "SELECT r.equipment_id, r.sn, g.group_info, o.org_name, v.contract "
				+ "FROM received r, groups g, guarantee gua, organization o, validity v "
				+ "WHERE r.group_id=g.group_id " + "AND r.guarantee_id=gua.guarantee_id "
				+ "AND o.organization_id=gua.organization_id " + "AND v.validity_id=gua.validity_id";
		System.out.println("Search info Received in DB");
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		List<Received> list = new ArrayList<Received>();
		while (rs.next()) {

			Integer equipment_id = rs.getInt("equipment_id");
			String sn = rs.getString("sn");
			String group_info = rs.getString("group_info");
			String org_name = rs.getString("org_name");
			String contract = rs.getString("contract");

			Received us = new Received(equipment_id, sn, group_info, org_name, contract);

			us.setequipment_id(equipment_id);
			us.setsn(sn);
			us.setgroup_info(group_info);
			us.setorg_name(org_name);
			us.setorg_name(contract);
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
		String sql = "Insert into organization (org_name, tel, address, organization_info) values (?,?,?,?)";

		PreparedStatement add = conn.prepareStatement(sql);

		add.setString(1, org.getorg_name());
		add.setString(2, org.gettel());
		add.setString(3, org.getaddress());
		add.setString(4, org.getorganization_info());

		add.executeUpdate();

	}
}
