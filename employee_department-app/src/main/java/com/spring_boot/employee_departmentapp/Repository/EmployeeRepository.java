package com.spring_boot.employee_departmentapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_boot.employee_departmentapp.Model.Employee;
import com.spring_boot.employee_departmentapp.Model.Employee_Department;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByEmpId(int empId);
	Boolean existsByEmpId(int empId);
}
