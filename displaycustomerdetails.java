

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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		SqlClient sql=new SqlClient();
		String customeraddress=request.getParameter("param");
		out.print("<html><head><link rel='stylesheet' type='text/css' href='"+request.getContextPath()+"/ViewDesign.css'></head>");
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		ResultSet rs=sql.getCustomerDetails(customeraddress);
		String customername,customerphone;
		try{
			while(rs.next())
			{
				customername=rs.getNString(1);
				customerphone=rs.getNString(3);
				out.println("<br><h1>"+customername+"</h1>");
				out.println("<br>ಗ್ರಾಹಕರ ಹೆಸರು: "+customername);
				out.println("<br>ಗ್ರಾಹಕ ವಿಳಾಸ: "+customeraddress);
				out.println("<br>ಗ್ರಾಹಕರ ಫೋನ್: "+customerphone);
			}
			out.println("</html>");
		}catch(Exception e){
			System.out.println("Exception called in DisplayCustomerDetails.java:"+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
