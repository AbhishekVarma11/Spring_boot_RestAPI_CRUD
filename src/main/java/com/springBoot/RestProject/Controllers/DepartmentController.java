package com.springBoot.RestProject.Controllers;

import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.RestProject.entity.Department;
import com.springBoot.RestProject.services.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	private final Logger logger=LoggerFactory.getLogger(DepartmentController.class);
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department)
	{
		logger.info("inside the saveDepartment method");
		return departmentService.saveDepartment(department);
		
	}
	@GetMapping("/departments")
	public List<Department> fetchDepartments()
	{
		logger.info("inside the fetchDepartment method");
		return departmentService.fetchDepartmentList();
	}
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentByID(@PathVariable("id")Long departmentId)
	{
		logger.info("inside the fetchDepartmentbyID method");
		return departmentService.fetchDepartmentByID(departmentId);
	}
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentByID(@PathVariable("id")Long departmentId)
	{
		logger.info("inside the deleteDepartmentByIDmethod");
		departmentService.deleteDepartmentByID(departmentId);
		return "department deleted successfully";
	}
	@PutMapping("/departments/{id}")
	public Department updatedepartmentById(@PathVariable("id")Long departmentId,@RequestBody Department department)
	{
		logger.info("inside the updatedepartmentById method");
		return departmentService.updatedepartmentById(departmentId,department);
	}
	@GetMapping("/departments/name/{name}")
	
		public Department fetchDepartmentByName(@PathVariable("name") String departmentName)
		{
		logger.info("inside the fetchDepartmentByNamet method");
		return departmentService.fetchDepartmentByName(departmentName);
	}

}
