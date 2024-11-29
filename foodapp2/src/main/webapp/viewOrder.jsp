<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.tap.classes.OrderItems" %>    
<%@ page import="java.util.List" %>
<%@page import="com.tap.manager.OrdersImpl" %>
<%@page import="com.tap.classes.Restaurant" %>
<%@page import="com.tap.manager.RestaurantsImpl" %>
<%@page import="com.tap.manager.MenuImp" %>
<%@page import="com.tap.classes.Menu" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.rtl.min.css" integrity="sha384-dpuaG1suU0eT09tx5plTaGMLBsfDLzUCCUXOY2j/LSvXYuG6Bqs43ALlhIqAJVRb" crossorigin="anonymous">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    
<title>Insert title here</title>

 <style>
     body {
    font-family: Arial, sans-serif;
    background-color: #f8f9fa;
    margin: 0;
    padding: 0;
}

.container {
    max-width: 1200px;
    margin: 50px auto;
    padding: 20px;
    background: #ffffff;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

h1 {
    text-align: center;
    margin-bottom: 20px;
    color: #333333;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

thead {
    background-color: #007bff;
    color: white;
}

th, td {
    padding: 12px 15px;
    text-align: left;
    border: 1px solid #dddddd;
}

tbody tr:nth-child(even) {
    background-color: #f2f2f2;
}

tbody tr:hover {
    background-color: #f1f1f1;
}

th {
    text-transform: uppercase;
    font-size: 14px;
}

td {
    font-size: 14px;
}

@media (max-width: 768px) {
    table {
        font-size: 12px;
    }

    th, td {
        padding: 8px 10px;
    }
}


    </style>


</head>
<body>
   <div class="container">
        <h1>View Order Details</h1>
        
        <% OrdersImpl oimp= new OrdersImpl();
               
           RestaurantsImpl r= new RestaurantsImpl();
           
           MenuImp menu =new MenuImp();
          %>
        
        <% 
       // Assuming 'oditems' is a list of OrderItems set in the session
       List<OrderItems> oditems = (List<OrderItems>) session.getAttribute("oditems"); 
       %>

        <table class="order-table">
		    <thead>
		        <tr>
		            <th>Order ID</th>
		            <th>Restaurant Name</th>
		            <th>Menu Items</th>
		            <th>Quantity</th>
		            <th>Total Price</th>
		            <th>Payment Option</th>
		        </tr>
		    </thead>
      <tbody>
	        <% 
	            if (oditems != null && !oditems.isEmpty()) { 
	                for (OrderItems oi : oditems) {
	        %>
	         
	         
                    <%  
                      int i =oi.getOrderIdJoin().getOrderId();
                    
                      int rid = oimp.fetchOnOrderId(i).getRestaurentId();
                      
                      Restaurant rr =r.fetchByRestId(rid);
                      
                      int mid = oi.getMenuId();
                      
                      Menu m = menu.fetchByMenuId(mid);
                       
                     %>
	        
	        
	        <tr>
	            <td><%= oi.getOrderIdJoin().getOrderId() %></td> <!-- Assuming OrderItems has an Order object -->
	            <td><%= rr.getName() %></td> <!-- Assuming Orders has RestaurantName -->
	            <td><%= m.getItemsName() %></td> <!-- Replace with menu name lookup if available -->
	            <td><%= oi.getQuantity() %></td>
	            <td>₹<%= oi.getSubtotal() %></td>
	            <td><%= oimp.fetchOnOrderId(i).getPaymentoption() %></td> <!-- Assuming Orders has payment info -->
	        </tr>
	        <% 
	                } 
	            } else { 
	        %>
	        <tr>
	            <td colspan="8">No orders available</td>
	        </tr>
	        <% 
	            } 
	        %>
      </tbody>
  </table>
  
    </div>
  
    
  
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    
</body>
</html>