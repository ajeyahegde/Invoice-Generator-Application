

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseClient.SqlClient;

/**
 * Servlet implementation class displayprakashanadetails
 */
@WebServlet("/DisplayPrakashanaDetails")
public class DisplayPrakashanaDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPrakashanaDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		SqlClient d=new SqlClient();
		String prakashananame=request.getParameter("param");
		out.println("<br>Prakashana Details are as follows");
		ResultSet rs=d.getPrakashanaDetails(prakashananame);
		String prakashanaaddress,owner;
		try{
		while(rs.next())
		{
			owner=rs.getString(2);
			prakashanaaddress=rs.getString(3);
			out.println("<br>Prakashana Name: "+prakashananame);
			out.println("<br>Prakashana Address: "+prakashanaaddress);
			out.println("<br>Prakashana Owner: "+owner);
			
		}
		}
		catch(Exception e){}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
