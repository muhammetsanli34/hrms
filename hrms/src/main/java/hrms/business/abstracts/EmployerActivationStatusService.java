package hrms.business.abstracts;

import hrms.core.utilities.results.Result;

public interface EmployerActivationStatusService
{
	Result isActivatedBySystem(int employerId);
}
