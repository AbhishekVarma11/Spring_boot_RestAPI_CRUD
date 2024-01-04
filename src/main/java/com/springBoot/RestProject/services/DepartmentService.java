package com.springBoot.RestProject.services;

import java.util.List;

import com.springBoot.RestProject.entity.Department;

import Exceptions.DepartmentNotFound;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentByID(Long departmentId) throws DepartmentNotFound;

	public void deleteDepartmentByID(Long departmentId);

	public Department updatedepartmentById(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

}
