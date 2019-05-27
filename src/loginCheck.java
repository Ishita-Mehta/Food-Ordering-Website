package pkg;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class loginCheck
 */
@WebServlet("/loginCheck")
public class loginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String emailID, password;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public loginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out=response.getWriter();
		emailID=request.getParameter("email");
		password=request.getParameter("password"); 
		
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineFoodOrderDB?autoReconnect=true&useSSL=false","root","root");  
			Statement stmt  =con.createStatement();
			//out.print("select customer_password from customer where customer_emailID='"+emailID+"'");
			//out.println(password);
			ResultSet rs=stmt.executeQuery("select * from customer where customer_emailID='"+emailID+"'"); 
				while(rs.next())
				{	
					if((rs.getString(4)).equals(password))
					{	RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");  				  
					    rd.forward(request, response);
					}	
					else
					{	//response.getWriter().append("Sorry UserName or Password Error!");  
			        	RequestDispatcher rd=request.getRequestDispatcher("loginError.html");  
			        	rd.include(request, response);  
				    }
				}	
			con.close();
		   }catch(Exception e){  e.printStackTrace();}
		
    }
	
	/*int connection()
	{	try{  

			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineFoodOrderDB","root","root");  
			Statement stmt  =con.createStatement();
			ResultSet rs=stmt.executeQuery("select customer_password from customer where customer_emailID='"+emailID+"';"); 
				
				while(rs.next())  
				{
					if((rs.getString(4)).equals(password))
						return 1;
					else
						return 0;
				}	
			con.close();
		   }catch(Exception e){  e.printStackTrace();}
return 0;
}*/

}
