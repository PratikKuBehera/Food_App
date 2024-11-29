<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.List" %>    
<%@ page import = "com.tap.classes.Restaurant" %>
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
    
    <link rel="stylesheet" href="style2.css">
    
<title>My Food App</title>
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
               <a href="OrderHistory" ><i class="bi bi-clock-history" style="font-size: 40px; color:#f7f7f7;"></i></a>
              <a href="Cart.jsp"><i class="bi bi-cart4 m-3"  style="font-size: 40px; color:#f7f7f7;"></i></a>
              <% User user = (User)session.getAttribute("LoggedInUser"); %>
              <%if(user!=null)
              {
              	%><a href="userdetail.jsp"><i class="bi bi-person-circle m-2" style="font-size: 40px; color:#f7f7f7;"></i></a>
             <% }
              else
              {
              %>
              <a href="Login.jsp"><button type="button" class="btn btn-success mt-3 ms-2">Login</button></a>              
              <a href="Register.jsp"><button type="button" class="btn btn-success mt-3 ms-2">Register</button></a>
              
              <%} %>
            </form>
          </div>
        </div>
      </nav>
      
   <!-- Slider -->
<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3000"> 
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="https://img.freepik.com/free-vector/hand-drawn-recipes-youtube-thumbnail_23-2148912713.jpg?t=st=1731694101~exp=1731697701~hmac=64efad773fab364a04ac7646f929bb806f03398fa9620f18e32e1bbf762cfd3f&w=1380" class="d-block w-100" style="height: 560px" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://img.freepik.com/free-vector/hand-drawn-recipes-youtube-thumbnail_23-2148912714.jpg?t=st=1731693980~exp=1731697580~hmac=7b7fc93e7bc3e05928a21868b5e3b7b5d8c8e0569d8e915f9e3b4243330a187a&w=1380" class="d-block w-100" style="height: 560px" alt="...">
        </div>
        <div class="carousel-item">
            <img src="https://img.freepik.com/free-psd/web-banner-template-restaurant-memphis-style_23-2148168821.jpg?t=st=1731694193~exp=1731697793~hmac=d16fd505aca97e30fa84593aa9acb1ab06fd0f7439b5cc2e712ff08467362439&w=1380" class="d-block w-100" style="height: 560px" alt="...">
        </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
    </button>
</div>

<!-- Optional JavaScript to trigger automatic slide -->
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var myCarousel = document.querySelector('#carouselExampleIndicators');
        var carousel = new bootstrap.Carousel(myCarousel, {
            interval: 3000,  // Time in milliseconds between slides
            ride: 'carousel' // Auto-start carousel
        });
    });
</script>

<!-- --------------------------------------------------------------------------------------------------------------------------------------- -->

  
 <!-- Cuisine Section -->
<div class="container-fluid">
    <!-- Tagline -->
    <div class="row">
        <div class="col-12">
            <h3 class="custom-title display-6 text-center mt-5 mb-4">Recommend</h3>
        </div>
    </div>

    <!-- Carousel Slider -->
    <div id="cuisineCarousel" class="carousel slide" data-bs-ride="carousel" data-bs-interval="3000">
        <div class="carousel-inner">
            <!-- Slide 1 -->
            <div class="carousel-item active">
                <div class="row justify-content-center">
                    <div class="col-md-3" style="width: 18rem;  margin-left: 30px">
                        <div class="card" style="width: 16rem; height: 300px">
                            <img src="https://junoonindiancuisine.com/order/wp-content/uploads/2023/04/tandoori-soya-chaap.jpg" class="card-img-top" style=" height: 300px"alt="North Indian">
                            <div class="card-body">
                                <h5 class="card-title">Tandoori Soya Chaap </h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3" style="width: 18rem;  margin-left: 30px">
                        <div class="card" style="width: 16rem;  height: 300px;">
                            <img src="https://assets.unileversolutions.com/recipes-v2/252553.jpg" class="card-img-top"style=" height: 300px" alt="South Indian">
                            <div class="card-body">
                                <h5 class="card-title">Chicken Shawarma</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3" style="width: 18rem;  margin-left: 30px">
                        <div class="card" style="width: 16rem;height: 300px">
                            <img src="https://www.pamperedchef.com/iceberg/com/recipe/11508-lg.jpg" class="card-img-top" style=" height: 300px" alt="Chinese">
                            <div class="card-body">
                                <h5 class="card-title">Chicken Pizza</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3" style="width: 18rem;  margin-left: 30px">
                        <div class="card" style="width: 16rem; height: 300px">
                            <img src="https://homecookingcollective.com/wp-content/uploads/2024/01/Butter_Paneer_LEAD_1-2-2.jpg" class="card-img-top"  style=" height: 300px"alt="Italian">
                            <div class="card-body">
                                <h5 class="card-title"> Paneer Butter Masala </h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Slide 2 -->
            <div class="carousel-item">
                <div class="row justify-content-center">
                    <div class="col-md-3" style="width: 18rem;  margin-left: 30px">
                        <div class="card" style="width: 16rem; height: 300px">
                            <img src="https://www.licious.in/blog/wp-content/uploads/2020/10/butter-chicken--600x600.jpg" class="card-img-top" style=" height: 300px"alt="Item 1">
                            <div class="card-body">
                                <h5 class="card-title">chicken butter masala</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3" style="width: 18rem;  margin-left: 30px">
                        <div class="card" style="width: 16rem; height: 300px">
                            <img src="https://www.cubesnjuliennes.com/wp-content/uploads/2020/07/Chicken-Biryani-Recipe.jpg" class="card-img-top"style=" height: 300px" alt="Item 2">
                            <div class="card-body">
                                <h5 class="card-title">Chicken Biryani</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3" style="width: 18rem;  margin-left: 30px">
                        <div class="card" style="width: 16rem; height: 300px">
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqn_cNkltBYyleYVRoQLhJlzFgVibsWxSlng&s" class="card-img-top"style=" height: 300px" alt="Item 3">
                            <div class="card-body">
                                <h5 class="card-title">Murgh Musallam</h5>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3" style="width: 18rem;  margin-left: 30px">
                        <div class="card" style="width: 16rem;height: 300px">
                            <img src="https://i.ytimg.com/vi/2x0NP_IWO3s/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLCD2jo8naCqrHrlIUVbhRy6qUv5Ng" class="card-img-top" style=" height: 300px"alt="Item 4">
                            <div class="card-body">
                                <h5 class="card-title">Mutton Nihari </h5>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Carousel Controls -->
        <button class="carousel-control-prev" type="button" data-bs-target="#cuisineCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#cuisineCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
</div>

<!-- JavaScript -->
<script>
    document.addEventListener('DOMContentLoaded', function () {
        var cuisineCarousel = document.querySelector('#cuisineCarousel');
        new bootstrap.Carousel(cuisineCarousel, {
            interval: 3000, // Slide every 3 seconds
            ride: 'carousel'
        });
    });
</script>

    
    


<!-- Restaurants -->

  <div class="container-fluid">
         <!--Tagline-->
        <div class="row">
          <div class="col-12">
              <h3 class="custom-title display-6 text-center mt-5 mb-4">Restaurants</h3>
          </div>
        </div>
     </div>
     
        
     
 <div class="container-fluid mt-5">
 
  <div class="row justify-content-evenly">
  
    <%  
       List<Restaurant> reslistt =(List<Restaurant>)session.getAttribute("restaurant");
    
       if(reslistt != null && !reslistt.isEmpty()){
    	   for(Restaurant r : reslistt){
     %>
    
            <div class="col">
    		      <div class="card " style="width: 19rem; margin-left: 30px;">
    			  <img src="<%=r.getImagePath()%>" class="card-img-top" style="height: 300px " alt="...">
    			  <div class="card-body">
    			    <h5 class="card-title"> <%= "Name:"+" "+r.getName() %>  </h5>
    			    <h5 class="card-title"> <%= "Cusine : "+" "+r.getCuisine() %>  </h5>
    			    <h5 class="card-title"> <%= "Rating : "+" "+r.getRating() %>  </h5>
    			    <p class="card-text"> A cozy downtown restaurant serving farm-to-table dishes, featuring artisanal pizzas and pastas, paired with curated wines and craft beers.</p>
    			    <a href="Showmenu?restId=<%= r.getRestaurantId() %>"class="btn btn-danger">Click Here</a>
    		      </div>
    		   </div>
    		    </div>
           
    <%   }
    	   
       }
       else {%>
       
            <div class="col-12 text-center">
				<p>No restaurants found</p>
			</div>
           
       
       <%} %>

  
   </div>
 </div>
 
 <!-- ------------------------------------------------------------------------------------------------------------------------ -->
 
 
 <!-- Cuisine -->

  <div class="container-fluid">
         <!--Tagline-->
        <div class="row">
          <div class="col-12">
              <h3 class="custom-title display-6 text-center mt-5 mb-4">Cuisine Available</h3>
          </div>
        </div>
     </div>
     
     
     <div class="container-fluid mt-5">
 
  <div class="row justify-content-evenly">
    <div class="col">
      <div class="card " style="width: 18rem; margin-left: 30px; ">
	  <img src="https://media.istockphoto.com/id/1169694902/photo/assorted-indian-non-vegetarian-food-recipe-served-in-a-group-includes-chicken-curry-mutton.jpg?s=612x612&w=0&k=20&c=J4jX3IYGdS3ODgHF0LHCySDo6bFObh0_GZzAqHgXZgU=" class="card-img-top" alt="...">
	  <div class="card-body">
	    <h5 class="card-title">North Indian</h5>
	    <p class="card-text">North Indian cuisine features rich, flavorful dishes like biryani, butter chicken, and paneer, often accompanied by naan and aromatic spices.</p>
      </div>
   </div>
    </div>
    
    <div class="col">
       <div class="card" style="width: 18rem;  margin-left: 30px">
	      <img src="https://sukhis.com/app/uploads/2022/09/image3-5-900x601-1.jpg" class="card-img-top" alt="...">
	   <div class="card-body">
	    <h5 class="card-title">South Indian</h5>
	    <p class="card-text">South Indian cuisine is known for its flavorful dishes like dosa, idli, and sambar, with rice and lentils as staplesMeals are traditionally served on banana leaves.</p>
      </div>
    </div>  
   </div>
   
     <div class="col">
      <div class="card " style="width: 18rem;  margin-left: 30px">
	  <img src="https://images-cdn.welcomesoftware.com/Zz0zMDM2ZWM5NmQ5YjAxMWViODcwYmI5NWUzYmNlYzM0NA==/Zz01NTg2OGYyMmQ4MmYxMWViOGM4NjRkNDA4MzFmNzQ4OA%3D%3D.jpg?width=1366" class="card-img-top" alt="...">
	  <div class="card-body">
	    <h5 class="card-title">Chinese</h5>
	    <p class="card-text">Chinese cuisine features diverse flavors and ingredients, with popular dishes like stir-fries, dumplings, and noodles, often enhanced by soy sauce and spices.</p>
      </div>
   </div>
    </div>
    
    <div class="col">
        <div class="card" style="width: 18rem;  margin-left: 30px">
	  <img src="https://miragas.com.my/wp-content/uploads/2022/10/articale-oct22-02.jpg" class="card-img-top" alt="...">
	  <div class="card-body">
	    <h5 class="card-title">Italian</h5>
	    <p class="card-text">Italian cuisine is renowned for its pasta, pizzas, and risottos, emphasizing fresh ingredients like tomatoes, basil, and olive oil for flavor.</p>
      </div>
   </div>
    </div>
   </div>
 </div>
   
   <!-- ---------------------------------------------------------------------------------------------------------------------------------------- -->
   
 
     <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>