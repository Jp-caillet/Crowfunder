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
      <li ><a href="../home">Home</a></li>
      <li><a href="#">A propos</a></li>
      <li><a href="#">Catégories</a></li>
      <li><a href="../signin">S'enregistrer</a></li>
      
      <% if(request.getSession().getAttribute("login") == null){ %>
      
		<li ><a href="#">Connexion</a></li>
	<%}else{%>
	<li class="active"><a href="#">Ajouter un projet</a></li>
	<li class=""><a href="../logout">Logout</a></li>
	<%	} %>
    </ul>
  </div>
</nav>

	
<h1> Ton projet </h1>
	<form method="post" action="addproject" >

		<div class="form-group">
			<label><b>title : </b></label> 
			<input class="form-control" type="text"
				 name="title">
		</div>	
		<div class="form-group">
			<label><b>Category : </b></label> 
			<select class=form-control name="categorie">
 	<option name="musique" >musique</option>
 		<option name="sport" >sport</option>

</select>
		</div>
			 
		
		<div class="form-group">
		<label><b>describe : </b></label>
			<textarea class="form-control" rows="4" cols="50" name="describe"> </textarea>		
		</div>
		
			<button class="btn btn-default" type="submit">ajout du project !</button>

		
	</form>
</body>
</html>