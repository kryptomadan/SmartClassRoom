<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

<title>Teacher Dashboard</title>

<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/subject.css">
 <style> .navigation a:hover{color:aqua;} </style>   
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Krona+One&display=swap" rel="stylesheet">
</head>
<body style="background: linear-gradient(to right,rgb(191, 236, 84),rgb(243, 105, 208),rgb(15, 231, 105));">
<!-- this is jsp code which is used to prevent unauthorised access to the page -->
<% if (session.getAttribute("username")==null)
{
	response.sendRedirect("../html/teacherlogin.html");
}
%>
<!-- end of unauthorised prevention code -->

<header class="header" >
        <div class="left-header"><img src="../img/logo.png"></div>
       <div class="sub-header">
           

           <div class="inner_header"><h1>SMART<span>ClassRoom</span></h1> </div>
           
        <ul class="navigation">
            <a href="teacherdash"><li>Teacher Dashboard</li></a>
            <a href="addsubject.jsp"><li>Add Subject</li></a>
            <a href="#" id="addupdates"><li>Add Updates</li></a>
            <a href="logout"><li>Logout</li></a>
            <p style="color:pink; cursor: pointer;">Welcome ${teachername} </p>
            
        </ul>
       </div>   
    </header>
   
 	
   
    <c:forEach items="${subs}" var="s">
    
    <div class="maincontainer">
    
    <div class="subject-container">
   
    	<div class="container-header">
    	
    	<form action="subject" id="shows${s.sub}" >
    	<!-- the below code is used for calling the form without the help of submit button using javascript -->
    	<a href="javascript:{}" onclick="document.getElementById('shows${s.sub}').submit();"><h1> ${s.sub} </h1></a>
    	
    	<input type="hidden" value="${s.subid}" name="showsub">
    	
    	</form>
    	</div>
    	
    	
    	
    	<div class="subject-description">
    		
    		<img alt="not found" src="../img/sub.jpg">
    		<ul class="subnavi">
    		<!-- this is to open class page -->
            <a href="javascript:{}" onclick="document.getElementById('shows${s.sub}').submit();"><li>Class</li></a>
            <!-- this is to open assignments page -->
            <form action="assignment" id="assignment${s.sub}">
            <input type="hidden" value="${s.subid}" name="showsub">
            <a href="javascript:{}" onclick="document.getElementById('assignment${s.sub}').submit();"><li>Assignments</li></a>
            </form>
            
            <form action="StudyMaterial" id ="materials${s.sub}" method="post">
            <input type="hidden" value="${s.subid}" name="showsub">
            <a href="javascript:{}" onclick="document.getElementById('materials${s.sub}').submit();"><li>Study Materials</li></a>
            </form>
            
            
        </ul>
    		
    	</div>
    	
    </div>
   </div>

   </c:forEach>
   
  <!-- adding update window -->
   <div class="update-window">
   <div class="update-container">
   <div class="update-content">
   <div id="meetpopclose" class="close" > + </div> 
   <h3>Add Updates</h3> <br> <br>
   <form action="addupdates" method="post" enctype="multipart/form-data">
   <p>Topic:  <span style="display:inline-block; width: 80px"></span> <input type="text" width="40px" height="40px" name="topic"></p> <br>
   <p>File: <span style="display:inline-block; width: 10px"></span><input type="file" name="file" ></p> <br>
   <input type="submit" >
   </form>
   </div>
   </div>
   </div>
   <!-- end of adding update window -->
   
    
 <script type="text/javascript">
 document.getElementById('addupdates').addEventListener('click',function(){
	   document.querySelector('.update-window').style.display='flex';
	   
}
	 );
 
 document.getElementById('meetpopclose').addEventListener('click',function(){
	   document.querySelector('.update-window').style.display='none';
	   
}
	 );
 </script>    
     
<% if (session.getAttribute("sub")==null) {%> 
 <footer id="footer-container">
    <div id="footer-img">
        <img src="../img/logo.png">
    </div>
    <div id="footer-queries">
        <p><span id="contact-span">For Any Queries Contact </span><br><br> 8073461256 <br> smartclass@klesnc.org</p>      
    </div>
</footer>
<!-- Footer part starts from here-->
<% } %>

</body>
</html>