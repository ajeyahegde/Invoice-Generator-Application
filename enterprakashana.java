

import java.io.IOException;
import java.io.PrintWriter;

import bills2.DatabaseAccess;
import bills2.DatabaseAccess.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class enterprakashana
 */
@WebServlet("/enterprakashana")
public class enterprakashana extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enterprakashana() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DatabaseAccess d=new DatabaseAccess();
		PrintWriter out=response.getWriter();
		String pname,owner,paddress;
		pname=request.getParameter("pname");
		owner=request.getParameter("owner");
		paddress=request.getParameter("paddress");
		d.setPrakashanaDetails(pname, owner, paddress);
		out.println("<br>You inserted prakashana detials as follows");
		out.println("<br>Prakashana Name: "+pname);
		out.println("<br>Prakashana Address: "+paddress);
		out.println("<br>Prakashana Owner: "+owner);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
