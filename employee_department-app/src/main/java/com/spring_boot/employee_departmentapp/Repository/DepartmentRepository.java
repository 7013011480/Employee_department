package com.spring_boot.employee_departmentapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring_boot.employee_departmentapp.Model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	List<Department> findByDepId(int depId);
	Boolean existsByDepId(int depId);
	
	@Query(value = "SELECT * FROM department WHERE dep_Id IN (:ids)",nativeQuery=true)
	List<Department> getDepByIds(@Param("ids") List<Integer> depIds);
	
}
