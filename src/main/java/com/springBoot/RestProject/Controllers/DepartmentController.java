package com.springBoot.RestProject.Controllers;

import java.util.List;

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

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department)
	{
		return departmentService.saveDepartment(department);
		
	}
	@GetMapping("/departments")
	public List<Department> fetchDepartments()
	{
		return departmentService.fetchDepartmentList();
	}
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentByID(@PathVariable("id")Long departmentId)
	{
		return departmentService.fetchDepartmentByID(departmentId);
	}
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentByID(@PathVariable("id")Long departmentId)
	{
		departmentService.deleteDepartmentByID(departmentId);
		return "department deleted successfully";
	}
	@PutMapping("/departments/{id}")
	public Department updatedepartmentById(@PathVariable("id")Long departmentId,@RequestBody Department department)
	{
		return departmentService.updatedepartmentById(departmentId,department);
	}
}
