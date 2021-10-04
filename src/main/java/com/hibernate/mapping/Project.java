package com.hibernate.mapping;

import java.util.List;

import javax.persistence.*;

@Entity
public class Project {
	@Id
	private int project_id;
	private String projectName;
	@ManyToMany(mappedBy = "project")
	private List<Emp> emp;

	public Project(int project_id, String projectName, List<Emp> emp) {
		super();
		this.project_id = project_id;
		this.projectName = projectName;
		this.emp = emp;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Emp> getEmp() {
		return emp;
	}

	public void setEmp(List<Emp> emp) {
		this.emp = emp;
	}

}
