<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.QuizApplication.QuizApplication.Model.Quiz,com.QuizApplication.QuizApplication.Model.Question
,com.QuizApplication.QuizApplication.Model.User"%>
<!DOCTYPE html>
<html>
<head>
    <title>Online Quiz App - Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admindashboard.css">
    <script type="text/javascript">
    window.history.forward()
    </script>
</head>
<body>
<% if (request.getAttribute("res") != null) { %>
        <p class="success-message">
            <%= request.getAttribute("res") %>
        </p>
    <% } %>
    

<%
    List<Quiz> quiz = (List<Quiz>) request.getAttribute("quizes");
    User u=(User) session.getAttribute("user");
%>
<div class="header">
     <form action="pastAttempts">
     <input type="hidden" name="userid" value="<%= u.getId()%>">
     <button type="submit">Past Attempts</button>
     </form>
     <form action="userlogout">
        <button type="submit">Logout</button>
    </form>
</div>
<div class="welcome">
<p>Welcome <%= u.getUsername() %></p>
<h1>Online Quiz </h1>
</div>
 <!-- Quiz List Grid -->
    <div class="quiz-grid">
        <%
        if (quiz != null) {
            for (Quiz q : quiz) {
        %>
        <div class="quiz-card">
            <h3><%= q.getTitle() %> Quiz</h3>
            <p><%= q.getDescription() %></p>
            <form action="startQuiz">
            <input type="hidden" name="quizId" value="<%= q.getId() %>">
            <input type="hidden" name="index" value="0">
            <button type="submit">Start</button>
            </form>
            <form action="quizLeader">
            <input type="hidden" name="quizId" value="<%= q.getId() %>">
            <button type="submit">Leaderboard</button>
            </form>
        </div>
        <%
            }
        }
        %>
    </div>
</body>
</html>
