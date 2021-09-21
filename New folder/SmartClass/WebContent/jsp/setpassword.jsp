<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Change</title>
<link rel="stylesheet" href="../css/stylestdlogin.css">
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
            <a href="../jsp/home"><li>Home</li></a>
            <a href="../html/studentlogin.html"><li>StudentLogin</li></a>
            <a href="../html/teacherlogin.html"><li>TeacherLogin</li></a>
        </ul>
       </div>   
</header>
    
    
    <div class="type-otp-container">
        <form action="changepassword" class="login-box" method="post">
            <img src="../img/std.png" ><br><br>
            <h2>Student Password Change</h2><br>
            <p>Enter your new password</p><br><br>
            
            <input type="password" placeholder="Password" name="pass"><br>
            <input type="password" placeholder="confirm Password" name="pass2"><br>
         
            <input type="submit" value="Submit "><br><br>
            
            
        </form >                    	
    	</div>
</body>
</html>