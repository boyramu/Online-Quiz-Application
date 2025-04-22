package com.QuizApplication.QuizApplication.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.QuizApplication.QuizApplication.Model.Quiz;

public class QuizMapper implements RowMapper<Quiz>{

	@Override
	public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Quiz q=new Quiz(rs.getLong(1),rs.getString(2),rs.getString(3));
		return q;
	}

}
