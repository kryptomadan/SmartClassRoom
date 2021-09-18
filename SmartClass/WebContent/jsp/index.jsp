<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="../css/style.css">
	
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Itim&display=swap" rel="stylesheet">
    <title>ClassRoom</title>

</head>
<body>
    <!-- this header tag is used for creating header of the application-->
    <header class="header" >
        <div class="left-header"><img src="../img/logo.png"></div>
       <div class="sub-header">
           

           <div class="inner_header"><h1>SMART<span>ClassRoom</span></h1> </div>
           
        <ul class="navigation">
            <a href="index.jsp"><li>Home</li></a>
            <a href="../html/studentlogin.html"><li>StudentLogin</li></a>
            <a href="../html/teacherlogin.html"><li>TeacherLogin</li></a>
        </ul>
       </div>   
    </header>
    <!-- end of header tag-->
    
    <!-- updates -->
    <div class="homepage-updates">
    <h3>Department Updates</h3> <br>
    <c:forEach items="${updates}" var="up">
    <a href="${up.path}" target="_blank"><p>${up.topic}</p></a> <br>
    </c:forEach>
    </div>   
    <!-- end of updates -->


    <!-- About part starts from here-->
    
    <img src="../img/class.jpg" class="about-img">
    <div class="about">
        <div class="h1tag"><h1 >About</h1>
            <p>Technology-enabled education is peeping deep into the classrooms, paving a way to smart-education. The concept of smart classrooms has arrived at the forefront with the integration of advanced hardware and innovative software technology to enhance the way of teaching and to keep a check on students learning.

                Moreover, smart or digital classrooms foster creativity and an interactive environment would help in bringing in more innovative ideas, more queries, and more solutions. Consequently, there is a broadening of the domain of knowledge that a person acquires and encouragement in informal learning through this versatile VC solution. If you want to know more about different VC solutions, then don’t skip Video Conferencing Solutions: The Definitive Guide. You will discover many VC solutions ingredients there. Meanwhile, let us focus on what smart/ digital classroom solutions bring for the new generation.
                
                What is Smart Classroom?
                A smart classroom is a technology-enhanced learning classroom that enhances the way of teaching and learning digitally. The classroom is integrated with the digital displays, tabs, whiteboards, assistive listening devices, and other audio/visual components that make lectures easier, engaging, and more interactive.</p>
        
        </div>
        
    </div>
    
  
    <!-- about part ends here-->
  <footer id="footer-container">
        <div id="footer-img">
            <img src="../img/logo.png">
        </div>
        <div id="footer-queries">
            <p><span id="contact-span">For Any Queries Contact </span><br><br> 8073461256 <br> smartclass@klesnc.org</p>      
        </div>
    </footer>
    <!-- Footer part starts from here-->
    

</body>
</html>