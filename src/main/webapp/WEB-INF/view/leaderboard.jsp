<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.QuizApplication.QuizApplication.Model.Result, com.QuizApplication.QuizApplication.Model.User" %>

<html>
<head>
    <title>Quiz Leaderboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <script type="text/javascript">
    window.history.forward()
    </script>
</head>
<body>

<h1>🏆 Quiz Leaderboard</h1>

<%
    List<Result> results = (List<Result>) request.getAttribute("results");
    User user = (User) session.getAttribute("user");

    if (results == null || results.isEmpty()) {
%>
    <p class="message">No one has participated in this quiz till now.</p>
<%
    } else {
        int rank = 1;
%>
    <table>
        <tr>
            <th>Rank</th>
            <th>Username</th>
            <th>Quiz Title</th>
            <th>Score</th>
        </tr>
<%
        for (Result r : results) {
%>
        <tr>
            <td><%= rank++ %></td>
            <td><%= r.getUsername() %></td>
            <td><%= r.getQuizTitle() %></td>
            <td><%= r.getScore() %></td>
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
