package src.neris.servlet.jsp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.neris.log.logUser;
import src.neris.tabl.Groups;
import src.sql.Equipment;

public class InsertEquipment extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                                 throws ServletException, IOException
    {
    	
    	System.out.println("Insert Equipment");
    	HttpSession session = request.getSession();
    	Connection conn = logUser.getStoredConnection(session);
    	
    	String errorString = null;
        List<Groups> list = null;
        try {
			list = Equipment.findgroups(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
        request.setAttribute("error", errorString);
		request.setAttribute("gr", list);

    }
}