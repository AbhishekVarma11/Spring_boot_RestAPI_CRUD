package com.springBoot.RestProject.services;

import java.util.List;

import com.springBoot.RestProject.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentByID(Long departmentId);

	public void deleteDepartmentByID(Long departmentId);

	public Department updatedepartmentById(Long departmentId, Department department);

}
