<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.QuizApplication.QuizApplication.Model.Question" %>
<%
    Question question = (Question) request.getAttribute("question");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Question</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/questions.css">
    <script type="text/javascript">
    window.history.forward()
    </script>
</head>
<body>
    <h2>Edit Question</h2>
    <form action="updateQuestion" method="post">
        <input type="hidden" name="id" value="<%= question.getId() %>" />
        <input type="hidden" name="quizId" value="<%= question.getQuizId() %>" />
        <input type="text" name="content" value="<%= question.getContent() %>" required />
        <input type="text" name="optionA" value="<%= question.getOptionA() %>" required />
        <input type="text" name="optionB" value="<%= question.getOptionB() %>" required />
        <input type="text" name="optionC" value="<%= question.getOptionC() %>" required />
        <input type="text" name="optionD" value="<%= question.getOptionD() %>" required />
        <select name="correctAnswer" required>
            <option value="A" <%= question.getCorrectAnswer().equals("A") ? "selected" : "" %>>A</option>
            <option value="B" <%= question.getCorrectAnswer().equals("B") ? "selected" : "" %>>B</option>
            <option value="C" <%= question.getCorrectAnswer().equals("C") ? "selected" : "" %>>C</option>
            <option value="D" <%= question.getCorrectAnswer().equals("D") ? "selected" : "" %>>D</option>
        </select>
        <button type="submit">Update</button>
    </form>
</body>
</html>
