package com.genuinecoder.springserver;

import com.genuinecoder.springserver.springserver.model.employee.Employee;
import com.genuinecoder.springserver.springserver.model.employee.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringServerApplicationTests {

	@Autowired
	private EmployeeDao employeeDao;

	@Test
	void addEmployeeTest() {
		Employee employee = new Employee();
		employee.setNombre("Andres");
		employee.setPuesto("Marketing");
		employee.setUbicacion("Santa Clara");
		employeeDao.save(employee);
	}

	//Test
	void getAllEmployeeAndDeleteThem() {
		List<Employee> employees = employeeDao.getAllEmployees();
		for (Employee employee : employees){
			employeeDao.delete(employee.getId());
		}
	}

}
