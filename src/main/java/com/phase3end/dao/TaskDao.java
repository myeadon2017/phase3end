package com.phase3end.dao;

import com.phase3end.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends CrudRepository<Task, Integer> {
}