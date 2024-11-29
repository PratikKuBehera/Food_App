<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "com.tap.classes.User" %>
<%@ page import = "com.tap.classes.Menu" %>
<%@ page import = "java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout Page</title>
<style>
    /* Your existing CSS */
    
    
 <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }
        input[type="text"], textarea, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            padding: 10px 20px;
            background: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background: #0056b3;
        }
        .bot-container {
            margin-top: 30px;
            text-align: center;
        }
        .bot {
            width: 100px;
            height: 100px;
            background-color: #007bff;
            color: #fff;
            font-size: 20px;
            border-radius: 50%;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto;
            cursor: pointer;
            transition: background 0.3s ease;
        }
        .bot:hover {
            background-color: #0056b3;
        }
    </style>
</style>
</head>
<body>
<%
    Float price = (Float) session.getAttribute("totalPrice");
    User user = (User) session.getAttribute("LoggedInUser");
    List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
    Menu menu = null;

    if (menuList != null && !menuList.isEmpty()) {
        menu = menuList.get(0); // Retrieve the first menu item
    }
%>

<div class="container">
    <h2>Checkout Payment Page</h2>
    <form action="Insertintoorder">

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" 
                   value="<%= user != null ? user.getName() : "N/A" %>" readonly>
        </div>

        <div class="form-group">
            <label for="restaurant">Restaurant Name:</label>
            <input type="text" id="restaurant" name="RestaurantName" 
                   value="<%= menu != null && menu.getRestaurant() != null ? menu.getRestaurant().getName() : "N/A" %>" readonly>
        </div>

        <div>
            <input type="hidden" id="restaurantId" name="RestaurantID" 
                   value="<%= menu != null && menu.getRestaurant() != null ? menu.getRestaurant().getRestaurantId() : "" %>">
        </div>

        <div class="form-group">
            <label for="items">Items Name:</label>
            <input type="text" id="items" name="ItemsName" 
                   value="<%= menu != null ? menu.getItemsName() : "N/A" %>" readonly>
        </div>

        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" 
                   value="<%= user != null ? user.getAddress() : "N/A" %>" readonly>
        </div>

        <div class="form-group">
            <label for="totalAmount">Total Amount:</label>
            <input type="text" id="totalAmount" name="totalPrice" 
                   value="<%= price != null ? price : 0 %>" readonly>
        </div>

        <div class="form-group">
            <label for="paymentMode">Payment Mode:</label>
            <select id="paymentMode" name="paymentMode" required>
                <option value="" disabled selected>Select payment mode</option>
                <option value="Credit Card">Credit Card</option>
                <option value="Debit Card">Debit Card</option>
                <option value="Net Banking">Net Banking</option>
                <option value="UPI">UPI</option>
                <option value="Cash on Delivery">Cash on Delivery</option>
            </select>
        </div>

        <button type="submit">Payment</button>
    </form>
</div>
</body>
</html>
