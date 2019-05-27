<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add to cart</title>
</head>
<body>
<%@ page import="java.sql.*, java.util.Random"%>
<%! 
	/* private static int Order_idCounter = 1;
	public static synchronized int Order_createID()
	{
    	return Order_idCounter++;
	} */
%>
<%  String input=request.getParameter("p");
	//System.out.print(input);
    //String str=request.getParameter("qty");
    //System.out.print(str);
    int selectedID=0;
    
    try{ 
    	selectedID=Integer.parseInt(request.getParameter("p"));
    	
       }catch(NumberFormatException ex)
    		{	
    			System.err.println("Ilegal input");
    		}
    
	//try{	int qty=Integer.parseInt(str); //}catch(NumberFormatException ex){System.err.println("Ilegal input");}
	try{
	
		Class.forName("com.mysql.jdbc.Driver");
   	
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/OnlineFoodOrderDB?autoReconnect=true&useSSL=false","root","root"); 
   		
			Statement st=con.createStatement();
   			ResultSet rs;
   			PreparedStatement ps;
   	
   			Integer order_id;
   			String order_id_key = new String("order id");
   		
   			if (session.getAttribute("order_id_key")==null)
   			{
  				order_id=  new Random().ints(1, 100).findFirst().getAsInt();
  				session.setAttribute("order_id_key", order_id);
	  		} 
   				//System.out.print("YO");
   				/* order_id_key=session.getAttribute("order_id_key");
   				System.out.print("Order_id_key"+session.getAttribute("order_id_key")); */
   				order_id=(Integer)session.getAttribute("order_id_key");
				System.out.println("Order_id     "+order_id);
				   //order_id=1;		
   				
				if((selectedID>=1)&&(selectedID<=9))
   				{	
   					rs=st.executeQuery("select * from food where food_id='"+selectedID+"'");
   					//System.out.println("Order_id"+order_id);
   					rs.next();
   					
   						int food_id=rs.getInt(1);
   						String food_name=rs.getString(2);
   						int food_price=rs.getInt(3);
   						System.out.println("FOOD ADDED TO CART "+food_name);
   						System.out.println("Order_id"+order_id);
   						
   						session.setAttribute("food_id_key", food_id);
   						session.setAttribute("food_name_key", food_name);
   						session.setAttribute("food_price_key", food_price);
   			
   					ps=con.prepareStatement("insert into foodOrder values(0,?,?,?,?)");  
   			
   			 		//int order_id= new Random().ints(1, 100).findFirst().getAsInt();
   					//session.setAttribute("order_id", order_id); 
   					
   						int totalPrice=food_price;
   			 			/* order_id=(Integer)session.getAttribute(order_id_key);
   						System.out.print(session.getAttribute(order_id_key)); */
   			 			
   						ps.setInt(1, order_id);				
   						ps.setInt(2, food_id);
   						ps.setInt(3, 1);
   						ps.setInt(4, totalPrice);
   						
   						System.out.println("Order_id"+order_id);
	   				
   						ps.executeUpdate();  
   		
	   				response.sendRedirect("Welcome.jsp"); 
				}
   			 	else if((selectedID>=101)&&(selectedID<=103)) 
   				{
					rs=st.executeQuery("select * from drinks where drink_id='"+selectedID+"'");
   			
					rs.next();
					
   					int drink_id=rs.getInt(1);
   					String drink_name=rs.getString(2);
   					int drink_price=rs.getInt(3);
   			
   			
   						session.setAttribute("drink_id", drink_id);
   						session.setAttribute("drink_name", drink_name);
   						session.setAttribute("drink_price", drink_price);
  
   					ps=con.prepareStatement("insert into drinkOrder values(0,?,?,?,?)");   
   			
   			 //int order_id= new Random().ints(1, 100).findFirst().getAsInt();
   			//session.setAttribute("order_id", order_id); 
   					 int totalPrice=drink_price;
   					
   					
   						ps.setInt(1, order_id);				
   						ps.setInt(2, drink_id);
   						ps.setInt(3, 1);
   						ps.setInt(4, totalPrice);
   		 
   		          
   					ps.executeUpdate(); 
   					response.sendRedirect("Welcome.jsp"); 
   		} 		
				Statement st1=con.createStatement();
   				Statement st2=con.createStatement();
				ResultSet rs1=st1.executeQuery("select count(*) as drinkno from drinkOrder where order_id='"+order_id+"'");
				ResultSet rs2=st2.executeQuery("select count(*) as foodno from foodOrder where order_id='"+order_id+"'");
				rs1.next(); rs2.next();
				int dno=rs1.getInt("drinkno");
				int fno=rs2.getInt("foodno");
				int no_of_items=dno+fno;
				System.out.println("Total rows "+no_of_items);
				session.setAttribute("no_of_items_key", no_of_items);
   				con.close();
	}catch(Exception e){ 
		e.printStackTrace();
						}
   	
   %>
</body>
</html>
