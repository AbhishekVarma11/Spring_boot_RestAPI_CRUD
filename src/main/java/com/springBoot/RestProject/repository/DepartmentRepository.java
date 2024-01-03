package com.springBoot.RestProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.RestProject.entity.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
