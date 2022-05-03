<%@ page language="java" contentType="text/html; charset=utf-8"
 pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html class="bg-dark">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script> -->
    
<script type="text/javascript" src="js/jquery-1.8.0.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <script>
  $(function() {
    $("#datepicker").datepicker(		
    		);
  });
  $.datepicker.setDefaults({
     
      dateFormat: 'yy-mm-dd'
});
</script>
<title>New Task</title>
</head>
<body>

 <div align="center" class="bg-dark ">
 <div class="jumbotron center">
  <div align="center">
 	<a href="/ProjectToDoApp/tasks/" class="bi bi-link"><i style="margin-right: 0.5em; color: #EEEEEE;" class="icon-home icon-4x"></i>Powrót</a></div>
  <h2>Nowe zadanie</h2>
 </div>

	 <form:form action="save" class="text-light" method="post" modelAttribute="task">
	 
	<div class="container col-lg-4">
	
	 <div>

	 <label style="font-size: 20px;">Nazwa: </label>
	 <form:input   required="required" path="name"  class="form-control " /> 
	 </div>
	 
	 <div> 
	 <label  style="font-size: 20px;" >Opis: </label>
	 <form:textarea path="description" class="form-control" rows="3" /> 
	 </div>	 
	 
	 <div>
	 <label style="font-size: 20px;">Data: </label>
	  <form:input   path="date" type="text" id="datepicker" autocomplete="off" class="form-control text-center"/>
	 </div>		  
	 <div>
	 <div>
	 <div class="col-lg-12  text-align-right">
	  <br>  	

 		<label style="font-size: 20px;">Kategoria: </label>
 			
		 <c:forEach var="category" items="${categories}">
		 <div class="col-lg-6 ">
		<p class="text-warning">	${category.name} <form:radiobutton path="category.id" class="form-check-label" required="required" value="${category.id}"/>  </p>
		 </div>      		
    	</c:forEach>	    		
	</div>	
	</div>
		  		 <br>  	
	 <div>
	 <label style="font-size: 20px;">Etykieta: </label>

		 <form:select path="etykieta" class="form-control">
		 	  <form:option value="Inne">Inne</form:option>
			  <form:option value="Praca">Praca</form:option>
			  <form:option value="Nauka">Nauka</form:option>
			  <form:option value="Dom">Dom</form:option>
			  <form:option value="Priorytetowe">Priorytetowe</form:option>
			  <form:option value="Organizacyjne">Organizacyjne</form:option>			  
		 </form:select>
		 </div>	 
	
		  <input class="btn btn-primary btn-block" type="submit" value="Save">
		 </div>	 
	 </div>		 	 
	 </form:form>

 </div>


</body>
</html> 
<style>
body {
	margin: 0;
	padding: 0;
	text-align: left;
	font: 12px Arial, Helvetica, sans-serif;
	font-size: 13px;
	color: #061C37;
	background: #CCCCCC;
	background-image:url(images/background.png);
	background-repeat:repeat-x;
}
*
{
  margin: 0 auto 0 auto;
 text-align:left;}

#container
{
  display: block; 
  height:auto;
  position: relative; 
  width: 960px;
}


#header
{
height:85px;
width:960px;	
}

#header h1
{
	position:absolute;
text-align:left;
color:#FFFFFF;
font-size:43px;
color:#FFF;	
left:14px;
top:18px;
}


#header h2
{
position:absolute;
text-align:right;
color:#EAEAEA;
left:490px;
top:38px;
width:400px;
}

#mainpic
{
background-image:url(images/main.jpg);
background-repeat:no-repeat;
width:900px;
height:354px;	
}



.off
{
color:#000000;
}


#menu
{
display:block;
float:left;
clear:both;
width:960px;
height:54px;
float:left;
clear:both;
}

#leftmenu
{
margin-top:15px;
width:204px;
float:left;
}

#leftmenu_top
{
width:204px;
height:13px;
background-image:url(images/leftmenu_top.png);
}
#leftmenu_bottom
{
width:204px;
height:13px;
background-image:url(images/leftmenu_bottom.png);
}
#leftmenu_main
{
width:204px;
height:auto;
background-color:#5B5B5B;
}

#leftmenu_main ul
{
list-style: none;
padding: 0px;
width:204px;
}


#leftmenu_main h3
{
list-style: none;
padding: 0px;
width:204px;
color:#FFFFFF;
padding-left:10px;
padding-bottom:14px;
}

#leftmenu_main ul li
{
list-style: none;
padding: 0px;
width:204px;
text-align:left;
}

#leftmenu_main ul li a, #leftmenu_main ul li a:visited
{
	display:block;
list-style: none;
padding: 0px;
width:192px;
padding-left:12px;
padding-top:4px;
height:30px;
text-align:left;
background-image:url(images/leftmenu_link.png);
background-repeat:repeat-x;
margin-top:5px;
color:#FFFFFF;
text-decoration:none;
font-size:15px;
font-weight:bold;
}

#leftmenu_main ul li a:hover
{
color:#000000;
	
	
}




#content
{
display:block;
float:left;
width:689px;
height:auto;
padding-left:10px;
padding-top:15px;
padding-right:10px;
padding-bottom:5px;
}


#content_top
{
	background-image:url(images/main_top.png);
	background-repeat:no-repeat;
	width:689px;
	height:23px;
}

#content_main
{
background-image:url(images/main_back.png);
background-repeat:repeat-y;
width:659px;
padding-left:15px;
padding-right:15px;
}

#content_bottom
{
background-image:url(images/main_bottom.png);
background-repeat:no-repeat;
width:689px;
height:23px;
}








#footer
{
width:inherit;
height:auto;
}

#footer h3 a,#footer h3 a:visited
{
display:inline;
text-align:center;
font-size:12px;
text-decoration:none;
color:#FFF;
}


#menu ul {
	list-style: none;
	padding: 0px;
	margin-left:auto;
	width:960px;
}

#menu li {
	list-style: none;
	padding: 0px;	
	display: inline; 
	
}

#menu a {
	float: left;
	height: 36px;
	display: block;
	text-align: center;
	text-decoration: none;
	color: #ffffff;
	font-weight: bold;
	padding-top: 18px;
	font-size: 15px;
	padding-left:13px;
	padding-right:13px;
	
}

#menu a:hover{
	background-image:url(images/link_background.png);
	background-repeat:repeat-x;
}

#content p
{
	
}


html, body {
text-align: center;
}
p {text-align: left;}


.dropbtn {
  background-color: gray;
  color: white;
  padding: 16px;
  font-size: 16px;
  border: none;
  cursor: pointer;
  margin-left: 270px;
  margin-bottom: 20px;
}

.dropbtn:hover, .dropbtn:focus {
  background-color: gray;
}

.dropdown {
  position: relative;
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 200px;
  overflow: auto;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
  margin-left: 230px;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

.dropdown a:hover {background-color: #ddd;}

.show {display: block;}

</style>