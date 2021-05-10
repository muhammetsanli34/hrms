package hrns.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrns.business.abstracts.JobService;
import hrns.dataAccess.abstracts.JobDao;
import hrns.entities.concretes.Job;

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
	public List<Job> getAll()
	{
	     return this.jobDao.findAll();
	}

}
