package hrms.business.abstracts;

import java.util.List;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.Job;

public interface JobService 
{
	Result add(Job job);
	DataResult<List<Job>> getAll();
}
