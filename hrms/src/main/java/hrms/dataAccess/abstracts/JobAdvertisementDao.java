package hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>
{
	List<JobAdvertisement> findByIsActiveTrue();
	
	List<JobAdvertisement> findByIsActiveTrueAndEmployer_CompanyName (String companyName);
	
	//List<JobAdvertisement> findByIsActiveTrueOrderByReleaseDateDesc();
}
