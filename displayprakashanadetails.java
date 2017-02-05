

import java.io.IOException;
import java.io.PrintWriter;

import bills2.DatabaseAccess;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class displayprakashanadetails
 */
@WebServlet("/displayprakashanadetails")
public class displayprakashanadetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayprakashanadetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		DatabaseAccess d=new DatabaseAccess();
		String pname=request.getParameter("param");
		out.println("<br>Prakashana Details are as follows");
		ResultSet rs=d.getPrakashanaDetails(pname);
		String paddress,owner;
		try{
		while(rs.next())
		{
			owner=rs.getString(2);
			paddress=rs.getString(3);
			out.println("<br>Prakashana Name: "+pname);
			out.println("<br>Prakashana Address: "+paddress);
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
