package hrms.business.concretes;

import org.springframework.stereotype.Service;

import hrms.business.abstracts.EmployerActivationStatusService;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessResult;

@Service
public class EmployerActivationStatusManager implements EmployerActivationStatusService
{
	
	@Override
	public Result isActivatedBySystem(int employerId) {		
		return new SuccessResult();
	}
	
	

}
