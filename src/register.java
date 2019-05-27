package pkg;
 

import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class register extends HttpServlet {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("name");  
String p=request.getParameter("password");  
String e=request.getParameter("email");  
String a=request.getParameter("address");  
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/OnlineFoodOrderDB","root","root");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into customer values(?,?,?,?,?)");  
  int in=1;
ps.setInt(1,in);  
ps.setString(2,n);  
ps.setString(3,e);  
ps.setString(4,p); 
ps.setString(5,a);  
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
} 
