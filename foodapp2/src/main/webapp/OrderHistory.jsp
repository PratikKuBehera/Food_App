<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.tap.classes.OrderHistory" %>
<%@ page import="com.tap.classes.OrderItems" %>
<%@ page import="com.tap.classes.Menu" %>
<%@ page import="com.tap.manager.MenuImp" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.tap.classes.Restaurant" %>
<%@page import="com.tap.manager.OrdersImpl" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.rtl.min.css" integrity="sha384-dpuaG1suU0eT09tx5plTaGMLBsfDLzUCCUXOY2j/LSvXYuG6Bqs43ALlhIqAJVRb" crossorigin="anonymous">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    
    <title>Order History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            padding: 20px;
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
        }
        .table-container {
            max-width: 1000px;
            margin: 0 auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2);
        }
        .table {
            width: 100%;
            margin-bottom: 0;
            border-collapse: collapse;
        }
        .table th, .table td {
            border: 1px solid #dee2e6; /* Proper lines for cells */
            padding: 12px; /* Add padding inside cells */
            text-align: center; /* Center text in cells */
        }
        .table th {
            background-color: #343a40; /* Dark header for table */
            color: white;
        }
        .table tbody tr:nth-child(even) {
            background-color: #f8f9fa; /* Alternating row color */
        }
        .btn-view {
            color: white;
            background-color: #007bff;
            border: none;
            padding: 5px 10px;
            border-radius: 4px;
            text-decoration: none;
        }
        .btn-view:hover {
            background-color: #0056b3;
        }
    </style>

</head>
<body>
     <h1>Order Details</h1>
    <div class="table-container">
        <table class="table">
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Restaurant ID</th>
                    <th>Price</th>
                    <th>Order Date</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
           
           <tbody>
               <% OrdersImpl oimp= new OrdersImpl();
               
                 
               %>
            <% 
               
                List<OrderHistory> orderHistory =(List<OrderHistory>)session.getAttribute("userHistory");
                 
                 
                // Check if the object is not null before displaying
                if (orderHistory != null) {
                	
                	for(OrderHistory oh : orderHistory ){
               	    
            %>
            
                    <%  
                      int i =oh.getOrderId().getOrderId();

                       
                     %>
                <tr>
                    <td><%= oh.getOrderId().getOrderId() %></td>
                    <td><%= oimp.fetchOnOrderId(i).getRestaurentId()%></td>
                    <td><%= oh.getTotalamount()%></td>
                    <td><%= oh.getDate()%></td>
                    <td><%= oh.getStatus()%></td>
                    <td><a href="viewOrder?orderId=<%= oh.getOrderId().getOrderId()%>"> <button type="button" class="btn btn-primary mb-1">View</button></a></td>
                </tr>
            <% 
                	}
               }
            %>
        </tbody>
            
        </table>
    </div>
    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    
</body>
</html>
