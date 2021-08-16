package com.spring_boot.employee_departmentapp.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.spring_boot.employee_departmentapp.Repository.DepartmentRepository;
import com.spring_boot.employee_departmentapp.Repository.EmployeeDepartmentRepository;
import com.spring_boot.employee_departmentapp.Repository.EmployeeRepository;
import com.spring_boot.employee_departmentapp.Model.Department;
import com.spring_boot.employee_departmentapp.Model.Employee;
import com.spring_boot.employee_departmentapp.Model.Employee_Department;


@RestController
public class EmployeeDepartmentController {

@Autowired
DepartmentRepository department_repository;

@Autowired
 EmployeeRepository employee_repository;

@Autowired
EmployeeDepartmentRepository employeedepartment_repository;



@PostMapping("/upload")
public String upload( @RequestParam("file") MultipartFile file, @RequestParam("emp_id") int empId, 
		@RequestParam("emp_name") String emp_name, 
		@RequestParam("emp_des") String emp_des,
		@RequestParam("emp_owner") String emp_owner) throws IOException
   
{
	System.out.println("\n im here \n");
		
	if( employee_repository.existsByEmpId(empId) == false) 
	employee_repository.save(new Employee(empId, emp_name, emp_des, emp_owner));
	 
	  List<String> templist = new ArrayList<String>();
	 
	  XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
 	  
	  Sheet worksheet = workbook.getSheetAt(0);
	  
	  int rows=worksheet.getLastRowNum();
	  int cols=worksheet.getRow(1).getLastCellNum();
	  
	  for(int r=0;r<=rows;r++)
	  {
		  int dep_id = 0 ;
		  String dep_name = new String();
		  String dep_des = new String();
		  String dep_owner = new String();
		  
		  XSSFRow row = (XSSFRow) worksheet.getRow(r);
		  for(int c=0;c<cols;c++)
		  {
			XSSFCell cell = row.getCell(c);
			if(c==0) dep_id=(int) cell.getNumericCellValue();
			if(c==1) dep_name=cell.getStringCellValue();
			if(c==2) dep_des=cell.getStringCellValue();
			if(c==3) dep_owner=cell.getStringCellValue();
		  }
		  System.out.println("\n"+dep_id+" "+dep_name+" "+dep_des+" "+dep_owner+"\n");
		  
		  if( department_repository.existsByDepId(dep_id) == false)
		 department_repository.save(new Department(dep_id,dep_name,dep_des,dep_owner));
		 
		 employeedepartment_repository.save(new Employee_Department(empId,dep_id));
	  }
	 return "updated successfully";
}




@GetMapping("/employees")
public List<Employee> getAllEmployee()
{
	List<Employee> list = employee_repository.findAll();
	return list;	
}



@GetMapping("/departments")
public List<Department> getAllDepartment()
{
	return department_repository.findAll();
}

@GetMapping("/employee/{id}")
public List<Employee> getEmployeeById(@PathVariable(value="id") int employeeId) {
	List<Employee> employee = employee_repository.findByEmpId(employeeId);
	return employee;
}

@GetMapping("/department/{id}")
public List<Department> getDepartmentById(@PathVariable(value="id") int departmentId) {
	List<Department> department = department_repository.findByDepId(departmentId);
	return department;
}

@GetMapping("/getEmployeesForDepid/{id}")

public List<Integer> getEmployees(@PathVariable(value="id") int departmentId)
{
	List<Employee_Department> emp = employeedepartment_repository.findByDepaId(departmentId);
	List<Integer> list = new ArrayList<>();
	for(Employee_Department employee_department:emp)
	{
		list.add(employee_department.getEmpId());
	}
	return list;
}

@GetMapping("/getDepartmentsForEmpid/{id}")
public List<Department> getDepartments(@PathVariable(value="id") int employeeId)
{
	List<Employee_Department> dep = employeedepartment_repository.findByEmpId(employeeId);
	List<Integer> list = new ArrayList<>();
	for (Employee_Department employee_department : dep) {
		list.add(employee_department.getDepaId());
	}
	return department_repository.getDepByIds(list);
}


//@GetMapping("/getDepartmentsForEmpid/{id}")
//
//public List<String> getDepartments(@PathVariable(value="id") String employeeId)
//{
//	List<Employee_Department> dep = employeedepartment_repository.findByEmplIdLike(employeeId);
//	List<String> list = new ArrayList<>();
//	for(Employee_Department employee_department:dep)
//	{
//		list.add(employee_department.getDepaId());
//	}
//	return list;
//}

  
}