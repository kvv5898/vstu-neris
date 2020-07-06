package src.neris.servlet.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.neris.log.logUser;
import src.neris.tabl.Groups;
import src.sql.Equipment;



@WebServlet(urlPatterns = { "/addgroups" })
public class Addgroups extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Addgroups() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Addgroups.jsp");

		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
    	Connection conn = logUser.getStoredConnection(session);
		
		String description = (String) request.getParameter("description");
		String model = (String) request.getParameter("model");
		String group_info = (String) request.getParameter("group_info");
		Integer group_id = null;
		
		Groups groups = new Groups(group_id, description, model,group_info);
		
		try {
			Equipment.group_add(conn, groups);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}
}

