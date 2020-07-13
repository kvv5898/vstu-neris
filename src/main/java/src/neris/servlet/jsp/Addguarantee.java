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
import src.neris.tabl.Org;
import src.neris.tabl.Validity;
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
		
		HttpSession session = request.getSession();
    	Connection conn = logUser.getStoredConnection(session);
    	
    	String errororg = null; 
        String errorvalidity = null;
        List<Org> org = null;
        List<Validity> validity = null;
        try {
        	org = Equipment.findorg(conn);
        	validity=Equipment.findvalidity(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.setAttribute("errororg", errororg);
        request.setAttribute("errorvalidity", errorvalidity);
		request.setAttribute("org", org);
		request.setAttribute("validity", validity);
		
		
		String date = date_time.date();
		request.setAttribute("date", date);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Addguarantee.jsp");

		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ORG = (String) request.getParameter("ORG");
		System.out.println("ORG " + ORG);
		
		String VALIDITY = (String) request.getParameter("VALIDITY");
		System.out.println("VALIDITY " + VALIDITY);
		String month = (String) request.getParameter("month");
		System.out.println("month - " + month);
		
		
		HttpSession session = request.getSession();
    	Connection conn = logUser.getStoredConnection(session);
		
		
		
		
		doGet(request, response);
	}
}

