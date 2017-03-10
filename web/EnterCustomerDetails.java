

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
 * Servlet implementation class entercustomer
 */
@WebServlet("/EnterCustomerDetails")
public class EnterCustomerDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterCustomerDetails() {
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
		String customername,customeraddress,customerphone;
		customername=request.getParameter("cname");
		customeraddress=request.getParameter("caddress");
		customerphone=request.getParameter("cphone");
		d.setCustomerDetails(customername, customerphone, customeraddress);
		out.println("<br>You inserted customer detials as follows");
		out.println("<br>Customer Name: "+customername);
		out.println("<br>Customer Address: "+customeraddress);
		out.println("<br>Customer Phone: "+customerphone);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
