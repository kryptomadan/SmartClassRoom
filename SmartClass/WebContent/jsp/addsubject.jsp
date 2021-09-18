<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subject</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="stylesheet" type="text/css" href="../css/subject.css">
 <style> .navigation a:hover{color:aqua;} </style>   
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Krona+One&display=swap" rel="stylesheet">

</head>
</head>
<body style="display: flex;
    flex-flow:column;
	
	align-items: center;
	background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
	background-size: 150% 200%;
	
	

}
	">
	
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
            
            <a href="logout"><li>Logout</li></a>
            <p style="color:pink;">Welcome ${TID} </p>
            
        </ul>
       </div>   
    </header>
   
   <div class="addsubject-container"> <br> <br> 
  		 <img src="../img/addsub.jpg" > <br>
   		 <h1 style="color:white;">Add Subject</h1><br>
   		 <form action="addsubject" method="post">
   		 <p>Subject Name: <span style="display:inline-block;width:50px;"></span><input type="text" name="subname"></p><br>
         <p>Class: <span style="display:inline-block;width:150px;"></span>
         <select name="class" id="class">
  			<option value="1st">1st Sem</option>
  			<option value="2nd">2nd Sem</option>
  			<option value="3rd">3rd Sem</option>
 			<option value="4th">4rt Sem</option>
 			<option value="5th">5th Sem</option>
 			<option value="6th">6th Sem</option>
			</select>    
            </p>
            <br>
            <p>Section: <span style="display:inline-block;width:125px;"></span>
            <select name="section" id="section">
  			<option value="A">A section</option>
  			<option value="B">B section</option>
  			<option value="C">C section</option> 			
			</select> 
            </p><br> <br> <br>
            <input type="submit" value="ADD" id="addbtn">
   			</form>
   </div>
   
   
</body>
</html>