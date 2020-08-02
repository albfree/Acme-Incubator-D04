
package acme.entities.records;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class TechnologyRecord extends DomainEntity {

	// Serialization identifier --------------------------------------------

	private static final long	serialVersionUID	= 1L;

	//Atributes ------------------------------------------------------------

	@NotBlank
	private String				title;

	@NotBlank
	private String				activitySector;

	@NotBlank
	private String				inventorsName;

	@NotBlank
	private String				description;

	@NotBlank
	@URL
	private String				website;

	@NotBlank
	@Email
	private String				email;

	@NotBlank
	@Pattern(regexp = "^(open-source|closed-source)$")
	private String				indication;

	@Min(-5)
	@Max(5)
	private Integer				starsRate;

}
