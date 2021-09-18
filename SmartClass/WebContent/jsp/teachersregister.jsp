<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="ISO-8859-1">
    <title>Teacher Register</title>
    <link rel="stylesheet" href="../css/studentregister.css">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Krona+One&display=swap" rel="stylesheet">
</head>
<body>

    <header class="header" >
        <div class="left-header"><img src="../img/logo.png"></div>
       <div class="sub-header">
           

           <div class="inner_header"><h1>SMART<span>ClassRoom</span></h1> </div>
           
        <ul class="navigation">
            <a href="../html/index.html"><li>Home</li></a>
            <a href="../html/studentlogin.html"><li>StudentLogin</li></a>
            <a href="../html/teacherlogin.html"><li>TeacherLogin</li></a>
        </ul>
       </div>   
    </header>



    <div class="container">
        <form action="registerteacher" class="login-box" method = "post"><br>
            <img src="../img/teacher.png" >
            <h1>Teacher Register</h1><br>
            <p>Teacher NO: <span style="display:inline-block;width:71px;"></span><input type="text" name="Tid"></p><br>
            <p>Username: <span style="display:inline-block;width:86px;"></span><input type="text" name="usrname"></p><br>
            <p>Password: <span style="display:inline-block;width:96px;"></span><input type="password" name="pass" id="myInput"></p><br>
            <p>Confirm Password: <input type="password" name="cnfrmpass" id="myInput2"> </p> <br> <span>Show Password</span> <input type="checkbox" onclick="myFunction()" value="Show"><br> <br> <br>
            <input type="submit" value="Register" id="submit-register"> <br>
               <p style="color:red;"> You can only register yourself<br>if you Have a Valid Teacher ID<p>
        </form>
    </div>
    <!-- this is the js function to show the password -->
    <script>
  	function myFunction() {
    var x = document.getElementById("myInput");
    if (x.type === "password") {
      x.type = "text";
    } else {
      x.type = "password";
    }
    var y = document.getElementById("myInput2");
    if(y.type === "password")
    	{
    	y.type = "text";
    	}else { y.type = "password";}
  }
</script>
<!-- end of js -->




    
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