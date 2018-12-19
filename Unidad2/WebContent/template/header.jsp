<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Java EE</title>
		<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.2/css/bulma.min.css">
	</head>
	<body>
		<nav class="navbar" role="navigation" aria-label="main navigation">
			<div class="navbar-brand">
				<a class="navbar-item" href="https://bulma.io">
			   		<img src="https://bulma.io/images/bulma-logo.png" width="112" height="28">
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
				         	<hr class="navbar-divider">
				         	<a class="navbar-item">Report an issue</a>
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
	</body>
</html>