package hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hrms.business.abstracts.JobAdvertisementService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.core.utilities.results.SuccessDataResult;
import hrms.core.utilities.results.SuccessResult;
import hrms.dataAccess.abstracts.JobAdvertisementDao;
import hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService
{
	JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveAdvertisements() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveAdvertisementsByEmployer(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueAndEmployer_CompanyName(companyName));
	}

	@Override
	public Result setAdvertisementToPassive(int id) {
		var updatedAdvertisement=this.jobAdvertisementDao.findById(id).get();
		updatedAdvertisement.setActive(false);
		this.jobAdvertisementDao.save(updatedAdvertisement);
		return new SuccessResult("İlan pasif hale getirildi");
	}

	public Result setAdvertisementToActive(int id) {
		var updatedAdvertisement=this.jobAdvertisementDao.findById(id).get();
		updatedAdvertisement.setActive(true);
		this.jobAdvertisementDao.save(updatedAdvertisement);
		return new SuccessResult("İlan aktif hale getirildi");
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAllSortedByDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByIsActiveTrueOrderByReleaseDateDesc());
	}

}
