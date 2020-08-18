
package acme.entities.records;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.entities.status.StatusAccounting;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class AccountingRecord extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@NotNull
	private StatusAccounting				status;

	@Past
	@Temporal(TemporalType.TIMESTAMP)
	private Date				creationMoment;

	@NotBlank
	private String				body;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private Bookkeeper			bookkeeper;

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	private InvestmentRound		investmentRound;

}
