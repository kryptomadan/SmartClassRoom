<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="DAO.studentdao" %> 
<%@ page import="DAO.subjectmodel" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment</title>
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
    
 <!-- This is the subject navigation header  -->
    <div class="subject-navigation">
    <a href="studentclasscall">Class</a>
    <a href="showstdassignments">Assignment</a>
    <a href="studentstudymaterialscall">Study Materials</a></div>   <!--end of subject navigation header -->
    <br>
    <!-- this the subject container where everything is present in here to work -->
    <div class="class-container">
    <h1>${subname} Assigments</h1> 
     <c:forEach items="${stdassignshow}" var="ass">
    <div class="assignment-container">
    <br>
    <p><b>Topic:</b>${ass.topic} </p>
    <p><b>Description:</b>${ass.desc}</p>
    <p><b>Due Date:</b>${ass.dandt}</p>
    
    <!-- this if condition is used to show the view button after uploading the file -->
    <!-- and java code to call the method to check whether the file is available or not -->
    <c:set var="ID" value="${ass.assid}" scope="session"></c:set>
  	 <% studentdao obj = new studentdao();
  	 subjectmodel obj2 = new subjectmodel();
  	 String assid = session.getAttribute("ID").toString();
  	 String rollno = session.getAttribute("rollno").toString();
  	 if(obj.checkasii(assid,rollno))
  	 {	 
  		 obj.showstdassi(assid,rollno);
  		 session.setAttribute("showstdassi", obj.assipath);
  	 %>
  	 <a  href="${showstdassi}" target="_blank"  >CLICK TO VIEW</a>
  	 <%if (obj2.checkdonelate(assid))
  	 {
  		 %>
  	 <p><b>Done late</b></p> <%} %>
  	 
  	 <% } else{ %>
  	 
    <form action="upload" enctype="multipart/form-data" method="post" id="form1">   
    <input type="file" multiple id="filetype" name="file" accept=".pdf">
    <input type="submit" id="submit-button"  >	
    <c:set var="assid" value="${ass.assid}"  scope="session"  />
    </form> <% } %>
    
    </div></c:forEach>
    </div>
        
  	
</body>
</html>