

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import bills2.DatabaseAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewprakashana
 */
@WebServlet("/viewprakashana")
public class viewprakashana extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewprakashana() {
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
		ResultSet rs=d.getPrakashanaTable();
		String pname,link;
		try{
		while(rs.next())
		{
			pname=rs.getString(1);
			out.println("<br>"+pname);
			link="displayprakashanadetails?param="+pname;
			//out.println("<a href='author1?param='> View </a>");
			out.println("<a href='"+ link +"'> View </a>");
		}
		}catch(Exception e){
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
