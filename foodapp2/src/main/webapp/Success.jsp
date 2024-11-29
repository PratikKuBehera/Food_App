<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment Success</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <style>
        .success-container {
            text-align: center;
            padding: 50px;
            background-color: #f4f4f4;
            border-radius: 8px;
            max-width: 600px;
            margin: 0 auto;
        }
        .success-container h1 {
            color: #28a745;
        }
        .success-container p {
            font-size: 1.2rem;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="success-container">
    <h1>Payment Successful!</h1>
    <p>Your payment has been successfully processed. Thank you for your order!</p>
    <p>We will notify you once your order is ready for delivery. Meanwhile, feel free to browse our other offerings.</p>
    
    <!-- Button to return to Home or other page -->
    <a href="Home.jsp" class="btn btn-primary btn-lg mt-3">Go to Home</a>
</div>

<!-- Optional: Displaying the total amount if needed -->
<div class="container text-center mt-4" >
    <h4>Total Amount: Rs <%= session.getAttribute("totalPrice") %></h4>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
