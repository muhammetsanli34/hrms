package hrms.entities.concretes;

import java.time.LocalDate;

import javax.management.ConstructorParameters;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Entity
@Table(name = "jobAdvertisements")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobAdvertisement
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "max_Salary")
	private int maxSalary;
	
	@Column(name = "min_Salary")
	private int minSalary;
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "release_date") 
	private LocalDate releaseDate;
	
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;

	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name = "job_position_id")
	private Job job;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	public void setReleaseDate(){
		this.releaseDate=LocalDate.now();
	}
	
}
