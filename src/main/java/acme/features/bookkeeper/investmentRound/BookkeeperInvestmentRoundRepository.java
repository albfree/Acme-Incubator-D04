
package acme.features.bookkeeper.investmentRound;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BookkeeperInvestmentRoundRepository extends AbstractRepository {

	@Query("select iv from InvestmentRound iv where iv.id= ?1")
	InvestmentRound findOneInvestmentRoundById(int id);

	@Query("select iv from InvestmentRound iv")
	Collection<InvestmentRound> findActiveInvestmentRounds();

	//List iv with accounting records written by bookkeeper (published or draft)
	@Query("select ir from InvestmentRound ir where ir.id IN(select ar.investmentRound.id from AccountingRecord ar where ar.bookkeeper.id = ?1)")
	Collection<InvestmentRound> findManyInvestmentRoundByAC(int bookkeeperId);

	//List iv without accounting records written by bookkeeper (published or draft)
	@Query("select ir from InvestmentRound ir where ir.id NOT IN(select ar.investmentRound.id from AccountingRecord ar where ar.bookkeeper.id = ?1)")
	Collection<InvestmentRound> findManyInvestmentRoundNotByAC(int bookkeeperId);

}
