package pkg;
import java.sql.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addToCart
 */
@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static int FO_idCounter = 1;
		private static int Order_idCounter = 1;
		public static synchronized int FO_createID()
		{
	    	return FO_idCounter++;
		}
		public static synchronized int Order_createID()
		{
	    	return Order_idCounter++;
		}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //String input=request.getParameter("p");
			//System.out.print(input);
		    //String str=request.getParameter("qty");
		    //System.out.print(str);
		    
			int selectedID=0;
		    try{ selectedID=Integer.parseInt(request.getParameter("p"));}catch(NumberFormatException ex){System.err.println("Ilegal input");}
		    System.out.print(selectedID);
			//try{	int qty=Integer.parseInt(str); //}catch(NumberFormatException ex){System.err.println("Ilegal input");}
			
		    try{ 
		    	
		    Class.forName("com.mysql.jdbc.Driver");
		   	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineFoodOrderDB?autoReconnect=true&useSSL=false","root","root"); 
		   	Statement st=con.createStatement();
		   	ResultSet rs;
		   	PreparedStatement ps;
		   		if((selectedID>=1)&&(selectedID<=9))
		   		{	
		   			rs=st.executeQuery("select * from food where food_id='"+selectedID+"'");
		   			rs.next();
		   			int food_id=rs.getInt(1);
		   			String food_name=rs.getString(2);
		   			int food_price=rs.getInt(3);
		   			HttpSession session=request.getSession();  
		   			session.setAttribute("food_id", food_id);
		   			session.setAttribute("food_name", food_name);
		   			session.setAttribute("food_price", food_price);
		   			
		   			ps=con.prepareStatement("insert into foodOrder values(?,?,?,?,?)");  
		   			int FO_id=FO_createID();
		   			int order_id=Order_createID();
		   			session.setAttribute("order_id", order_id);
		   			int totalPrice=food_price;
		   			
		   				ps.setInt(1, FO_id); 
		   				ps.setInt(2, order_id);				
		   				ps.setInt(3, food_id);
		   				ps.setInt(4, 1);
		   				ps.setInt(5, totalPrice);
		   		 
		   		          
		   				ps.executeUpdate();  
		   				RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp"); 
		   		}
		   	   
		   		
		   		else if((selectedID>=101)&&(selectedID<=103))
		   		{
					
						rs=st.executeQuery("select * from drinks where drink_id='"+selectedID+"'");
					
		   			
					rs.next();
		   			int drink_id=rs.getInt(1);
		   			String drink_name=rs.getString(2);
		   			int drink_price=rs.getInt(3);
		   			HttpSession session=request.getSession();  
		   			session.setAttribute("drink_id", drink_id);
		   			session.setAttribute("drink_name", drink_name);
		   			session.setAttribute("drink_price", drink_price);
		   			
		   			ps=con.prepareStatement("insert into drinkOrder values(?,?,?,?,?)");  
		   			int DO_id=FO_createID();
		   			int order_id=Order_createID();
		   			session.setAttribute("order_id", order_id);
		   			int totalPrice=drink_price;
		   			
		   				ps.setInt(1, DO_id); 
		   				ps.setInt(2, order_id);				
		   				ps.setInt(3, drink_id);
		   				ps.setInt(4, 1);
		   				ps.setInt(5, totalPrice);
		   		 
		   		          
		   				ps.executeUpdate(); 
		   				RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp"); 
					}
		   		}catch (SQLException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   		
		   	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
