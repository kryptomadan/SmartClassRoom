<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Dashboard</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/subject.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Krona+One&display=swap" rel="stylesheet">
 <style> .navigation a:hover{color:aqua;} 
  </style>   

</head>
<body>
<% if (session.getAttribute("rollno")==null)
{
	response.sendRedirect("../html/studentlogin.html");
}
%>
<header class="header" >
        <div class="left-header"><img src="../img/logo.png"></div>
       <div class="sub-header">
           

           <div class="inner_header"><h1>SMART<span>ClassRoom</span></h1> </div>
           
        <ul class="navigation">
            <a href="Student"><li>Student Dashboard</li></a>
            
            <a href="studentlogout"><li>Logout</li></a>
            <p style="color:aqua; cursor: pointer;">Welcome ${stdname} <b style="color:yellow;">(${secandsem})</b> </p>
            
        </ul>
       </div>   
    </header>
    
    <!-- start of the subject container -->
    <c:forEach items="${stdsubs}" var="s">
    <div class="maincontainer">
    <div class="subject-container">
   
    	<div class="container-header">
    	
    	<form action="studentsubject" id="shows${s.sub}" method="post">
    	<!-- the below code is used for calling the form without the help of submit button using javascript -->
    	<a href="javascript:{}" onclick="document.getElementById('shows${s.sub}').submit();"><h1> ${s.sub} </h1></a>
    	
    	<input type="hidden" value="${s.subid}" name="showsub">
    	
    	</form>
    	</div>
    	
    	
    	
    	<div class="subject-description">
    		
    		<img alt="not found" src="../img/picofsubjects.png">
    		<ul class="subnavi">
    		<!-- this is to open class page -->
            <a href="javascript:{}" onclick="document.getElementById('shows${s.sub}').submit();"><li>Class</li></a>
            <!-- this is to open assignments page -->
            <form action="studentassignmentshow" id="assignment${s.sub}" method="post">
            <input type="hidden" value="${s.subid}" name="subidshow">
            <a href="javascript:{}" onclick="document.getElementById('assignment${s.sub}').submit();"><li>Assignments</li></a>
            </form>
            <form action="studentstudymaterials" id ="materials${s.sub}" method="post" >
            <input type="hidden" value="${s.subid}" name="showsub">
            <a href="javascript:{}" onclick="document.getElementById('materials${s.sub}').submit();"><li>Study Materials</li></a>          
            </form>
        </ul>
    		
    	</div>
    	
    </div>
    </div>
    </c:forEach>
    <!-- end of subject container -->
</body>
</html>