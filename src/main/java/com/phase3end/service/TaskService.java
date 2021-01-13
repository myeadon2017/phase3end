package com.phase3end.service;
import java.util.*;

import com.phase3end.dao.TaskDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3end.model.Task;

//This class is used as a Task Service for my user task business logic
@Service
public class TaskService {
    //private static List<Todo> todos = new ArrayList<Todo>();

    @Autowired
    TaskDao taskDao;

//    static {
//        todos.add(new Todo(1, "amarjeet", "Learn Spring MVC", new Date(),
//                false, "test1@gmail.com", "12345", "LA"));
//        todos.add(new Todo(2, "amarjeet", "Learn Struts", new Date(), false, "test2@gmail.com", "123456", "LA"));
//        todos.add(new Todo(3, "amarjeet", "Learn Hibernate", new Date(),
//                false, "test3@gmail.com", "1234567", "LA"));
//
//
//    }

    public List<Task> retrieveTask(String user) {
        return (List<Task>) taskDao.findAll();
    }
    
    public Task retrieveTask(int id) {
        return taskDao.findOne(id);
    }

    public void updateTask(Task task){
    		Optional<Task> t = Optional.ofNullable(taskDao.findOne(task.getId()));
    		if (t.isPresent()){
    		    taskDao.delete(t.get());
    		    taskDao.save(t.get());
            }
    }

    public void addTask(String name, String taskName, String desc, Date targetDate, Date endDate,
            boolean isDone, String email, String severity) {
            taskDao.save(new Task(name,taskName,desc,targetDate,endDate,isDone,email,severity));

    }

    public void deleteTask(int id) {
        taskDao.delete(id);
    }
}