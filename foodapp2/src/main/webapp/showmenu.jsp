<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
  <%@ page import = "java.util.List" %>  
  <%@ page import ="com.tap.classes.Menu" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.rtl.min.css" integrity="sha384-dpuaG1suU0eT09tx5plTaGMLBsfDLzUCCUXOY2j/LSvXYuG6Bqs43ALlhIqAJVRb" crossorigin="anonymous">

    <!--Bootstrap Icone-->
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    
    <link rel="stylesheet" href="style2.css">
<title>Insert title here</title>

     <!-- Inline CSS for Background Image -->
     <style>
        /* Apply the background image to a pseudo-element */
        body {
            position: relative;
            height: 100vh; /* Ensure body covers the full viewport */
            margin: 0;
        }

        /* Pseudo-element for background image */
        body::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-image: url("https://t4.ftcdn.net/jpg/06/21/12/51/360_F_621125107_tLGCGvdSB1lXuYp1c5dl7VRawEMlI6oh.jpg");
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            filter: blur(10px); /* Apply blur effect */
            -webkit-filter: blur(2px); /* For Safari */
            z-index: -1; /* Ensure the background is behind content */
        }

        /* Content styling */
                .content {
            position: relative;
            z-index: 1; /* Ensures content appears above the blurred background */
            color: #fff; /* Make text readable against the background */
        }

        /* Optional: Add a dark overlay to improve text contrast */
        .overlay {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5); /* Semi-transparent overlay */
            z-index: 0; /* Overlay goes below content */
        }

    </style>
        
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
<!-- --------------------------------------------------------------------------------------------------------------------------------------------------------- -->  
  <div class="container-fluid">
         <!--Tagline-->
        <div class="row justify-content-evenly">
          <div class="col-12">
              <h3 class="custom-title display-6 text-center mt-5 mb-4">Menu</h3>
          </div>
        </div>
     </div>
     
     
  <div class="container-fluid mt-5">
 
  <div class="row justify-content-evenly">
    
    <%  
    List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
    
    if (menuList != null && !menuList.isEmpty()) {
        for (Menu m : menuList) {
     %>
     
       <div class="col">
      <div class="card " style="width: 18rem; margin-left: 40px; ">
	  <img src="<%= m.getImagePath() %>" class="card-img-top"style="height: 200px " alt="...">
	  <div class="card-body">
	    <h5 class="card-title"><%= m.getItemsName() %></h5>
	    <h5 class="card-title"><%= m.getPrice() %></h5>
	    <p class="card-text"></p>
	    
	    <form action="Cart?menuId=<%=m.getMenuId() %>">
          <input type="hidden" name="menuId" value="<%= m.getMenuId() %>">
          
               <div class="mb-2">
                  <label for="quantity<%= m.getMenuId() %>">Quantity</label>
                  <input type="number" id="quantity<%= m.getMenuId() %>" name="quantity" value="1" min="1" required>
                </div>
                
                <button type="submit" class="btn btn-danger">Add to Cart</button>
                
            </form>
	         
      </div>
   </div>
    </div>
     
     
     <%
         }
    
       }
       else{%>
  
      <div class="col-12 text-center">
				<p>No restaurants found</p>
			</div>
           
       
       <% } %>
    
   </div>
 </div>
   
     
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>