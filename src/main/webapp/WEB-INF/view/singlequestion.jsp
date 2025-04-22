<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.QuizApplication.QuizApplication.Model.Question" %>
<%
    Question q = (Question) request.getAttribute("currentQuestion");
    int questionIndex = (Integer) request.getAttribute("index");
    String result = (String) request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Question</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/singlequestion.css">
</head>
<body>
    <div class="quiz-container">
        <div class="quiz-header">
            <h2>Question <%= questionIndex + 1 %></h2>
        </div>

        <% if (result == null) { %>
            <form id="questionForm" action="submitAnswer" method="post">
                <input type="hidden" name="questionId" value="<%= q.getId() %>"/>
                <input type="hidden" name="index" value="<%= questionIndex %>"/>

                <div class="question-box">
                    <h3><%= q.getContent() %></h3>
                    <div class="options">
                        <label><input type="radio" name="selectedOption" value="A" required> A. <%= q.getOptionA() %></label>
                        <label><input type="radio" name="selectedOption" value="B"> B. <%= q.getOptionB() %></label>
                        <label><input type="radio" name="selectedOption" value="C"> C. <%= q.getOptionC() %></label>
                        <label><input type="radio" name="selectedOption" value="D"> D. <%= q.getOptionD() %></label>
                    </div>
                </div>

                <div class="btn-section">
                    <input type="submit" value="Submit Answer" class="btn">
                </div>
            </form>
        <% } else { %>
            <div class="question-box">
                <h3><%= q.getContent() %></h3>
                <div class="options">
                    <label><input type="radio" disabled> A. <%= q.getOptionA() %></label>
                    <label><input type="radio" disabled> B. <%= q.getOptionB() %></label>
                    <label><input type="radio" disabled> C. <%= q.getOptionC() %></label>
                    <label><input type="radio" disabled> D. <%= q.getOptionD() %></label>
                </div>
            </div>

            <p class="feedback"><%= result %></p>

            <form action="nextQuestion" method="get">
                <input type="hidden" name="index" value="<%= questionIndex + 1 %>" />
                <div class="btn-section">
                    <input type="submit" value="Next Question" class="btn">
                </div>
            </form>
        <% } %>
    </div>
</body>
</html>
