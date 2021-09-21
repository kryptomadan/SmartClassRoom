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
<link rel="stylesheet" type="text/css" href="../css/subject.css">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Amatic+SC:wght@900&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">
<style type="text/css">
.class-container #addmaterials,
.class-container #addmaterialslink,
.class-container-video #addvideomaterials
{
	margin-top:6px;
	width: 230px;
	height: 50px;
	font-family: 'Anton', sans-serif;
	font-size:18px;
	border-radius: 6px;
	
	background: none;
	outline: none;
	border:2px solid black;
	align-self: center;
	color:black;
}
.class-container #addmaterials:hover,
.class-container #addmaterialslink:hover, 
.class-container-video #addvideomaterials:hover
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
	margin-top:-52px;
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
<!-- this container is to display the Document Materials -->
	<div class="class-container" >
    <h1>${subname} Document Materials</h1>
    <input type="button" value="ADD Document Materials" id="addmaterials">
    <input type="button" value="ADD Link for Materials" id="addmaterialslink"> <!-- as soon it this button is clicked it goes to the pop page below -->
    <br> <br>
    <input type="button" value="Go to video materials" id="videomt">
    <c:forEach items="${documentmaterials}" var="doc">
    <div class="materials-container">
    <br>
    <p><b>Topic:</b>${doc.topic} <b>${doc.dandt}</b></p>   
     <a href="${doc.path}" id="viewassi" target="_blank" >View Document</a>
   
    
    </div></c:forEach>
    
    </div>

<!-- end of the container of the Document materials -->
	
	
<!-- container of video Materials -->
	<div class="class-container-video">
    <h1>${subname} Video Materials</h1>
    <input type="button" value="ADD Video Materials" id="addvideomaterials"> <!-- as soon it this button is clicked it goes to the pop page below -->
    <input type="button" value="Go to Document materials" id="documentbtn">   
    <div class="video-materials-content">    
    <c:forEach items="${videomaterials}" var="video">
    <div class="video-material">
    <div class="topic-video"><h2>Topic: ${video.topic}</h2> <span style="display: inline-block;width: 20px;"></span> <h3>${video.dandt}</h3> </div>
    <video   controls="controls">
    <source src="${video.path}" >
    </video>
    </div>
    </c:forEach>
    </div> 
    </div>
<!-- end of the container of the video materials -->



<!-- start of adding link for materials container -->
	<div class="add-materials-container-link">
    <div class="main-container-materials">
    <div class="main-content-materials">
	<div id="popclose-link" class="close" > + </div>   <br><br>
	<form action="addmaterialslink" method="post" >
	<h1>Add Link for Materials</h1> <br> <br>
    <p><span style="display: inline-block;width: 30px;"></span>Enter the Topic: <span style="display: inline-block;width: 50px;"></span> <input type="text" style="width: 210px;" name="topic" > </p> <br>
    <p><span style="display: inline-block;width: 30px;"></span>URL: <span style="display: inline-block;width: 130px;"></span> <input type="url" style="width: 210px;" name="link" > </p> <br>    
    
    <input type="submit" value="Add Link">
    </form>
    </div>
    </div>
    </div>

<!-- end of adding link for materials container -->

<!-- start of adding document materials container -->
	<div class="add-materials-container">
    <div class="main-container-materials">
    <div class="main-content-materials">
	<div id="popclose" class="close" > + </div>   <br><br>
	<form action="addmaterials" method="post" enctype="multipart/form-data">
	<h1>Add Document Materials</h1> <br> <br>
    <p><span style="display: inline-block;width: 30px;"></span>Enter the Topic: <span style="display: inline-block;width: 50px;"></span> <input type="text" style="width: 210px;" name="topic" > </p> <br>  
    <input type="file" multiple name="file" >
    <input type="submit" value="Add Document">
    </form>
    </div>
    </div>
    </div>

<!-- end of adding document materials container -->
<!-- start of the video materials container -->
	<div class="add-materials-container-video">
    <div class="main-container-materials-video">
    <div class="main-content-materials-video">
	<div id="popclose-video" class="close" > + </div>   <br><br>
	<form action="addmaterialsvideo" method="post" enctype="multipart/form-data">
	<h1>Add Video Materials</h1> <br> <br>
    <p><span style="display: inline-block;width: 30px;"></span>Enter the Topic: <span style="display: inline-block;width: 50px;"></span> <input type="text" style="width: 210px;" name="topic" > </p> <br>
    
    <input type="file" multiple name="file" accept="video/*">
    <input type="submit" value="Add Video">
    </form>
    </div>
    </div>
    </div>
<!-- end of the video materials container -->

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
    

<script type="text/javascript">
document.getElementById('addmaterials').addEventListener('click',function(){
	   document.querySelector('.add-materials-container').style.display='flex';
 }
	 );
	 
document.getElementById('addmaterialslink').addEventListener('click',function(){
	   document.querySelector('.add-materials-container-link').style.display='flex';
}
	 );	 
 document.getElementById('popclose').addEventListener('click',function(){
	   document.querySelector('.add-materials-container').style.display='none';
  }
	 );  
 document.getElementById('popclose-link').addEventListener('click',function(){
	   document.querySelector('.add-materials-container-link').style.display='none';
}
	 ); 
 
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
 
 document.getElementById('addvideomaterials').addEventListener('click',function(){
	   document.querySelector('.add-materials-container-video').style.display='flex';
}
	 ); 
 
 document.getElementById('popclose-video').addEventListener('click',function(){
	   document.querySelector('.add-materials-container-video').style.display='none';
}
	 );  
 
 // this is to remove subject scripting
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