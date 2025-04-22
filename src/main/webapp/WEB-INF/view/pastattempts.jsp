<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.QuizApplication.QuizApplication.Model.Result, com.QuizApplication.QuizApplication.Model.User" %>

<html>
<head>
    <title>Past Attempts</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script type="text/javascript">
    window.history.forward()
    </script>
</head>
<body>

<h1>📚 Your Past Quiz Attempts</h1>

<%
    List<Result> results = (List<Result>) request.getAttribute("results");
    User user = (User) session.getAttribute("user");

    if (results == null || results.isEmpty()) {
%>
    <p style="text-align: center; font-size: 18px; color: #555;">You have not participated in any quiz yet.</p>
<%
    } else {
%>

<table>
    <tr>
        <th>Quiz Title</th>
        <th>Score</th>
        <th>No. of Attempts</th>
        <th>Last Attempted</th>
    </tr>
<%
        for (Result r : results) {
%>
    <tr>
        <td><%= r.getQuizTitle() %></td>
        <td><%= r.getScore() %></td>
        <td><%= r.getNoOfAttempts() %></td>
        <td><%= r.getAttemptedDateTime() %></td>
    </tr>
<%
        }
%>
</table>

<%
    }
%>

<div class="result-container">
    <form action="backtouserdashboard" method="post">
        <button type="submit" class="btn">Back to Dashboard</button>
    </form>
</div>

</body>
</html>
