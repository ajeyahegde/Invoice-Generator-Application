

import java.io.IOException;
import java.sql.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseClient.SqlClient;
import databaseClient.SqlClient.*;

/**
 * Servlet implementation class viewauthor
 */
@WebServlet("/ViewAuthorList")
public class ViewAuthorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAuthorList() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		SqlClient sql=new SqlClient();
		String authorname,link;
		ResultSet rs=sql.getAuthorTable();
		out.print("<html><head><link rel='stylesheet' type='text/css' href='/bills2/ViewDesign.css'></head>");
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		System.out.println(request.getContextPath());
		out.println("<h1>ಲೇಖಕರು</h1> ");
		try{
		while(rs.next())
		{
			authorname=rs.getNString(1);
			out.println("<br>"+rs.getNString(1));
			link="DisplayAuthorDetails?param="+authorname;
			out.println("<a href='"+ link +"'> View </a>");
		}
		out.print("</html");
		}catch(Exception e)
		{

			System.out.println("Exception called in ViewAuthorList.java:"+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
