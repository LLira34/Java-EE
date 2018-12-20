<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Java EE</title>
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" 
		integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" 
		crossorigin="anonymous">
	</head>
	<body>
		<nav class="navbar" role="navigation" aria-label="main navigation">
			<div class="navbar-brand">
				<a class="navbar-item" href="https://www.oracle.com/mx/java/technologies/java-ee.html">
			   		<img src="template/images/java32.png">
			    </a>
			
			    <a role="button" class="navbar-burger burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
			    	<span aria-hidden="true"></span>
			      	<span aria-hidden="true"></span>
			      	<span aria-hidden="true"></span>
			    </a>
			 </div>
			
			 <div id="navbarBasicExample" class="navbar-menu">
			 	<div class="navbar-start">
			    	<a class="navbar-item" href="index.jsp">Home</a>
			    	
			      	<div class="navbar-item has-dropdown is-hoverable">
				    	<a class="navbar-link">Songs</a>
						<div class="navbar-dropdown">
				        	<a class="navbar-item" href="songs_list.jsp">List</a>
				         	<a class="navbar-item" href="songs_form.jsp">Form</a>
				       </div>
				       
					</div>
					<div class="navbar-item has-dropdown is-hoverable">
				    	<a class="navbar-link">Records</a>
						<div class="navbar-dropdown">
				        	<a class="navbar-item" href="records_list.jsp">List</a>
				         	<a class="navbar-item" href="records_form.jsp">Form</a>
				       </div>
					</div>
			    </div>
			
				<div class="navbar-end">
			    	<div class="navbar-item">
			        	<div class="buttons">
			          		<a class="button is-primary"><strong>Sign up</strong></a>
			          		<a class="button is-light">Log in</a>
			        	</div>
			      	</div>
			    </div>
			</div>
		</nav>
		
		<script type="text/javascript" src="template/js/app.js"></script>
	</body>
</html>