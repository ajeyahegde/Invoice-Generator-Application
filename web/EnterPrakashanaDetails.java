

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
		SqlClient d=new SqlClient();
		PrintWriter out=response.getWriter();
		String prakashananame,owner,prakashanaaddress;
		prakashananame=request.getParameter("pname");
		owner=request.getParameter("owner");
		prakashanaaddress=request.getParameter("paddress");
		d.setPrakashanaDetails(prakashananame, owner, prakashanaaddress);
		out.println("<br>You inserted prakashana detials as follows");
		out.println("<br>Prakashana Name: "+prakashananame);
		out.println("<br>Prakashana Address: "+prakashanaaddress);
		out.println("<br>Prakashana Owner: "+owner);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
