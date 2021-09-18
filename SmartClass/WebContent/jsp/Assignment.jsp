<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/subject.css">
<link rel="stylesheet" type="text/css" href="../css/subjectmain.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@900&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
<style type="text/css">
.class-container-assi #addassignment{
	margin-top:6px;
	width: 160px;
	height: 50px;
	font-family: 'Anton', sans-serif;
	font-size:18px;
	border-radius: 6px;
	background: none;
	outline: none;
	border:2px solid black;
	align-self: center;
	color:blue;
}
.class-container-assi #addassignment:hover{
background-color: black;
color:white;
}
</style>
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
            <p style="color:pink; cursor: pointer;">Welcome ${teachername} </p>
            
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
    <div class="class-container-assi" >
    <h1>${subname} Assigments</h1>
    <input type="button" value="ADD Assignment" id="addassignment"> <!-- as soon it this button is clicked it goes to the pop page below -->
    
    <c:forEach items="${avaiassignments}" var="ass">
    <div class="assignment-container">
    <br>
    <p><b>Topic:</b>${ass.topic} </p>
    <p><b>Description:</b>${ass.desc}</p>
    <p><b>Due Date:</b>${ass.dandt}</p>
    
    <div class="view-assi">
    <form action="viewassignments">
    <input type="hidden" value="${ass.assid}" name="assid">
   
    <input type="submit" id="viewassi" value="View All"></form>
    </div>	
    </div></c:forEach>
    </div>
    
    
    
    <!-- add assigment container -->
    <div class="add-assignment-container">
    <div class="main-container-assigment">
    <div class="main-content-assigment">
	<div id="meetpopclose" class="close" > + </div>   
	<form action="addassignment" method="post">
	<h1>Add Assignment</h1> <br> <br>
    <p>Enter the Topic: <span style="display: inline-block;width: 50px;"></span> <input type="text" style="width: 210px;" name="topic"> </p> <br>
    <p>Description: <span style="display: inline-block;width: 70px;"></span> <input type="text" style="width: 210px;" name="desc"> </p> <br>
    <p>Set Due Time and Date: <span style="display: inline-block;width: 0px;"></span><input type="datetime-local" name="dandt"> </p> <br>
    <input type="submit" value="Add Assigment">
    </form>
    </div>
    </div>
    </div>
    <!-- end of add assignment container -->
    
    <!-- pop up confirm window to remove subject -->
	<div class="modal-bg" >

	<div class="modal-contents">
	<div id="subjectclose" class="close" > + </div> <!-- close button -->
	<div class="modal-main">
	<p>Are you Sure you want to delete subject ${s}</p><br> <br>
	<form action="removesubject" method="post" >
	<input type="hidden" value="${subid}" name="subid">
	<input type="submit" class="removesubject" value="Sure"> 
	<a href="#" id="notsure" class="cancel-subject">Cancel</a>
	
	</form>
	</div>
	</div>
 	</div>
 	<!-- end of pop up window -->
    
    
    <script type="text/javascript">
    document.getElementById('addassignment').addEventListener('click',function(){
 	   document.querySelector('.add-assignment-container').style.display='flex';
    }
 	 );
    document.getElementById('meetpopclose').addEventListener('click',function(){
  	   document.querySelector('.add-assignment-container').style.display='none';
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