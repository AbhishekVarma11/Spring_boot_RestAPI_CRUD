package service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springBoot.RestProject.RestProjectApplication;
import com.springBoot.RestProject.entity.Department;
import com.springBoot.RestProject.repository.DepartmentRepository;
import com.springBoot.RestProject.services.DepartmentService;


@SpringBootTest(classes= {RestProjectApplication.class})
public class DepartmentServiceTest {
	@Autowired
	private DepartmentService departmentService;
	@MockBean
	private DepartmentRepository departmentRepository;
	@BeforeEach
	public void setUp()
	{
		Department department=Department.builder()
				.departmentName("IT")
				.departmentAddress("HYD")
				.departmentCode("1")
				.build();
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
		.thenReturn(department);
	}
	@Test
	@DisplayName("test1-departmentnamevalidation")
	public void departmenttNameValidation()
	{
		String departmentName="IT";
		Department found=departmentService.fetchDepartmentByName(departmentName);
		assertEquals(departmentName,found.getDepartmentName());
	}

}
