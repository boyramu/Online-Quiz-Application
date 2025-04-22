package com.QuizApplication.QuizApplication.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.QuizApplication.QuizApplication.Model.Quiz;

@Repository
public class QuizRepository {
	@Autowired
	private JdbcTemplate jdbc;
	public int createQuiz(Quiz q)
	{
		String query="insert into quiz(title,description) values(?,?)";
		return jdbc.update(query,q.getTitle(),q.getDescription());
	}
	public List<Quiz> getQuizes()
	{
		String query="select * from quiz";
		return jdbc.query(query, new QuizMapper());
	}
	public Quiz getQuizByid(Long id)
	{
		String query="select * from quiz where id=?";
		return jdbc.queryForObject(query,new QuizMapper(),id);
	}

}
