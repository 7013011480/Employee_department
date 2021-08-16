package com.spring_boot.employee_departmentapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_boot.employee_departmentapp.Model.Employee_Department;

@Repository
public interface EmployeeDepartmentRepository extends JpaRepository<Employee_Department, Long> {
	List<Employee_Department> findByEmpId(int empId);
	List<Employee_Department> findByDepaId(int depaId);
}
