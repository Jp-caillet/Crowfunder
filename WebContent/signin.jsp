<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Crowfunder</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="home">Home</a></li>
      <li><a href="#">A propos</a></li>
      <li><a href="#">Catégories</a></li>
      <li class="active"><a href="signin">S'enregistrer</a></li>
      
      <% if(request.getSession().getAttribute("login") == null){ %>
      
		<li ><a href="login">Connexion</a></li>
	<%}else{%>
	<li class=""><a href="auth/addproject">Ajouter un projet</a></li>
	<li class=""><a href="logout">Logout</a></li>
	<%	} %>
    </ul>
  </div>
</nav>

	
<h1> Inscription</h1>
	<form method="post" action="signin" >

		<div class="form-group">
			<label><b>Adresse mail : </b></label> 
			<input class="form-control" type="text"
				placeholder="Enter Username" name="username">
		</div>		 
		
		<div class="form-group">
		<label><b>Prénom : </b></label>
			<input class="form-control" placeholder="Enter Password" name="name">		
		</div>
		<div class="form-group">
		<label><b>nom de famille</b></label>
			<input class="form-control" placeholder="Enter Password" name="lastname">		
		</div>
		<div class="form-group">
			<label><b>Mot de passe :</b></label>
			<input class="form-control" type="password" placeholder="Enter Password" name="psw">
		</div>
			<button class="btn btn-default" type="submit">c'est parti !</button>

		
	</form>
</body>
</html>