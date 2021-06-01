package hrms.business.abstracts;

import hrms.core.utilities.results.Result;

public interface EmailCheckService
{
	Result sendVerificationCode(String email);
	
	Result isVerificate(String email);
}