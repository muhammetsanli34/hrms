package hrns.business.abstracts;

import java.util.List;

import hrns.entities.concretes.Job;

public interface JobService 
{
	List<Job> getAll();
}
