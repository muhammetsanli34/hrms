package hrns.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrns.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer>{

}
