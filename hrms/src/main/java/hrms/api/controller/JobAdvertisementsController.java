package hrms.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hrms.business.abstracts.JobAdvertisementService;
import hrms.core.utilities.results.DataResult;
import hrms.core.utilities.results.Result;
import hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/job_advertisements")
public class JobAdvertisementsController
{
	
	JobAdvertisementService jobAdvertisementService;
	
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping(name = "/getActiveAdvertisements")
	public DataResult<List<JobAdvertisement>> getActiveAdvertisements(){
		return this.jobAdvertisementService.getActiveAdvertisements();
	}
	 
	@PostMapping
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getActiveAdvertisementsByEmployers")
	public DataResult<List<JobAdvertisement>> getActiveAdvertisementsByEmployer(String companyName) {
		return this.jobAdvertisementService.getActiveAdvertisementsByEmployer(companyName);
	}
	
}
