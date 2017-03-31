

import java.io.IOException;
import java.sql.*;
import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseClient.SqlClient;

/**
 * Servlet implementation class viewcustomer
 */
@WebServlet("/ViewCustomerList")
public class ViewCustomerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomerList() {
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
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		SqlClient sql=new SqlClient();
		ResultSet rs=sql.getCustomerTable();
		String customeraddress,link;
		out.print("<html><head><link rel='stylesheet' type='text/css' href='/bills2/ViewDesign.css'></head>");
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		out.println("<h1>ಗ್ರಾಹಕರು</h1> ");
		try{
			while(rs.next())
			{
				customeraddress=rs.getNString(2);
				out.println("<br>"+customeraddress);
				link="DisplayCustomerDetails?param="+customeraddress;
				out.println("<a href='"+ link +"'> View </a>");
			}
			out.println("</html");
			}catch(Exception e)
			{
				System.out.println("Exception called in ViewCustomerList.java:"+e.getMessage());
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
