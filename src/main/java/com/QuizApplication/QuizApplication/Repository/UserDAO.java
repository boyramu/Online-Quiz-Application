package com.QuizApplication.QuizApplication.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.QuizApplication.QuizApplication.Model.User;

@Repository
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbc;

	public int createUser(User u)
	{
		String query="insert into user(username,email,password) values(?,?,?)";
		return jdbc.update(query,u.getUsername(),u.getEmail(),u.getPassword());
		
	}
	
	public User LoginUser(String username) {
	    String query = "select * from user where username = ?";
	   try {
		   
		   return jdbc.queryForObject(query, new UserMapper(), username);
	    } catch (EmptyResultDataAccessException e) {
	        return null;
	    }
	   
	    
	}

}
