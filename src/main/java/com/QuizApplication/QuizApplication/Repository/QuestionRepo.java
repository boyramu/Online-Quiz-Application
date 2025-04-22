package com.QuizApplication.QuizApplication.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.QuizApplication.QuizApplication.Model.Question;

@Repository
public class QuestionRepo {
	@Autowired
	private JdbcTemplate jdbc;
	public int QuestionCreate(Question q)
	{
				String query="INSERT INTO question ( content, option_a, option_b, option_c, option_d, correct_answer, quiz_id) "
						+ "values(?,?,?,?,?,?,?)";
				return jdbc.update(query,q.getContent(),q.getOptionA(),q.getOptionB(),q.getOptionC(),q.getOptionD(),
						q.getCorrectAnswer(),q.getQuizId());
	}
	public List<Question> getQuestions(Long quizid)
	{
		String query="select * from question where quiz_id=?";
		return jdbc.query(query,new QuestionMapper(),quizid);
	}
  public Question getQuestionByid(Long id)
  {
	  String query="select * from question where id=?";
	  return  jdbc.queryForObject(query,new QuestionMapper(),id);
	  
  }
  public int updateQuestion(Question q)
  {
	  String query="update question set content=? , option_a=? , option_b=? , option_c=? , option_d=? ,"
	  		+ "correct_answer=? where id=?";
	  return jdbc.update(query,q.getContent(),q.getOptionA(),q.getOptionB(),q.getOptionC(),q.getOptionD(),
			  q.getCorrectAnswer(),q.getId());
			  
  }
  public int deleteQuestionbyid(Long id)
  {
	  String query="delete from question where id=?";
	  return jdbc.update(query,id);
  }
  public List<Question> getRandomQuestion(Long quizid)
  {
	  String query="select * from question where quiz_id=? order by RAND()";
	  return jdbc.query(query, new QuestionMapper(),quizid);
  }
}
