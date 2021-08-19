package com.spring_boot.employee_departmentapp.Model;


import javax.persistence.*;

@Entity
@Table(name = "employee_department")
public class Employee_Department  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "empId")
	private int empId;

	@Column(name = "depaId")
	private int depaId;

	public Employee_Department() {
		
	}
	public Employee_Department( int empId, int depaId) {
		this.empId= empId;
		this.depaId= depaId;
	}
	
	
	public long getId() {
		return id;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmplId(int empId) {
		this.empId = empId;
	}


	public int getDepaId() {
		return depaId;
	}


	public void setDepaId(int depaId) {
		this.depaId = depaId;
	}
}

