
package acme.entities.forums;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.messages.Message;
import acme.framework.entities.DomainEntity;
import acme.framework.entities.UserAccount;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Forum extends DomainEntity {

	private static final long				serialVersionUID	= 1L;

	@NotBlank
	private String							title;

	@Valid
	@OneToOne(optional = false)
	private InvestmentRound					investment;

	@OneToMany(mappedBy = "forum", cascade = CascadeType.ALL)
	private Collection<@Valid Message>		messages;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	private Collection<@Valid UserAccount>	participants;

}
