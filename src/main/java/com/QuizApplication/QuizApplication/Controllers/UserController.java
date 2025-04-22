package com.QuizApplication.QuizApplication.Controllers;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.QuizApplication.QuizApplication.Model.Question;
import com.QuizApplication.QuizApplication.Model.Quiz;
import com.QuizApplication.QuizApplication.Model.Result;
import com.QuizApplication.QuizApplication.Model.User;
import com.QuizApplication.QuizApplication.Security.PasswordUtil;
import com.QuizApplication.QuizApplication.Service.QuestionService;
import com.QuizApplication.QuizApplication.Service.QuizService;
import com.QuizApplication.QuizApplication.Service.ResultService;
import com.QuizApplication.QuizApplication.Service.UserService;

import jakarta.servlet.http.HttpSession;
@Controller
public class UserController {
	@Autowired
	private UserService us;
	@Autowired
	private QuizService quizService;
	@Autowired
	private QuestionService QuestionService;
	@Autowired
	private ResultService rs;
	@RequestMapping("/")
	public String HomePage()
	{
		return "index";
	}
	@RequestMapping("/register")
	public ModelAndView UserRegister(@RequestParam("username") String username,
	                                 @RequestParam("email") String email,
	                                 @RequestParam("password") String password) {
	    ModelAndView mv = new ModelAndView();

	    // Hash the plain password before storing
	    String hashedPassword = PasswordUtil.hashPassword(password);
	    User u = new User(username, hashedPassword, email);

	    if (us.createUser(u)) {
	        mv.addObject("res", "Account Created Successfully, now login");
	    } else {
	        mv.addObject("res", "Failed to create an account! Try again");
	    }

	    mv.setViewName("index");
	    return mv;
	}

	@RequestMapping("/login")
	public ModelAndView Userlogin(@RequestParam("username") String username,
	                              @RequestParam("password") String password,
	                              HttpSession session) {
	    ModelAndView mv = new ModelAndView();
	    User userFromDb = us.UserLogin(username); // Fetch by username

	    if (userFromDb != null && PasswordUtil.verifyPassword(password, userFromDb.getPassword())) {
	        // Correct password
	        session.setAttribute("user", userFromDb);
	        mv.addObject("quizes", quizService.getQuizes());
	        mv.setViewName("userdashboard");
	    } else {
	        mv.addObject("res", "Wrong credentials. Try again.");
	        mv.setViewName("index");
	    }

	    return mv;
	}

	@RequestMapping("/startQuiz")
	public ModelAndView startQuiz(@RequestParam("quizId") Long quizId, HttpSession session) {
		ModelAndView mv=new ModelAndView();
		Quiz q=quizService.getQuizByid(quizId);
		session.setAttribute("quiz", q);
	    List<Question> questions = QuestionService.getRandomQuestion(quizId);
	    session.setAttribute("questions", questions);
	    session.setAttribute("score", 0);
	    long startTime = System.currentTimeMillis();
	    session.setAttribute("startTime", startTime);
	    mv.addObject("startTime", startTime);
	    mv.addObject("index",0);
	    mv.addObject("currentQuestion",questions.get(0));
	    mv.setViewName("singlequestion");
	    return mv;
	}

	@RequestMapping("/submitAnswer")
	public ModelAndView submitAnswer(
	    @RequestParam("questionId") Long questionId,
	    @RequestParam("selectedOption") String selectedOption,
	    @RequestParam("index") int index,
	    HttpSession session
	) {
	    ModelAndView mv = new ModelAndView();
	    List<Question> questions = (List<Question>) session.getAttribute("questions");

	    if (questions == null || index >= questions.size()) {
	        mv.setViewName("redirect:/endQuiz");
	        return mv;
	    }

	    Question currentQuestion = questions.get(index);
	    if (currentQuestion.getCorrectAnswer().equals(selectedOption)) {
	        int score = (int) session.getAttribute("score");
	        session.setAttribute("score", score + 1);
	        mv.addObject("result", "✅ "+selectedOption+" is Correct Answer!");
	    } else {
	        mv.addObject("result", "❌ Wrong! Correct Answer: " + currentQuestion.getCorrectAnswer());
	    }
	    if (index >= questions.size()) {
	        mv.setViewName("redirect:/endQuiz");
	    } else {
	        mv.addObject("currentQuestion", questions.get(index));
	        mv.addObject("index", index);
	        mv.setViewName("singlequestion");
	    }
	    long startTime = (Long) session.getAttribute("startTime");
	    mv.addObject("startTime", startTime);
	    return mv;
	}

	@RequestMapping("/nextQuestion")
	public ModelAndView nextQuestion(@RequestParam("index") int index, HttpSession session) {
	    ModelAndView mv = new ModelAndView();
	    List<Question> questions = (List<Question>) session.getAttribute("questions");

	    if (questions == null || index >= questions.size()) {
	        mv.setViewName("redirect:/endQuiz");
	        return mv;
	    }
	    long startTime = (Long) session.getAttribute("startTime");
	    mv.addObject("startTime", startTime);
	    mv.addObject("currentQuestion", questions.get(index));
	    mv.addObject("index", index);
	    mv.setViewName("singlequestion");
	    return mv;
	}
    @RequestMapping("/endQuiz")
    public ModelAndView endQuiz(HttpSession session)
    {
    	ModelAndView mv=new ModelAndView();
    	mv.addObject("score",session.getAttribute("score"));
    	User u=(User) session.getAttribute("user");
    	Quiz q=(Quiz) session.getAttribute("quiz");
        Result r=rs.getResultsByUserIdAndQuizId(u.getId(), q.getId());
        if(r!=null)
        {
        	r.setNoOfAttempts(r.getNoOfAttempts()+1);
        	r.setScore((int)session.getAttribute("score"));
        	rs.UpdateResult(r);
        }
        else
        {
        	LocalDateTime now=LocalDateTime.now();
        	Result result=new Result(u.getId(),u.getUsername(),q.getId(),q.getTitle(),(int) session.getAttribute("score"),
        			1,now);
        	rs.saveResult(result);
        }
    	mv.setViewName("results");
    	return mv;
    }
    @RequestMapping("/quizLeader")
    public ModelAndView quizLeaderboard(@RequestParam("quizId") Long quizId)
    {
    	ModelAndView mv=new ModelAndView();
    	List<Result> results=rs.getResultByQuizid(quizId);
    	mv.addObject("results",results);
    	mv.setViewName("leaderboard");
    	return mv;
    }
    @RequestMapping("/pastAttempts")
    public ModelAndView userPastAttempts(@RequestParam("userid") Long userid)
    {
    	ModelAndView mv=new ModelAndView();
    	List<Result> results=rs.getResultsByUserId(userid);
        mv.addObject("results", results);
        mv.setViewName("pastattempts");
    	return mv;
    }
    @RequestMapping("/backtouserdashboard")
    public ModelAndView backtodashboard(HttpSession session)
    {
    	ModelAndView mv=new ModelAndView();
	    mv.addObject("quizes", quizService.getQuizes());
	    mv.setViewName("userdashboard");
	    return mv;
    }
	@RequestMapping("/userlogout")
	public String userLogout(HttpSession session)
	{
	    session.invalidate();
		return "redirect:http://localhost:8080/";
	}

}
