package pkg;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class registerInput
 */
@WebServlet("/registerInput")


public class registerInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String name, address, email, password;
	int cID;
	private static int idCounter = 1;
	

	public static synchronized int createID()
	{
	    return idCounter++;
	}    
	
	/*void connection(String name, String password, String address, String email)
	{	//PrintWriter out=response.getWriter();   
		System.out.print("HELLOOO");
		
			try{  

			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineFoodOrderDB","root","root");  
			Statement stmt=(Statement) con.createStatement();
			int result=stmt.executeUpdate("SELECT * FROM customer;");  
			System.out.println(result+" records affected");  
			
			PreparedStatement pstmt=con.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?);");  
				cID=createID();
					
				pstmt.setInt(1, cID); 
				pstmt.setString(2, name);				
		  		pstmt.setString(3, email);
		  		pstmt.setString(4, password);
		  		pstmt.setString(5, address);
						 
				pstmt.executeUpdate();
				
				con.close();
				
			}catch(Exception e){  e.printStackTrace();}
	
	}*/
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    
	public registerInput() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	
		name=request.getParameter("name");
		//out.println(name);
		password=request.getParameter("password");
		//out.println(password);
		address=request.getParameter("address");
		//out.println(address);
		email=request.getParameter("email");
		//out.println(email);
		
		response.setContentType("text/html");  
		
		          
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/OnlineFoodOrderDB?autoReconnect=true&useSSL=false","root","root");  
		   
			PreparedStatement ps=con.prepareStatement(  
					"insert into customer values(?,?,?,?,?)");  
			cID=createID();
			
				ps.setInt(1, cID); 
				ps.setString(2, name);				
				ps.setString(3, email);
				ps.setString(4, password);
				ps.setString(5, address);
		 
		          
		int i=ps.executeUpdate();  
		 
//		out.print("You are successfully registered...");  
		if(i>0) 
		{
		response.sendRedirect("index.html");  
		}
		}catch (Exception e2) {System.out.println(e2);}  
		          
		out.close();  
		}  
		
		
		
		
		
		
		/*try {
			Class.forName("com.mysql.jdbc.Driver");  
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineFoodOrderDB","root","root");  
			
			PreparedStatement pstmt=con.prepareStatement("INSERT INTO customer VALUES(?,?,?,?,?);");  
			cID=createID();
				
			pstmt.setInt(1, cID); 
			pstmt.setString(2, name);				
	  		pstmt.setString(3, email);
	  		pstmt.setString(4, password);
	  		pstmt.setString(5, address);
					 
			pstmt.executeUpdate();
			pstmt.close();
			con.close();*/
			//Statement stmt=(Statement) con.createStatement();
			//int result=stmt.executeUpdate("SELECT * FROM customer;");  
			//out.println(result+" records affected"); 
			
//			out.print("The whole table: \n");
//			ResultSet rs1=stmt.executeQuery("select * from customer;"); 
//			while(rs1.next())  
//			out.println(rs1.getInt(1)+"  "+rs1.getString(2)+"  "+rs1.getString(3)+"  "+rs1.getString(4)+" "+rs1.getString(5));  
	 
		 
		//connection(name, password, address, email);
		
		    //}catch(Exception e) {e.printStackTrace();}

	}

	 
//	}
	
			 


