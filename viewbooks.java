

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
 * Servlet implementation class viewbooks
 */
@WebServlet("/viewbooks")
public class viewbooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewbooks() {
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
		ResultSet rs=d.getBooksTable();
		String bname,link;
		try{
			while(rs.next())
			{
				bname=rs.getString(1);
				out.println("<br>"+bname);
				link="displaybookdetails?param="+bname;
				out.println("<a href='"+ link +"'> View </a>");
			}
			}catch(Exception e)
			{
				System.out.println("Exception");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
