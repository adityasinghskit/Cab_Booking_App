package com.masai.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.masai.dto.Auditable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractUser extends Auditable{

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String userId;
	
	@Size(min = 3, max = 255, message = "{nameRange}")
	@NotNull(message = "{notNull}")
	private String username;
	
	@Size(min = 4, max = 20, message = "{PasswordRange}")
	@NotNull(message = "{notNull}")
	private String password;

	@Size(min = 10, message = "{MobileRange}")
	private String mobile;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id")
	private Address address;
	
	@Email
	@NotNull(message = "{notNull}")
	private String email;

}
