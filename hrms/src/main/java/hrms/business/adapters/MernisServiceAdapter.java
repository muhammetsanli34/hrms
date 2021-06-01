package hrms.business.adapters;

import org.springframework.stereotype.Service;

import hrms.business.abstracts.MernisCheckService;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessResult;
import hrms.entities.abstracts.User;

@Service
public class MernisServiceAdapter implements MernisCheckService
{
	@Override
	public Result checkIfRealPerson(User user) {
		return new SuccessResult();
	}

}
