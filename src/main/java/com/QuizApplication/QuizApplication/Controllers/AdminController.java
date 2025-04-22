package com.QuizApplication.QuizApplication.Controllers;

import java.net.http.HttpClient.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.QuizApplication.QuizApplication.Model.Question;
import com.QuizApplication.QuizApplication.Model.Quiz;
import com.QuizApplication.QuizApplication.Service.QuestionService;
import com.QuizApplication.QuizApplication.Service.QuizService;

@Controller
public class AdminController {
	@Autowired
	private QuizService quizService;
	@Autowired
	private QuestionService questionService;
	@RequestMapping("/admin")
	public String admin()
	{
		return "admin";
	}
	@RequestMapping("/adminlogin")
	public ModelAndView adminlogin(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		ModelAndView mv=new ModelAndView();
		if(username.equals("admin")&&password.equals("password"))
		{
			mv.addObject("quizes",quizService.getQuizes());
			mv.setViewName("admindashboard");
		}
		else
		{
			mv.addObject("res","invalid username and password");
			mv.setViewName("admin");
		}
		return mv;
	}
	@RequestMapping("/backtodashboard")
	public ModelAndView backtodashboard()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("quizes",quizService.getQuizes());
		mv.setViewName("admindashboard");
		return mv;

	}
	@RequestMapping("/createQuiz")
	public ModelAndView createQuiz(@RequestParam("title") String title,
			@RequestParam("description") String description)
	{
		ModelAndView mv=new ModelAndView();
		Quiz q=new Quiz(title,description);
		if(quizService.createQuiz(q))
		{
			mv.addObject("res", "Quiz created successfully !");	
		}
		else
		{   
			mv.addObject("res", " Failed to create try again !");	
			}
		mv.addObject("quizes",quizService.getQuizes());
		mv.setViewName("admindashboard");
		return mv;
	}
	@RequestMapping("/showquestionform")
	public ModelAndView showQuestionForm(@RequestParam("quizId") Long quizId)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("quizId",quizId);
		mv.setViewName("addquestion");
		return mv;
	}
	@RequestMapping("/addQuestion")
	public ModelAndView addQustion( @RequestParam("content") String content,
	        @RequestParam("optionA") String optionA,
	        @RequestParam("optionB") String optionB,
	        @RequestParam("optionC") String optionC,
	        @RequestParam("optionD") String optionD,
	        @RequestParam("correctAnswer") String correctAnswer,
	        @RequestParam("quizId") Long quizId)
	{
		ModelAndView mv=new ModelAndView();
		Question q=new Question(content,optionA,optionB,optionC,optionD,correctAnswer,quizId);
		if(questionService.AddQuestion(q))
		{
		  mv.addObject("res","added successfully, add more questions");	
		}
		else
		{
			mv.addObject("res", "failed to add question, try again");
		}
		mv.setViewName("addquestion");
		return mv;
	}
	@RequestMapping("/viewquestions")
	public ModelAndView viewQuestins(@RequestParam("quizId") Long quizid)
	{
		ModelAndView mv=new ModelAndView();
		List<Question> questions=questionService.getQuestionsByQuizid(quizid);
		if(questions!=null)
		{
			mv.addObject("questions", questions);
			
		}
		else
		{
			mv.addObject("res","no questions added till now");
		}
		mv.setViewName("viewquestions");
		return mv;
	}
	@RequestMapping("/editQuestionForm")
	public ModelAndView EditQuestins(@RequestParam("questionId") Long questionId)
	{
		ModelAndView mv=new ModelAndView();
		Question q=questionService.getQuestionbyid(questionId);
		if(q!=null)
		{
			mv.addObject("question",q);
			mv.setViewName("editquestion");
		}
		else
		{
			mv.addObject("res","not found question");
			mv.setViewName("viewquestions");
			
		}
		return mv;
	}
	@RequestMapping("/updateQuestion")
	public ModelAndView updateQuestion(@RequestParam("id") Long id,@RequestParam("content") String content,
	        @RequestParam("optionA") String optionA,
	        @RequestParam("optionB") String optionB,
	        @RequestParam("optionC") String optionC,
	        @RequestParam("optionD") String optionD,
	        @RequestParam("correctAnswer") String correctAnswer,@RequestParam("quizId") Long quizId)
	{
		ModelAndView mv=new ModelAndView();
		Question q=new Question(id,content,optionA,optionB,optionC,optionD,correctAnswer);
		if(questionService.updateQuestion(q))
		{
			mv.addObject("res","updated successfully");
		}
		else
		{
			mv.addObject("res","failed to update try again");
		}
		List<Question> questions=questionService.getQuestionsByQuizid(quizId);
		mv.addObject("questions",questions);
		mv.setViewName("viewquestions");
		return mv;
	}
	  
	
	@RequestMapping("/deleteQuestion")
	public ModelAndView deleteQuestion(@RequestParam("questionId") Long id,@RequestParam("quizId") Long quizId)
	{
	  ModelAndView mv=new ModelAndView();
	  if(questionService.deleteQuestionbyid(id))
	  {
		  mv.addObject("res","deleted successfully");
	  }
	  else
	  {
		  mv.addObject("res","failed to delete try again !");
	  }
	  List<Question> questions=questionService.getQuestionsByQuizid(quizId);
		mv.addObject("questions",questions);
		mv.setViewName("viewquestions");
		return mv;
	}
	@RequestMapping("/adminlogout")
	public String adminLogout()
	{
		return "redirect:http://localhost:8080/admin";
	}

}
