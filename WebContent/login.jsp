
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
      <a class="navbar-brand" href="#">WebSiteName</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="home">Home</a></li>
      <li><a href="#">A propos</a></li>
      <li><a href="#">Catégories</a></li>
      <li><a href="signin">S'enregistrer</a></li>
      
      <% if(request.getSession().getAttribute("login") == null){ %>
		<li class="active"><a href="#">Connexion</a></li>
	<%}else{%>
	<li class=""><a href="auth/addproject">Ajouter un projet</a></li>
	<li class="active"><a href="logout">Logout</a></li>
	<%	} %>
    </ul>
  </div>
</nav>

	<% if(request.getSession().getAttribute("login") == null){ %>
		<%@ include file="login.html" %>
	<%}else{%>
	
	<h1>Vous etes deja connecté</h1>
	<%	} %>
	
</body>
</html>