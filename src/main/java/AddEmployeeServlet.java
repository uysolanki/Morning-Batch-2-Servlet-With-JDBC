

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int eno=Integer.parseInt(request.getParameter("teno"));
		String ename=request.getParameter("tename");
		int sal=Integer.parseInt(request.getParameter("tsal"));
		String city=request.getParameter("scity");
		String gender=request.getParameter("rgen");
		String dept=request.getParameter("sdept");
		String dob=request.getParameter("ddob");
		
		try
		{
			Connection con=MySQLDbConnection.getMySQLDbConnection();
			String query="insert into servletemp values(?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, eno);
			ps.setString(2, ename);
			ps.setInt(3, sal);
			ps.setString(4, city);
			ps.setString(5, gender);
			ps.setString(6, dept);
			ps.setString(7, dob);
			
			int n=ps.executeUpdate();
			pw.print("<h1>Record Added for Employee " +ename +"</h1>");
			ps.close();
			con.close();
					
			
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
