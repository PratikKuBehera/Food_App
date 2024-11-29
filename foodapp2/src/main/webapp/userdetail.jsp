<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "com.tap.classes.User" %>
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
    
    <link rel="stylesheet" href="style1.css">
    
    
<title>Insert title here</title>
</head>
<body>
	<%User user =(User) session.getAttribute("LoggedInUser"); %>
      <div class="user-form">
           <i class="bi bi-person" style="font-size: 60px;"></i><h2>User Details</h2>
        <div class="form-group">
            <label>Name:</label>
            <span><%out.println(user.getName()); %></span>
        </div>
        <div class="form-group">
            <label>Email:</label>
            <span><% out.println(user.getEmail()); %></span>
        </div>
        <div class="form-group">
            <label>Phone:</label>
            <span><%out.println(user.getMobileNo()); %></span>            
        </div>
        
       <a href="Logout"><button type="button" class="btn btn-success">Logout</button></a> 
       <a href="ViewOrder"><button type="button" class="btn btn-success">View Order</button></a> 
       
    </div>
 
      
 
 
 
 
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
 
</body>
</html>