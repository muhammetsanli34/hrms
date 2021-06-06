package hrms.business.abstracts;

import java.util.List;

import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService
{
	Result add(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getActiveAdvertisements();
	
	DataResult<List<JobAdvertisement>> getActiveAdvertisementsByEmployer(String companyName);	
	
	Result setAdvertisementToPassive(int id);
	
	Result setAdvertisementToActive(int id);
	
	DataResult<List<JobAdvertisement>> getAllSortedByDate();
}