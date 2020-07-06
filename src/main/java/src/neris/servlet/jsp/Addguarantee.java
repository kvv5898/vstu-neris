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
import src.neris.tabl.Guarantee;
import src.other.date_time;
import src.sql.Equipment;



@WebServlet(urlPatterns = { "/addguarantee" })
public class Addguarantee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Addguarantee() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String date = date_time.date();
		request.setAttribute("date", date);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Addguarantee.jsp");

		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
    	Connection conn = logUser.getStoredConnection(session);
		
		String date = (String) request.getParameter("date");
		String grant_period = (String) request.getParameter("grant_period");
		String guarantee_info = (String) request.getParameter("guarantee_info");
		Integer guarantee_id = null;
		
		Guarantee guarantee = new Guarantee (guarantee_id, date, grant_period, guarantee_info); 
		
		try {
			Equipment.guarantee_add(conn, guarantee);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		doGet(request, response);
	}
}

