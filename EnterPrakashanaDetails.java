

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseClient.SqlClient;
import databaseClient.SqlClient.*;

/**
 * Servlet implementation class enterprakashana
 */
@WebServlet("/EnterPrakashanaDetails")
public class EnterPrakashanaDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterPrakashanaDetails() {
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
		SqlClient sql=new SqlClient();
		PrintWriter out=response.getWriter();
		String prakashananame,owner,prakashanaaddress;
		out.println("<a style='margin-left:90%;margin-top:10%;' href='Homepage.html'>HOME</a>");
		prakashananame=request.getParameter("pname");
		owner=request.getParameter("owner");
		prakashanaaddress=request.getParameter("paddress");
		out.println("<html><head><link rel='stylesheet' type='text/css' href='"+request.getContextPath()+"/ViewDesign.css'></head>");
		sql.setPrakashanaDetails(prakashananame, owner, prakashanaaddress);
		out.println("<br>ಸೇರಿಸಲಾಗಿದೆ ಪ್ರಕಾಶನ ವಿವರಗಳು");
		out.println("<br>ಪ್ರಕಾಶನ ಹೆಸರು: "+prakashananame);
		out.println("<br>ಪ್ರಕಾಶನ ವಿಳಾಸ: "+prakashanaaddress);
		out.println("<br>ಪ್ರಕಾಶನ ಮಾಲೀಕರು: "+owner);
		out.println("</html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
