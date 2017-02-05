

import java.io.IOException;
import java.sql.*;
import bills2.DatabaseAccess;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class displaycustomerdetails
 */
@WebServlet("/displaycustomerdetails")
public class displaycustomerdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displaycustomerdetails() {
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
		String caddress=request.getParameter("param");
		ResultSet rs=d.getCustomerDetails(caddress);
		String cname,cphone;
		try{
			while(rs.next())
			{
				cname=rs.getString(1);
				cphone=rs.getString(3);
				out.println("<br>Customer Name: "+cname);
				out.println("<br>Customer Address: "+caddress);
				out.println("<br>Customer Phone: "+cphone);
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
