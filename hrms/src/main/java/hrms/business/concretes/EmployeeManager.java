package hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.business.abstracts.EmailCheckService;
import hrms.business.abstracts.EmployeeService;
import hrms.business.abstracts.MernisCheckService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.ErrorResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.core.utilities.validation.BusinessRules;
import hrms.dataAccess.abstracts.EmployeeDao;
import hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService
{
	private MernisCheckService mernisCheckService;
	private EmployeeDao employeeDao;
	private EmailCheckService emailCheckService;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao, MernisCheckService userCheckService, EmailCheckService emailCheckService) {		
		this.employeeDao = employeeDao;
		this.mernisCheckService=userCheckService;
		this.emailCheckService=emailCheckService;
	}

	@Override
	public Result add(Employee employee){
		var emailIsExist=getByMail(employee.getEmail()).getData();
		if(emailIsExist==null)
		{
			Result logicResult=BusinessRules.Run(this.mernisCheckService.checkIfRealPerson(employee),
												 this.emailCheckService.isVerificate(employee.getEmail()),
												 checkIfNationalityIsExist(employee.getNationalityId())
					);
			if (logicResult==null) {
				this.employeeDao.save(employee);
				return new SuccessResult("Kullanıcı oluşturuldu");
			}
			return new ErrorResult(logicResult.getMessage());
		}
		
		return new ErrorResult("Bu email ile bir kayıt mevcut");
	}
	
	
	
	@Override
	public DataResult<Employee> getByMail(String email){
		return new SuccessDataResult<Employee>(this.employeeDao.findByEmail(email));
	}
	
	@Override
	public DataResult<Employee> getByNationalityId(String nationalityId) {
		return new SuccessDataResult<Employee>(this.employeeDao.findByNationalityId(nationalityId));
	}

	private Result checkIfNationalityIsExist(String nationalityId) {		
		var employee=getByNationalityId(nationalityId);
		if(employee.getData()!=null)
		{
				return new ErrorResult("Bu kimlik numarası ile bir kayıt mevcut");
		}
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll());
	}
	
	
	
}
