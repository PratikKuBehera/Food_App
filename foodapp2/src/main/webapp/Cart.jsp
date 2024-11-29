<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.tap.classes.CartItems" %>
<%@ page import="com.tap.manager.CartImp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Shopping Cart</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css">
    <!-- Custom CSS -->
</head>
<body>
     <!--Navb Bar-->

    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color:#1E201E;">
    <div class="container-fluid d-flex justify-content-between">
      <a href="Home.jsp" style="text-decoration: none;">
         <h3 style="color: #bb3e03; font-family:cursive; font-size: 2rem; font-weight: bold; margin: 0;">
             Swaad
        </h3>
       </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav w-100 d-flex justify-content-center">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="Home.jsp" style="color: #f7f7f7; font-size: 1.5rem; font-weight: bold;">Home</a>
                </li>
               
            </ul>
            <form class="d-flex" role="search">
              <a href="Cart.jsp"><i class="bi bi-cart4 m-3"  style="font-size: 40px; color:#f7f7f7;"></i></a>
              <a href="userdetail.jsp"><i class="bi bi-person-circle m-2" style="font-size: 40px; color:#f7f7f7;"></i></a>
            </form>
          </div>
        </div>
      </nav>
 <!-- Shopping Cart Section -->
<div class="container my-5 d-flex justify-content-center">
    <div class="card shadow-lg" style="max-width: 600px; width: 100%;">
        <div class="card-body">
            <h2 class="text-center mb-4">Shopping Cart</h2>
            <div class="cart-container">
                <div class="cart-items">
                    <%
                        CartImp cart = (CartImp) session.getAttribute("cart");
                        Map<Integer, CartItems> cartmap = cart != null ? cart.getItems() : null;
                        float totalPrice = 0.0f;

                        if (cartmap != null && !cartmap.isEmpty()) {
                            for (CartItems item : cartmap.values()) {
                                double itemTotal = item.getPrice() * item.getQuantity();
                                totalPrice += itemTotal;
                    %>
                    <!-- Single Cart Item -->
                    <div class="row align-items-center border-bottom py-3">
                        <div class="col-4">
                            <img src="<%= item.getRestaurantId().getImagePath() %>" alt="Product Image" class="img-fluid rounded">
                        </div>
                        <div class="col-5">
                            <h6><%= item.getRestaurantId().getName() %></h6>
                            <p><strong>Item:</strong> <%= item.getName() %></p>
                            <p><strong >Price:</strong > Rs <%= item.getPrice() %></p>
                        </div>
                        <div class="col-3">
                            <form action="UpdateCartItem" method="get">
                                <input type="hidden" name="itemId" value="<%= item.getMenuId() %>">
                                <input type="number" name="quantity" value="<%= item.getQuantity() %>" class="form-control" min="1">
                                <button type="submit" class="btn btn-warning btn-sm mt-2">Update</button>
                            </form>
                            <form action="RemoveCartItem" method="get" class="mt-2">
                                <input type="hidden" name="itemsId" value="<%= item.getMenuId() %>">
                                <button type="submit" class="btn btn-danger btn-sm">Remove</button>
                            </form>
                        </div>
                    </div>
                    <%      }
                        } else { %>
                    <!-- Empty Cart Message -->
                    <p class="text-center">Your cart is empty!</p>
                    <% } %>
                </div>

                <!-- Total Price Section -->
                <div class="cart-total text-end mt-4">
                    
                       	 <form action="PlaceOrder" method="post">
                           <input type="hidden" name="totalPrice" value="<%= totalPrice %>">
                             <h4>Total: Rs <span><%= totalPrice %></span></h4>
                           <button type="submit" class="btn btn-success">Place Order</button>
                        </form>  	 
                </div>
            </div>
        </div>
    </div>
</div>


    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
