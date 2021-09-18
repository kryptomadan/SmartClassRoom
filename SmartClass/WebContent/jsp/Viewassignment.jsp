<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="DAO.subjectmodel" %> 
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View ALL</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/subjectmain.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@900&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
</head>
<body>
<% if (session.getAttribute("username")==null)
{
	response.sendRedirect("../html/teacherlogin.html");
}
%>
<header class="header" >
        <div class="left-header"><img src="../img/logo.png"></div>
       <div class="sub-header">
           

           <div class="inner_header"><h1>SMART<span>ClassRoom</span></h1> </div>
           
        <ul class="navigation">
            <a href="teacherdash"><li>Teacher Dashboard</li></a>
            <a href="addsubject.jsp"><li>Add Subject</li></a>
            <a href="logout"><li>Logout</li></a>
            <p style="color:pink; cursor: pointer;">Welcome ${teachername} </p>
            
        </ul>
       </div>   
    </header>
    
    <!-- start of the view assignment container -->
    <% 
    subjectmodel obj = new subjectmodel();
    
    %>
    <div class="viewassi-main" >
    <div class="viewassi-container"  style="overflow-y: scroll;">     	  	
   	<div id="assipopclose" class="close" > + </div>
   	<h1>${subname}Assigments</h1>
   	<c:forEach items="${viewassignment}" var="viewass">
   	<div class="viewassi-content">  
   	<p> <b>Student Name:</b>${viewass.stdname}</p>
   	<p> <b>Rollno:</b>${viewass.roll}</p>
   	<a  href="${viewass.path}" target="_blank">CLICK TO VIEW</a>
   	<c:set value="${viewass.donelate}" var="donelate" scope="session" ></c:set>
   	<% 
   	String donelate = session.getAttribute("donelate").toString();
   	if (donelate.equals("yes"))   		
   	{
   	%>
   	<p> <b>Done Late</b></p>
   <%} %>
   	</div></c:forEach>
   	
   	
    </div>
    </div>
    <!-- end of the view assignment container -->
	
	
	
	
	<script type="text/javascript">
	//this is used to redirect to the assignment page after clicking on cross symbol
	document.getElementById('assipopclose').addEventListener('click',function(){
    	window.location.href = "../jsp/assign";

      }
   	 ); 
	
	</script>
</body>
</html>