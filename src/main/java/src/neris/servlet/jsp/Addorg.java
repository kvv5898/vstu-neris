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
import src.neris.tabl.Validity;
import src.neris.tabl.Org;
import src.sql.Equipment;



@WebServlet(urlPatterns = { "/addorg" })
public class Addorg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Addorg() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
    	Connection conn = logUser.getStoredConnection(session);
		
		List<Validity> guarantee = null;
		String errorString = null;
		try {
			guarantee=Equipment.find_validity(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("errorString", errorString);
		request.setAttribute("guarantee", guarantee);

		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Addorg.jsp");

		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String org_name = (String) request.getParameter("org_name");
		String tel = (String) request.getParameter("tel");
		String address = (String) request.getParameter("address");
		System.out.println("guarantee_id" + request.getParameter("guarantee_id"));
		String organization_info = (String) request.getParameter("organization_info");
		Integer organization_id = null;
		
		Org org = new Org (organization_id, org_name, tel, address, organization_info);
		HttpSession session = request.getSession();
    	Connection conn = logUser.getStoredConnection(session);
		
		try {
			Equipment.org_add(conn, org);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}
}

