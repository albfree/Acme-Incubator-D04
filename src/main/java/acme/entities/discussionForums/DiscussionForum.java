
package acme.entities.discussionForums;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.messages.Message;
import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DiscussionForum extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	private String				title;

	@Past
	@Temporal(TemporalType.TIMESTAMP)
	private Date				creationMoment;

	@Valid
	@OneToMany(mappedBy = "discussionForum")
	private Collection<Message>	messages;

	@NotNull
	@Valid
	@OneToOne(optional = true)
	private InvestmentRound		investmentRound;
}
