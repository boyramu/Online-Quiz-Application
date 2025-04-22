<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List,com.QuizApplication.QuizApplication.Model.Question" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Questions</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/questions.css">
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
    List<Question> questions = (List<Question>) request.getAttribute("questions");
    Long quizId = Long.parseLong(request.getParameter("quizId"));
%>

<h2> <form action="backtodashboard" method="post" style="text-align: left; margin-bottom: 20px;">
        <button type="submit" class="back-btn">Go to Dashboard</button>
    </form> Questions( <%= questions.size() %> )</h2>
<ul>
<%
    int i = 1;
    for (Question q : questions) {
%>
    <li>
        <strong>Q<%= i++ %>: </strong> <%= q.getContent() %><br>
        A: <%= q.getOptionA() %><br>
        B: <%= q.getOptionB() %><br>
        C: <%= q.getOptionC() %><br>
        D: <%= q.getOptionD() %><br>
        <strong>Correct Answer:</strong> <%= q.getCorrectAnswer() %><br>

        <form action="editQuestionForm" method="get" style="display:inline;">
            <input type="hidden" name="questionId" value="<%= q.getId() %>" />
            <button type="submit">Edit</button>
        </form>
        <form action="deleteQuestion" method="post" style="display:inline;">
            <input type="hidden" name="questionId" value="<%= q.getId() %>" />
            <input type="hidden" name="quizId" value="<%= q.getQuizId() %>">
            <button type="submit">Delete</button>
        </form>
    </li>
<%
    }
%>
</ul>


</body>
</html>
