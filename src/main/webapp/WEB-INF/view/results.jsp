<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.QuizApplication.QuizApplication.Model.Question,com.QuizApplication.QuizApplication.Model.User" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/result.css">
    <script type="text/javascript">
    window.history.forward()
    </script>
</head>
<body>
<%
    Integer score = (Integer) session.getAttribute("score");
    List<Question> questions = (List<Question>) session.getAttribute("questions");
    int total = questions != null ? questions.size() : 0;
    User u=(User) session.getAttribute("user");
%>
<div class="result-container">
    <h1>🎉 Quiz Completed Successfully! <%= u.getUsername() %></h1>
    <p class="score">Your Score: <strong><%= score %> / <%= total %></strong></p>
    <div class="result-container">
    <form action="backtouserdashboard" method="post">
        <button type="submit" class="btn">Back to Dashboard</button>
    </form>
</div>
</div>
</body>
</html>
