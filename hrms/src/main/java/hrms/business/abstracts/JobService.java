package hrms.business.abstracts;

import java.util.List;

import hrms.entities.concretes.Job;

public interface JobService 
{
	List<Job> getAll();
}
