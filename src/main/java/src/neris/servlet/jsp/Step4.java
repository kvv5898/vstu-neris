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

import src.neris.log.logUser;
import src.neris.tabl.Received;
import src.sql.Equipment;

@WebServlet(urlPatterns = { "/Step4" })
public class Step4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Step4() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet Step4 ");

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Step4.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = logUser.getStoredConnection(request.getSession());
		String sn = (String) request.getParameter("sn");
		String group_idstr = (String) request.getParameter("group_id");
		Integer group_id = Integer.parseInt(group_idstr);
		String guarantee_idstr = (String) request.getParameter("guarantee_id");
		Integer guarantee_id = Integer.parseInt(guarantee_idstr);

		Integer count_find_received_sn = null;
		try {
			count_find_received_sn = Equipment.find_received_sn(conn, sn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (count_find_received_sn == 0) {
			String errorString = null;
			Received add_received = new Received();
			add_received.setsn(sn);
			add_received.setgroup_id(group_id);
			add_received.setguarantee_id(guarantee_id);

			try {
				Equipment.add_received(conn, add_received);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				errorString = e.getMessage();
			}

			request.setAttribute("errorString", errorString);

		} else {
			request.setAttribute("error", "Incorrect (SN - duplicate)");
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Step5.jsp");
		dispatcher.forward(request, response);
	}
}
