package hrns.entities.abstracts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="users")
@Data
public class User 
{
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable = false)
	private int id;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="password", nullable = false)
	private String password;
}
