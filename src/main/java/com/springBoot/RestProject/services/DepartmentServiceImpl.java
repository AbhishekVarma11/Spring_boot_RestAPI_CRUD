package com.springBoot.RestProject.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.RestProject.entity.Department;
import com.springBoot.RestProject.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRespository;
	@Override
	public Department saveDepartment(Department department) {
		return departmentRespository.save(department);
	}
	public List<Department> fetchDepartmentList() {
		return departmentRespository.findAll();
		
	}
	public Department fetchDepartmentByID(Long departmentId) {
		return departmentRespository.findById(departmentId).get();
	}
	
	public void deleteDepartmentByID(Long departmentId) {
		departmentRespository.deleteById(departmentId);
		
		
	}
	
	public Department updatedepartmentById(Long departmentId, Department department) {
		Department obj=departmentRespository.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName())&&
				!"".equalsIgnoreCase(department.getDepartmentName()))
		{
			obj.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentAddress())&&
				!"".equalsIgnoreCase(department.getDepartmentName()))
		{
			obj.setDepartmentAddress(department.getDepartmentAddress());
		}
		if(Objects.nonNull(department.getDepartmentCode())&&
				!"".equalsIgnoreCase(department.getDepartmentCode()))
		{
			obj.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRespository.save(obj);
		
	}
	
	public Department fetchDepartmentByName(String departmentName) {
		return departmentRespository.findByDepartmentNameIgnoreCase(departmentName);
	}

}
