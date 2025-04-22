Online Quiz Application
This is a full-stack Online Quiz Application built with Spring Boot, JSP, JDBC, and MySQL. Users
can register, log in, take quizzes, view scores and leaderboard, and track their quiz history. Admins
can manage quizzes and questions through a dedicated dashboard.
Tech Stack
Frontend:
- JSP (Java Server Pages)
- HTML
- CSS
Backend:
- Spring Boot
- JDBC
- MySQL
Project Structure
Online-Quiz-Application/
??? src/
? ??? main/
? ??? java/com.quizapp/
? ??? resources/
? ? ??? application.properties
? ??? webapp/WEB-INF/jsp/
? ??? register.jsp
? ??? login.jsp
? ??? user-dashboard.jsp
? ??? quiz.jsp
? ??? result.jsp
? ??? leaderboard.jsp
? ??? attempts.jsp
? ??? admindashboard.jsp
? ??? add-question.jsp
? ??? view-questions.jsp
? ??? edit-question.jsp
? ??? add-quiz.jsp
??? static/
? ??? styles.css
??? pom.xml
User Features
- Register and Login with username and password
- User Dashboard with available quizzes
- Start Quiz directly by clicking on a quiz
- Answer Questions one at a time
- Get Instant Feedback after each answer (Correct / Incorrect)
- Final Score Summary after finishing a quiz
- View Leaderboard for each quiz
- View Quiz History: number of attempts, past scores
- Logout
Admin Features
- Admin Login
- Create New Quizzes
- Add Questions to quizzes
- Edit Questions
- Delete Questions
- View All Questions per quiz
- Delete Quizzes
- Logout
Getting Started
1. Clone the Repository
 git clone https://github.com/boyramu/Online-Quiz-Application.git
 cd Online-Quiz-Application
2. Setup MySQL Database
 CREATE DATABASE quizdb;
 Update application.properties with your DB credentials
3. Run the Application
 ./mvnw spring-boot:run
 or run QuizApplication.java from IDE
Sample Accounts
User:
- Username: user1
- Password: userpass
Admin:
- Username: admin
- Password: adminpass
Screenshots (Optional)
- Login Page
- User Dashboard
- Quiz Page with Timer
- Result Page
- Leaderboard
- Admin Panel
Database Tables (Suggested)
- users
- quizzes
- questions
- attempts
- attempt_answers
Contributing
Pull requests are welcome.
License
This project is open-source under the MIT License.
