<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Question</title>
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
    

    <!-- Go to Dashboard Button (Separate Form) -->
    <form action="backtodashboard" method="post" style="text-align: left; margin-bottom: 20px;">
        <button type="submit" class="back-btn">Go to Dashboard</button>
    </form>

    <!-- Add Question Form -->
    <form action="addQuestion" method="post">
    <h2>Add New Question</h2>
        <input type="hidden" name="quizId" value="${param.quizId}" />

        <input type="text" name="content" placeholder="Question Content" required />
        <input type="text" name="optionA" placeholder="Option A" required />
        <input type="text" name="optionB" placeholder="Option B" required />
        <input type="text" name="optionC" placeholder="Option C" required />
        <input type="text" name="optionD" placeholder="Option D" required />

        <select name="correctAnswer" required>
            <option value="">Select Correct Answer</option>
            <option value="A">A</option>
            <option value="B">B</option>
            <option value="C">C</option>
            <option value="D">D</option>
        </select>

        <button type="submit" class="submit-btn">Add Question</button>
    </form>
</body>
</html>
