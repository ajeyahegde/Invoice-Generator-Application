

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
 * Servlet implementation class displaycustomerdetails
 */
@WebServlet("/DisplayCustomerDetails")
public class DisplayCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCustomerDetails() {
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
		String customeraddress=request.getParameter("param");
		ResultSet rs=d.getCustomerDetails(customeraddress);
		String customername,customerphone;
		try{
			while(rs.next())
			{
				customername=rs.getString(1);
				customerphone=rs.getString(3);
				out.println("<br>Customer Name: "+customername);
				out.println("<br>Customer Address: "+customeraddress);
				out.println("<br>Customer Phone: "+customerphone);
			}
		}catch(Exception e){}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
