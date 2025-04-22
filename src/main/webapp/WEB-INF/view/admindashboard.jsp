<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.QuizApplication.QuizApplication.Model.Quiz,com.QuizApplication.QuizApplication.Model.Question"%>
<!DOCTYPE html>
<html>
<head>
    <title>Online Quiz App - Admin Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admindashboard.css">
    

    <script>
        function toggleForm(formId) {
            document.getElementById("QuizForm").style.display = "none";
            document.getElementById(formId).style.display = "block";
        }
        window.history.forward();
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
%>

<div class="header">
    <div class="header-buttons">
        <button onclick="toggleForm('QuizForm')">Create Quiz</button>
        <form action="adminlogout" style="margin: 0;">
            <button type="submit">Logout</button>
        </form>
    </div>
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
            <form action="showquestionform">
            <input type="hidden" name="quizId" value="<%= q.getId() %>">
            <button type="submit">Add Questions</button>
            </form>
    <form action="viewquestions" method="get" style="display:inline;">
        <input type="hidden" name="quizId" value="<%= q.getId() %>" />
        <button type="submit">Edit</button>
    </form>
    <form action="deleteQuiz">
              <input type="hidden" name="quizid" value="<%= q.getId() %>">
              <button type="submit">Delete</button>
            </form>
        </div>
        <%
            }
        }
        %>
    </div>
<div class="container">

    <!-- Create Quiz Form -->
    <div id="QuizForm" class="form-box">
        <h3>Create Quiz</h3>
        <form action="createQuiz" method="post">
            <input type="text" name="title" placeholder="Quiz Title" required />
            <textarea name="description" placeholder="Quiz Description" rows="4" required></textarea>
            <input type="submit" value="Create Quiz" />
        </form>
    </div>

    </div>
</body>
</html>
