package com.hibernate.mapping;

import java.util.List;

import javax.persistence.*;

@Entity
public class Emp {
	@Id
	private int emp_id;
	private String empName;
	@ManyToMany
	private List<Project> project;
	
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

	public Emp(int emp_id, String empName, List<Project> project) {
		super();
		this.emp_id = emp_id;
		this.empName = empName;
		this.project = project;
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

}
