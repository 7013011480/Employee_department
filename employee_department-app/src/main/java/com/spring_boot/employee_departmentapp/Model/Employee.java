package com.spring_boot.employee_departmentapp.Model;


import javax.persistence.*;


@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "empId", unique=true)
	private int empId;

	@Column(name = "emp_name")
	private String emp_name;

	@Column(name = "emp_des")
	private String emp_des;

	@Column(name = "emp_owner")
	private String emp_owner;

//	@ManyToMany
//	@JoinColumn(name="dep_id" , referencedColumnName="id")
//	private Set<Department> department;
//	
//	@ManyToMany(cascade = {
//	        CascadeType.ALL
//	    })
//	    @JoinTable(
//	        name = "employees_projects",
//	        joinColumns = {
//	            @JoinColumn(name = "employee_id")
//	        },
//	        inverseJoinColumns = {
//	            @JoinColumn(name = "project_id")
//	        }
//	    )
//	 Set < Department > projects = new HashSet < Project > ();
//	
	
	public Employee()
	{
		
	}
	public Employee( int empId, String emp_name, String emp_des, String emp_owner) {
		this.empId= empId;
		this.emp_name = emp_name;
		this.emp_des = emp_des;
		this.emp_owner = emp_owner;
	}
	
	public long getId() {
		return id;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_des() {
		return emp_des;
	}

	public void setEmp_des(String emp_des) {
		this.emp_des = emp_des;
	}

	public String getEmp_owner() {
		return emp_owner;
	}

	public void setEmp_owner(String emp_owner) {
		this.emp_owner = emp_owner;
	}
	
}
