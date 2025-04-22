package com.QuizApplication.QuizApplication.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizApplication.QuizApplication.Model.Result;
import com.QuizApplication.QuizApplication.Repository.ResultRepo;

@Service
public class ResultService {
	@Autowired
	private ResultRepo resultRepo;
	public boolean saveResult(Result r)
	{
		return 1==resultRepo.saveResult(r);
	}
    public Result getResultsByUserIdAndQuizId(Long userId, Long quizId)
    {
    	return resultRepo.getResultsByUserIdAndQuizId(userId, quizId);
    }
    public List<Result> getResultByQuizid(Long id)
    {
    	return resultRepo.getResultsByQuizId(id);
    }
    public List<Result> getResultsByUserId(Long userid)
    {
    	return resultRepo.getResultsByUserId(userid);
    }
    public boolean UpdateResult(Result r)
    {
    	return 1==resultRepo.updateResult(r);
    }
}
