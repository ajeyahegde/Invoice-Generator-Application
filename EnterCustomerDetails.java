

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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out=response.getWriter();
		SqlClient sql=new SqlClient();
		String customername,customeraddress,customerphone;
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		customername=request.getParameter("cname");
		customeraddress=request.getParameter("caddress");
		customerphone=request.getParameter("cphone");
		out.println("<html><head><link rel='stylesheet' type='text/css' href='"+request.getContextPath()+"/ViewDesign.css'></head>");
		sql.setCustomerDetails(customername, customerphone, customeraddress);
		out.println("<br>ಕೆಳಗಿನಂತೆ ನೀವು ಗ್ರಾಹಕ ವಿವರಗಳನ್ನು ನಮೂದಿಸಿದ");
		out.println("<br>ಗ್ರಾಹಕರ ಹೆಸರು: "+customername);
		out.println("<br>ಗ್ರಾಹಕ ವಿಳಾಸ: "+customeraddress);
		out.println("<br>ಗ್ರಾಹಕರ ಫೋನ್: "+customerphone);
		out.println("</html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
