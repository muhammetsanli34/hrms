package hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrms.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>
{
	Job findByName(String name);
}
