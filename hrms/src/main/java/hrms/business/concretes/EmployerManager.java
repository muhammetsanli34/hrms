package hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.business.abstracts.EmailCheckService;
import hrms.business.abstracts.EmployerService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.ErrorResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.core.utilities.validation.BusinessRules;
import hrms.dataAccess.abstracts.EmployerDao;
import hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService 
{
	EmailCheckService emailCheckService;
	EmployerDao employerDao;
	EmployerActivationStatusManager employerActivationStatusManager;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailCheckService emailCheckService, EmployerActivationStatusManager employerActivationStatusManager) {
		this.employerDao = employerDao;
		this.emailCheckService=emailCheckService;
		this.employerActivationStatusManager=employerActivationStatusManager;
	}



	@Override
	public Result add(Employer employer) {	
		
		var emailIsExist=employerDao.findByEmail(employer.getEmail());
		if(emailIsExist==null)
		{
			var logicResult=BusinessRules.Run(emailCheckService.isVerificate(employer.getEmail()), 
											 employerActivationStatusManager.isActivatedBySystem(employer.getId())
											 );
			if(logicResult==null)
			{
				this.employerDao.save(employer);
				return new SuccessResult("İş veren oluşturuldu");	
			}
			return new ErrorResult(logicResult.getMessage());
		}
		return new ErrorResult("Bu mail daha önceden kullanılmış");
	}



	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}
}
