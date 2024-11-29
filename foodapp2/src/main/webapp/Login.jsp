<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <link rel="stylesheet" href="style.css">

<title>My food app</title>
</head>
<body>

    <div class="wrapper">
	    <form action="Login">
	      <h2>Login</h2>
	        <div class="input-field">
	        <input type="text" name ="Email" required>
	        <label>Enter your email</label>
	      </div>
	      <div class="input-field">
	        <input type="password" name = "password" required>
	        <label>Enter your password</label>
	      </div>
	      <div class="forget">
	        <label for="remember">
	          <input type="checkbox" id="remember">
	           <p>Remember me</p>
	        </label>
	        <a href="#">Forgot password?</a>
	      </div>
	      <button type="submit">Log In</button>
	      
	    </form>
  </div>
   

</body>
</html>