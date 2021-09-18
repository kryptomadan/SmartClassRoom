<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Study Materials</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/subjectmain.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@900&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
<style type="text/css">
.class-container #addmaterials:hover
,.class-container-video #addvideomaterials:hover
{
background-color: rgb(191, 236, 84);
color:black;
}
.class-container #videomt,
.class-container-video #documentbtn
{
	width: 200px;
	height: 50px;
	font-family: 'Anton', sans-serif;
	font-size:18px;
	border-radius: 6px;
	background: none;
	outline: none;
	border:2px solid black;
	align-self: flex-end;
	margin-right:73px;
	
	color:black;
}
.class-container #videomt:hover,
.class-container-video #documentbtn:hover
{
background-color: skyblue;

}
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
            <p style="color:aqua; cursor: pointer;">Welcome ${stdname} </p>
            
        </ul>
       </div>   
    </header>
    
    <!-- This is the subject navigation header  -->
    <div class="subject-navigation">
    <a href="studentclasscall">Class</a>
    <a href="showstdassignments">Assignment</a>
    <a href="studentstudymaterialscall">Study Materials</a></div>   <!--end of subject navigation header -->
    <br>
<!-- this container is to display the Document Materials -->
	<div class="class-container" >
    <h1>${subname} Document Materials</h1>
    
    <input type="button" value="Go to video materials" id="videomt"> <br> <br> <br> <br>
    <c:forEach items="${documentmaterials}" var="doc">
    <div class="materials-container">
    <br>
    <p><b>Topic:</b>${doc.topic} <b>${doc.dandt}</b> </p>   
     <a href="${doc.path}" id="viewassi" target="_blank" >View Document</a>
   
    
    </div></c:forEach>
    
    </div>

<!-- end of the container of the Document materials -->
	
	
<!-- container of video Materials -->
	<div class="class-container-video" >
    <h1>${subname} Video Materials</h1>
    <input type="button" value="Go to Document materials" id="documentbtn">   
    <div class="video-materials-content">   
    
    <c:forEach items="${videomaterials}" var="video">
    <div class="video-material">
    <div class="topic-video"><h2>Topic:${video.topic}</h2><span style="display: inline-block;width: 20px;"></span> <h3>${video.dandt}</h3></div>
    <video   controls="controls">
    <source src="${video.path}" >
    </video>
    </div>
    </c:forEach>
    </div> 
    </div>
<!-- end of the container of the video materials -->
    
    <script type="text/javascript">
    document.getElementById('videomt').addEventListener('click',function(){
 	   document.querySelector('.class-container').style.display='none';
 	   document.querySelector('.class-container-video').style.display='flex';
 }
 	 );
  
  document.getElementById('documentbtn').addEventListener('click',function(){
 	   document.querySelector('.class-container').style.display='flex';
 	   document.querySelector('.class-container-video').style.display='none';
 }
 	 );

    </script>
</body>
</html>