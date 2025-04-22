package com.QuizApplication.QuizApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizApplication.QuizApplication.Model.Question;
import com.QuizApplication.QuizApplication.Repository.QuestionRepo;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepo questionrepo;
	public boolean AddQuestion(Question q)
	{
		return 1==questionrepo.QuestionCreate(q);
	}
   public List<Question> getQuestionsByQuizid(Long quizid)
   {
	   return questionrepo.getQuestions(quizid);
   }
   public Question getQuestionbyid(Long id)
   {
	   return questionrepo.getQuestionByid(id);
   }
   public Boolean updateQuestion(Question q)
   {
	   return 1==questionrepo.updateQuestion(q);
   }
   public boolean deleteQuestionbyid(Long id)
   {
	   return 1==questionrepo.deleteQuestionbyid(id);
   }
   public List<Question> getRandomQuestion(Long quizid)
   {
	   return questionrepo.getRandomQuestion(quizid);
   }
}
