package hrms.business.concretes;

import org.springframework.stereotype.Service;

import hrms.business.abstracts.EmailCheckService;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessResult;

@Service 
public class EmailCheckManager implements EmailCheckService
{

	@Override
	public Result sendVerificationCode(String email) {		
		return new SuccessResult();
	}

	@Override
	public Result isVerificate(String email) {		
		return new SuccessResult();
	}
	
}
