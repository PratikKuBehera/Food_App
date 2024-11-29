<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <link rel="stylesheet" href="style.css">

<title>my food app</title>
</head>
<body>

	<div class="form-container">
	    
	    <form action="Registration">
	    
	       <h2>Registration Form</h2>
	        
	    	       
	       <div class="input-field">
	        <input type="text" id="name" name="name" required>
	        <label for="name">Name</label>
	      </div>
	      
	      <div class="input-field">
	        <input type="email" id="email" name="email" required>
	        <label for="email">Email</label>
	      </div>
	      
	      
	      <div class="input-field">
	        <input type="tel" id="mobile" name="mobile" required>
	        <label for="mobile">Mobile</label>
	      </div>
	      
	   
	       <div class="input-field">
	        <input id="address" name="address" required>
	        <label for="address">Address</label>
	      </div>
	      
	      <div class="input-field">
	        <input type="password" id="password" name="password" required>
			<label for="password">Password</label>
	      </div>
	      
	      <div class="input-field">
	        <input type="password" id="password" name="confirmpassword" required>
	        <label for="password">confirm Password</label>

	      </div>
	      <button type="submit">Register</button>
	      
	    </form>
	 </div>
	    

</body>
</html>