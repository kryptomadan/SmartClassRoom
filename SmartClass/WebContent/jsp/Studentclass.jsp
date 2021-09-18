<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="java.time.*" %>
<%@ page import="java.time.format.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Class</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/subjectmain.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@900&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
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
            <p style="color:aqua; cursor: pointer;">Welcome ${stdname} </p>
            
        </ul>
       </div>   
</header>
 
 <!-- start of the container of the student classroom -->   
<!-- This is the subject navigation header  -->
    <div class="subject-navigation">
    <a href="studentclasscall">Class</a>
    <a href="showstdassignments">Assignment</a>
    <a href="studentstudymaterialscall">Study Materials</a></div>   <!--end of subject navigation header -->
    <br>
    <!-- this the subject container where everything is present in here to work -->
    <div class="class-container" style="overflow-y: scroll;">  
    <h1>${subname} Class</h1>
    
    <!-- this div is for showing the today's classes  -->
    <div class="outline-todays-class"  style="overflow-y: scroll;">
    <h2>Today's Classes</h2>
    <c:forEach items="${stdmeetdetails}" var="meet">
  	<c:set var="date" value=" ${meet.dandt}" scope="session"></c:set>
  	<%
  	String date = session.getAttribute("date").toString();
  	String meetdate = date.substring(1, 11);
  	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now(); 
	String dandt = dtf.format(now);
	String datenow = dandt.substring(0,10);
	if(meetdate.equals(datenow))
	{	
  	%>
    <div class="todays-classes" >   
    	<p>Meeting Link :</p>
    	<p>Topic:${meet.topic}</p>
    	<p>Date And Time:${meet.dandt}</p>
    	<a href="${meet.link}" target="_blank"> <input type="button" value="Start Now"></a> 
    </div><% } %>
    </c:forEach>
    </div>
    <!-- end of today's classes -->
    
    <c:forEach items="${stdmeetdetails}" var="meet" >
    <div class="meet-container">
    	<p>Meeting Link :</p>
    	<p>Topic:${meet.topic}</p>
    	<p>Date And Time:${meet.dandt}</p>
    	<a href="${meet.link}" target="_blank"> <input type="button" value="Start Now"></a>
    </div></c:forEach>
    
    </div>

<!-- end of the student classroom -->
</body>
</html>