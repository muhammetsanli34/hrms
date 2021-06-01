package hrms.business.abstracts;

import java.util.List;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Employee;

public interface EmployeeService
{
	Result add(Employee employee);
	DataResult<Employee> getByMail(String email);
	DataResult<Employee> getByNationalityId(String nationalityId);
	DataResult<List<Employee>> getAll();	

}
