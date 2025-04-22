package com.QuizApplication.QuizApplication.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.QuizApplication.QuizApplication.Model.Result;
import com.QuizApplication.QuizApplication.Model.User;

@Repository
public class ResultRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public int saveResult(Result r) {
        String query = "INSERT INTO result (userId, username, quizId, quizTitle, score, noOfAttempts, attemptedDateTime) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbc.update(query,
                r.getUserId(),
                r.getUsername(),
                r.getQuizId(),
                r.getQuizTitle(),
                r.getScore(),
                r.getNoOfAttempts(),
                r.getAttemptedDateTime()
        );
    }

    public List<Result> getResultsByUser(User u) {
        String query = "SELECT * FROM result WHERE userId = ?";
        try {
        return jdbc.query(query, new ResultMapper(), u.getId());
        }
        catch (EmptyResultDataAccessException e) {
	        return null;
	    }
    }

    public List<Result> getResultsByUserId(Long userId) {
        String query = "SELECT * FROM result WHERE userId = ?";
        try {
        return jdbc.query(query, new ResultMapper(), userId);
        }
        catch (EmptyResultDataAccessException e) {
	        return null;
	    }
    }

    public List<Result> getResultsByQuizId(Long quizId) {
    	String query = "SELECT * FROM result WHERE quizId = ? ORDER BY score DESC";
        try {
        return jdbc.query(query, new ResultMapper(), quizId);
        }
        catch (EmptyResultDataAccessException e) {
	        return null;
	    }
    }
    public Result getResultsByUserIdAndQuizId(Long userId, Long quizId) {
        String query = "SELECT * FROM result WHERE userId = ? AND quizId = ?";
        try {
        	 return jdbc.queryForObject(query, new ResultMapper(), userId, quizId);
        }
        catch (EmptyResultDataAccessException e) {
	        return null;
	    }
       
    }
    public int updateResult(Result r) {
        String query = "UPDATE result SET noOfAttempts = ?, score = ? WHERE id = ?";
        return jdbc.update(query, r.getNoOfAttempts(), r.getScore(), r.getId());
    }


}
