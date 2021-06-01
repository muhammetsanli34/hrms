package hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class Employer extends User
{
	@Column(name = "company_Name")
	private String companyName;
	
	@Column(name = "web_Site")
	private String webSite;
	
	@Column(name = "phone_Number")
	private String phone_Number;
}
