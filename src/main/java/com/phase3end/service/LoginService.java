package com.phase3end.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3end.dao.LoginDao;
import com.phase3end.model.Login;


//This class is used as a Login Service for my user login business logic
@Service	
public class LoginService {

	@Autowired
    LoginDao loginDao;
	
	 public List<Login> retrieveLogin(String username) {
	        return (List<Login>) loginDao.findAll();
	    }

	
	//This method will take in the user login info and check for authentication in the database
	public boolean validateUser(String name, String password) {
        for(Login usr: retrieveLogin(name)) {
			if(usr.getUsername().equals(name) && usr.getPassword().equals(password) ) {
		return true;
    }
        }
	return false;
	}


	public boolean addUser(String username, String password) {
		
		loginDao.save(new Login(username, password));
		
		return true;
	
	}

}
