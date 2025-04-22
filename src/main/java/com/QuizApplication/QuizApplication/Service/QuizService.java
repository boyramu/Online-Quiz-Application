package com.QuizApplication.QuizApplication.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizApplication.QuizApplication.Model.Quiz;
import com.QuizApplication.QuizApplication.Repository.QuizRepository;

@Service
public class QuizService {
	@Autowired
	private QuizRepository qr;
	public boolean createQuiz(Quiz q)
	{
		return 1==qr.createQuiz(q);
	}
	public List<Quiz> getQuizes()
	{
		return qr.getQuizes();
	}
    public Quiz getQuizByid(Long id)
    {
    	return qr.getQuizByid(id);
    }
}
