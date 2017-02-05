

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
 * Servlet implementation class entercustomer
 */
@WebServlet("/entercustomer")
public class entercustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public entercustomer() {
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
		String cname,caddress,cphone;
		cname=request.getParameter("cname");
		caddress=request.getParameter("caddress");
		cphone=request.getParameter("cphone");
		d.setCustomerDetails(cname, cphone, caddress);
		out.println("<br>You inserted customer detials as follows");
		out.println("<br>Customer Name: "+cname);
		out.println("<br>Customer Address: "+caddress);
		out.println("<br>Customer Phone: "+cphone);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
