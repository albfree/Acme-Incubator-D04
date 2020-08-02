
package acme.entities.bulletins;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EscobarBulletin extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				author;

	@NotBlank
	private String				text;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	private Date				moment;

	@URL
	@NotBlank
	private String				link;

	@NotBlank
	private String				country;

}
