
package acme.features.entrepreneur.accountingRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.records.AccountingRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurAccountingRecordRepository extends AbstractRepository {

	@Query("select ar from AccountingRecord ar where ar.id=?1")
	AccountingRecord findOneById(int id);

	@Query("select ar from AccountingRecord ar")
	Collection<AccountingRecord> findMany();

	@Query("select ar from AccountingRecord ar where ar.investmentRound.id = ?1")
	Collection<AccountingRecord> findManyByInvestmentRoundId(int investmentRoundId);

}
