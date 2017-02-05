

import java.io.IOException;
import java.sql.*;
import java.io.*;

import bills2.DatabaseAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewcustomer
 */
@WebServlet("/viewcustomer")
public class viewcustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewcustomer() {
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
		ResultSet rs=d.getCustomerTable();
		String caddress,link;
		try{
			while(rs.next())
			{
				caddress=rs.getString(2);
				out.println("<br>"+caddress);
				link="displaycustomerdetails?param="+caddress;
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
