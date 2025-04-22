package com.QuizApplication.QuizApplication.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.QuizApplication.QuizApplication.Model.User;
import com.QuizApplication.QuizApplication.Repository.UserDAO;

@Service
public class UserService {
	@Autowired
	private UserDAO userdao;
	public boolean createUser(User u)
	{
		return 1==userdao.createUser(u);
	}
    public User UserLogin(String username)
    {
    	return userdao.LoginUser(username);
   
    }
}
