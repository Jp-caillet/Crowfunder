<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
      <li class="active" ><a href="#">Home</a></li>
      <li><a href="#">A propos</a></li>
      <li><a href="#">Catégories</a></li>
      <li ><a href="signin">S'enregistrer</a></li>
      
      <% if(request.getSession().getAttribute("login") == null){ %>
      
		<li ><a href="login">Connexion</a></li>
	<%}else{%>
	<li class=""><a href="auth/addproject">Ajouter un projet</a></li>
	<li class=""><a href="logout">Logout</a></li>
	<%	} %>
    </ul>
  </div>
</nav>



<%
    ArrayList<String> listProject = new ArrayList();
    listProject = (ArrayList<String>) request.getAttribute("listproject");
 
 	int i=0;
    for(Iterator<String> it = listProject.iterator(); it.hasNext();){
    	
    	
    	if(i%2==0){
    		out.println("<table class='table' border='1px' cellpadding='0' cellspacing='0'>");
    	}
    	String project = it.next();
    	
   		if(i%2!=0){
   			out.println("<tr '>");
   	    	out.println("<td style= 'height : 450px; '>Description : "+project+"</td>");
   	    	out.println("<tr>");
   		}else{
   			out.println("<tr>");
   	    	out.println("<td >title : "+project+"</td>");
   	    	out.println("<tr>");
   		}
		
    	i++;
    	
    	if(i%2==0){
    		out.println("<table> </br>");
    	}    	
    	
        
    }
 
     
%>


</body>
</html>