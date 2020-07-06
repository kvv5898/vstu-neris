package src.neris.servlet.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.neris.log.logUser;
import src.neris.tabl.Groups;
import src.neris.tabl.Received;
import src.neris.tabl.Org;
import src.sql.Equipment;

@WebServlet(urlPatterns = { "/equipmentoperation" })
public class EquipmentOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EquipmentOperation() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
    	Connection conn = logUser.getStoredConnection(session);
    	
    	String errorgr = null, errororg = null;
        List<Groups> gr = null;
        List<Org> org = null;
        try {
        	org = Equipment.findgorg(conn);
			gr = Equipment.findgroups(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.setAttribute("errorgr", errorgr);
        request.setAttribute("erroorg", errororg);
		request.setAttribute("gr", gr);
		request.setAttribute("org", org);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/EquipmentOperationView.jsp");

		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sn = (String) request.getParameter("SN");
        System.out.println("sn - /" + sn + "/");
		
		String GRstr = (String) request.getParameter("GR");
		Integer group_id = null;
        try {
        	group_id = Integer.parseInt(GRstr);
        } catch (Exception e) {
        }
		System.out.println("group_id - /" + group_id + "/");
		
		String ORGstr = (String) request.getParameter("ORG");
		Integer organization_id = null;
        try {
        	organization_id = Integer.parseInt(ORGstr);
        } catch (Exception e) {
        }
		System.out.println("organization_id - /" + organization_id + "/");
		Integer equipment_id = null;
		
		Received new_add = new Received(equipment_id, sn,  group_id, organization_id);
		HttpSession session = request.getSession();
    	Connection conn = logUser.getStoredConnection(session);
		
		try {
			Equipment.new_add(conn, new_add);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}
}

