package com.spring_boot.employee_departmentapp.Model;


import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "depId", unique=true)
	private int depId;

	@Column(name = "depName")
	private String depName;

	@Column(name = "depDes")
	private String depDes;

	@Column(name = "depOwner")
	private String depOwner;
	
	public Department()
	{
		
	}


	public Department( int depId, String depName, String depDes, String depOwner) {
		this.depId= depId;
		this.depName = depName;
		this.depDes = depDes;
		this.depOwner = depOwner;
	}

	public long getId() {
		return id;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepDes() {
		return depDes;
	}

	public void setDepDes(String depDes) {
		this.depDes = depDes;
	}

	public String getDepOwner() {
		return depOwner;
	}

	public void setDepOwner(String depOwner) {
		this.depOwner = depOwner;
	}
		
}
