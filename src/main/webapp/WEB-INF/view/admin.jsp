<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Online Quiz App - Home</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">

    <script>
        function toggleForm(formId) {
            document.getElementById("loginForm").style.display = "none";
            document.getElementById(formId).style.display = "block";
        }
        window.history.forward()
    </script>
</head>
<body>

    <div class="header">
        <button onclick="toggleForm('loginForm')">Login</button>
    </div>
      <div class="main-heading">🎓 Quiz Application</div>
    <p class="sub-info">
        Welcome to the ultimate Online Quiz Platform! Test your knowledge, improve your skills, and challenge yourself with quizzes from various topics. 
        Whether you're a student or a professional, we’ve got quizzes to keep your brain sharp and engaged.
    </p>
    <div class="container">
        <div id="loginForm" class="form-box">
            <h3>Login</h3>
            <form action="adminlogin" method="post">
                <input type="text" name="username" placeholder="Username" required />
                <input type="password" name="password" placeholder="Password" required />
                <input type="submit" value="Login" />
            </form>
        </div>

    </div>

</body>
</html>
