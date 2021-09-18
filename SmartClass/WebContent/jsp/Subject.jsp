
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>      
<%@ page import="java.util.*" %> 
<%@ page import="java.time.*" %>
<%@ page import="java.time.format.*" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/subjectmain.css">
<link rel="stylesheet" type="text/css" href="../css/subject.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@900&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
<title>Subject</title>
</head>
<body>
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
            <a href="logout"><li>Logout</li></a>
            <p style="color:pink; cursor: pointer;">Welcome ${teachername}</p>
            
        </ul>
       </div>   
    </header>
    
   <div class="subject-remove">
    <button id="removesub">Remove subject</button>  
    </div>
    
   <!-- This is the subject navigation header  -->
    <div class="subject-navigation">
    <a href="Class">Class</a>
    <a href="assign">Assignment</a>
    <a href="studymaterialscall">Study Materials</a></div>   <!--end of subject navigation header -->
    <br>
    
    
    
    <!-- this the subject container where everything is present in here to work -->
    
    <div class="class-container" >
    <h1>${subname} Class</h1>
    <input type="button" value="Schedule Class" id="addmeet"> <!-- as soon it this button is clicked it goes to the pop page below -->   
    
    <!-- this div is for showing the today's classes  -->
 	<div class="outline-todays-class"  style="overflow-y: scroll;">
    <h2>Today's Classes</h2>
    <c:forEach items="${meetlinks}" var="meet">
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
    
    
    <br> <br> <br> <br>
    <c:forEach items="${meetlinks}" var="meet"> 
    <div class="meet-container">
    	<p>Meeting Link :</p>
    	<p>Topic:${meet.topic}</p>
    	<p>Date And Time:${meet.dandt}</p>
    	<a href="${meet.link}" target="_blank"> <input type="button" value="Start Now"></a>
    </div></c:forEach>
    </div>
   
    
    
    <!-- div for adding meeting link popup -->
    <div class="meetlink-bg">
    <div class="meetlink-container">
    <div class="meet-maincontent">
    <div id="meetpopclose" class="close" > + </div>
    <h1>Schedule Class</h1> <br>
    <form action="classmeet" method="post">
    <input type="hidden" value="${showsubject}" name="meetsubid">
    <p>Enter the Topic: <span style="display: inline-block;width: 60px;"></span> <input type="text" style="width: 210px;" name="topic"> </p> <br>
    <p>Meet Link: <span style="display: inline-block;width: 97px;"></span> <input type="url" style="width: 210px;" name="link"> </p> <br>
    <p>Schedule Time and Date: <span style="display: inline-block;width: 0px;"></span><input type="datetime-local" name="dandt"> </p> <br>
    <input type="submit" value="Schedule">
    </form>
    </div>  
    </div>
    </div>
    <!-- end of the meetlink popup -->
    
    <!-- pop up confirm window to remove subject -->
   			<div class="modal-bg" >
   
   			<div class="modal-contents">
   			<div id="subjectclose" class="close" > + </div> <!-- close button -->
   			<div class="modal-main">
   			<p>Are you Sure you want to delete subject ${s}</p><br> <br>
   			<form action="removesubject"  method="post">
   			<input type="hidden" value="${subid}" name="subid">
   			<input type="submit" class="removesubject" value="Sure"> 
   			<a href="#" id="notsure" class="cancel-subject">Cancel</a>
   			
   			</form>
   			</div>
   			</div>
  			 </div>
 	<!-- end of pop up window -->
    
    
    <!-- javascript code for opening the pop up for adding the meetlink  -->
    <script type="text/javascript">
    document.getElementById('addmeet').addEventListener('click',function(){
 	   document.querySelector('.meetlink-bg').style.display='flex';
    }
 	 );
    document.getElementById('meetpopclose').addEventListener('click',function(){
  	   document.querySelector('.meetlink-bg').style.display='none';
     }
  	 );
    
    // this is remove subject scripting to open window
    document.getElementById('removesub').addEventListener('click',function(){
   	   document.querySelector('.modal-bg').style.display='flex';
      }
   	 );
    document.getElementById('subjectclose').addEventListener('click',function(){
    	   document.querySelector('.modal-bg').style.display='none';
       }
    	 );
    document.getElementById('notsure').addEventListener('click',function(){
 	   document.querySelector('.modal-bg').style.display='none';
    }
 	 );
    // end of remove subject scripting
    </script>
    
   
    
</body>
</html>