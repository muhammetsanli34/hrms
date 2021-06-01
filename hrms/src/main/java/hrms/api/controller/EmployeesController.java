package hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hrms.business.abstracts.EmployeeService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController
{
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping
	public Result add(@RequestBody Employee employee)
	{
		return this.employeeService.add(employee);
	}
	
	@GetMapping("getbymail")
	public DataResult<Employee> getByMail(String email)
	{
		return this.employeeService.getByMail(email);
	}
	
	@GetMapping("getall")
	public DataResult<List<Employee>> getAll()
	{
		return this.employeeService.getAll();
	}
	
}

