<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html class="bg-dark">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="style.css">
<script src=https://code.jquery.com/jquery-1.12.4.js></script>
	
	</head>
<body>

<div class="span bg-dark">
		<li class="nav-item">
          <a class="nav-link  active" aria-current="page" href='<c:url value="/login"></c:url>'>Zaloguj się ponownie</a>
        </li>
</div>

</body>

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

</style></html>