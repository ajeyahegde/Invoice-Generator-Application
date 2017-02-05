

import java.io.IOException;
import java.io.PrintWriter;

import bills2.DatabaseAccess;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class enterbooks
 */
@WebServlet("/enterbooks")
public class enterbooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enterbooks() {
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
		String bname,author,pname;
		int year,pages,price,quantity;
		bname=request.getParameter("bname");
		author=request.getParameter("author");
		pname=request.getParameter("pname");
		price=Integer.parseInt(request.getParameter("price"));
		pages=Integer.parseInt(request.getParameter("pages"));
		quantity=Integer.parseInt(request.getParameter("quantity"));
		year=Integer.parseInt(request.getParameter("year"));
		d.setBookDetails(bname, author, price, quantity, pages, year, pname);
		out.println("<br>You inserted Book detials as follows");
		out.println("<br>Book Name: "+bname);
		out.println("<br>Book Price"+price);
		out.println("<br>Author Name"+author);
		out.println("<br>Quantity"+quantity);
		out.println("<br>Year of Release"+year);
		out.println("<br>Number of pages in Book"+pages);
		out.println("<br>Published under prakashana"+pname);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
