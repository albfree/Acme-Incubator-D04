
package acme.features.bookkeeper.accountingRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.records.AccountingRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface BookkeeperAccountingRecordRepository extends AbstractRepository {

	@Query("select ar from AccountingRecord ar where ar.id=?1")
	AccountingRecord findOneById(int id);

	@Query("select ar from AccountingRecord ar")
	Collection<AccountingRecord> findMany();

	@Query("select ar from AccountingRecord ar where ar.investmentRound.id = ?1 and ar.status = 1")
	Collection<AccountingRecord> findManyPublishedByInvestmentRoundId(int investmentRoundId);

	@Query("select ar from AccountingRecord ar where ar.investmentRound.id = ?1 and ar.bookkeeper.id = ?2")
	Collection<AccountingRecord> findManyByInvestmentRoundIdAndBookkeeper(int investmentRoundId, int bookkeepper);

}
