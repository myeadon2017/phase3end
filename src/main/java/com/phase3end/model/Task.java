package com.phase3end.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

//This class is used as a base model for my users task information
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String user;
    
    private String taskName;
    @Size(min=10, message="Enter at least 10 Characters...")
    private String desc;

    private Date targetDate;
    private Date endDate;
    private boolean isDone;
    private String email;
    private String severity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public Task(String user, String taskName, String desc, Date targetDate, Date endDate, boolean isDone,
			String email, String severity) {
		super();
		this.user = user;
		this.taskName = taskName;
		this.desc = desc;
		this.targetDate = targetDate;
		this.endDate = endDate;
		this.isDone = isDone;
		this.email = email;
		this.severity = severity;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Task other = (Task) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }
	@Override
	public String toString() {
		return "Task [id=" + id + ", user=" + user + ", taskName=" + taskName + ", desc=" + desc + ", targetDate="
				+ targetDate + ", endDate=" + endDate + ", isDone=" + isDone + ", email=" + email + ", severity="
				+ severity + "]";
	}

    
}
