package com.phase3end.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3end.dao.LoginDao;
import com.phase3end.model.Login;



@Service	
public class LoginService {

	@Autowired
    LoginDao loginDao;
	
	 public List<Login> retrieveLogin(String username) {
	        return (List<Login>) loginDao.findAll();
	    }

	
	
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
