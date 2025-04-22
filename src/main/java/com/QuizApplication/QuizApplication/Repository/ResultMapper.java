package com.QuizApplication.QuizApplication.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.QuizApplication.QuizApplication.Model.Result;

public class ResultMapper implements RowMapper<Result> {

    @Override
    public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Long userId = rs.getLong("userId");
        String username = rs.getString("username");
        Long quizId = rs.getLong("quizId");
        String quizTitle = rs.getString("quizTitle");
        int score = rs.getInt("score");
        int noOfAttempts = rs.getInt("noOfAttempts");
        LocalDateTime attemptedDateTime = rs.getTimestamp("attemptedDateTime").toLocalDateTime();

        return new Result(id, userId, username, quizId, quizTitle, score, noOfAttempts, attemptedDateTime);
    }
}
