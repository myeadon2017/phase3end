package com.phase3end.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.phase3end.model.Login;


//This interface is used as the LoginDao for my login CRUD repository
@Repository
public interface LoginDao extends CrudRepository<Login, Integer> {

}
