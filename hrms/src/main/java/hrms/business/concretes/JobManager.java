package hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.business.abstracts.JobService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.ErrorResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.JobDao;
import hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService
{	
	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public DataResult<List<Job>> getAll()
	{ 
		 return new SuccessDataResult<List<Job>>(this.jobDao.findAll());
	}

	@Override
	public Result add(Job job) {
		var jobIsExist=this.jobDao.findByName(job.getName());
		if(jobIsExist==null)
		{
			this.jobDao.save(job);
			return new SuccessResult("İş eklendi");
		}
		return new ErrorResult("Bu iş mevcut");
	}
}
