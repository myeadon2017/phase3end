package com.phase3end.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.phase3end.model.Task;
import com.phase3end.service.LoginService;
import com.phase3end.service.TaskService;

//This class is used as a Task Controller for user task functionality with front-end and back-end
//CRUD operations for Task
@Controller
@SessionAttributes("name")
public class TaskController {

	@Autowired
	TaskService service;

	
	//This method is for calendar functionality
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	@GetMapping("/list-tasks")
	public String showTasks(ModelMap model) {
		String name = (String) model.get("name");
		model.put("tasks", service.retrieveTask(name));
		return "list-tasks";
	}

	@GetMapping("/add-task")
	public String showAddTodoPage(ModelMap model) {
		model.addAttribute("task", new Task((String) model.get("name"),
				"Mopping","Very big mopping job", new Date(), new Date(), false, "default email", "High"));
		return "task";
	}

	@GetMapping("/delete-task")
	public String deleteTask(@RequestParam int id) {
		service.deleteTask(id);
		return "redirect:/list-tasks";
	}

	@GetMapping("/update-task")
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Task task = service.retrieveTask(id);
		model.put("task", task);
		return "task";
	}

	@PostMapping("/update-task")
	public String updateTask(ModelMap model, @Valid Task task,
			BindingResult result) {

		if (result.hasErrors()) {
			return "task";
		}

		task.setUser((String) model.get("name"));

		service.updateTask(task);

		return "redirect:/list-tasks";
	}

	@PostMapping("/add-task")
	public String addTask(ModelMap model, @Valid Task task, BindingResult result) {

		if (result.hasErrors()) {
			return "task";
		}

		service.addTask((String) model.get("name"), task.getTaskName(), task.getDesc(), task.getTargetDate(),
				task.getEndDate(), false, task.getEmail(), task.getSeverity());
		return "redirect:/list-tasks";
	}
}
