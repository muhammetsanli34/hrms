package hrms.business.abstracts;

import hrms.core.utilities.results.Result;
import hrms.entities.abstracts.User;

public interface MernisCheckService
{
	Result checkIfRealPerson(User user);
}
