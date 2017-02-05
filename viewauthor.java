

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;
import bills2.DatabaseAccess.*;
import bills2.DatabaseAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewauthor
 */
@WebServlet("/viewauthor")
public class viewauthor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewauthor() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		DatabaseAccess d=new DatabaseAccess();
		String s1,s2;
		ResultSet rs=d.getAuthorTable();
		try{
		while(rs.next())
		{
			s1=rs.getString(1);
			out.println("<br>"+rs.getString(1));
			s2="author1?param="+s1;
			//out.println("<a href='author1?param='> View </a>");
			out.println("<a href='"+ s2 +"'> View </a>");
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
