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
import src.neris.tabl.Guarantee;
import src.neris.tabl.Org;
import src.sql.Equipment;

@WebServlet(urlPatterns = { "/Step3" })
public class Step3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Step3() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet Step3 ");

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/Step3.jsp");

		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Step = "error";
		

		if (request.getParameter("Addguarstep1") != null) {

			HttpSession session = request.getSession();
			Connection conn = logUser.getStoredConnection(session);

			List<Org> org = null;
			try {
				org = Equipment.find_org(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Step="Addguarstep1";
			request.setAttribute("org", org);
			request.setAttribute("color", "green");
			

			
		} else {
			
			Step="Step4";
			
			String guarantee_idstr = (String) request.getParameter("guar");
			Integer guarantee_id = null;

			try {
				guarantee_id = Integer.parseInt(guarantee_idstr);
			} catch (Exception e) {
			}

			String error_guar = null;
			String guarantee_info = null;
			List<Guarantee> guar = null;
			Connection conn = logUser.getStoredConnection(request.getSession());

			try {
				guar = Equipment.find_id_guar(conn, guarantee_id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error_guar = e.getMessage();
			}

			guarantee_info = guar.get(0).getdate() + " / " + guar.get(0).getmonth() + " / " + guar.get(0).getorg_name()
					+ " / " + guar.get(0).getcontract();
			Integer sizeguar = guarantee_info.length() + 3;
			System.out.println("guarantee_info: " + guarantee_info);

			request.setAttribute("errorguar", error_guar);
			request.setAttribute("guarantee_id", guarantee_id);
			request.setAttribute("guarantee_info", guarantee_info);
			request.setAttribute("sizeguar", sizeguar);

			
		}
		
		String group_id = (String) request.getParameter("group_id");
		String group_info = (String) request.getParameter("group_info");
		Integer sizegr = group_info.length() + 3;
		
		request.setAttribute("group_id", group_id);
		request.setAttribute("group_info", group_info);
		request.setAttribute("sizegr", sizegr);
		request.setAttribute("sn", request.getParameter("sn"));
		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/jsp/"+Step+".jsp");
		dispatcher.forward(request, response);
	}
}
