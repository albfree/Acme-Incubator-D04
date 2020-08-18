
package acme.features.authenticated.accountingRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.records.AccountingRecord;
import acme.entities.roles.Bookkeeper;
import acme.entities.status.StatusAccounting;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedAccountingRecordShowService implements AbstractShowService<Authenticated, AccountingRecord> {

	@Autowired
	private AuthenticatedAccountingRecordRepository repository;


	@Override
	public boolean authorise(final Request<AccountingRecord> request) {
		assert request != null;

		boolean result;
		int accountingId;
		Bookkeeper bookkeeper;
		AccountingRecord accountingRecord;
		Principal principal;

		principal = request.getPrincipal();
		accountingId = request.getModel().getInteger("id");
		accountingRecord = this.repository.findOneById(accountingId);
		bookkeeper = accountingRecord.getBookkeeper();
		result = accountingRecord.getStatus() == StatusAccounting.PUBLISHED || accountingRecord.getStatus() == StatusAccounting.DRAFT && bookkeeper.getUserAccount().getId() == principal.getAccountId();

		return result;

	}

	@Override
	public void unbind(final Request<AccountingRecord> request, final AccountingRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "status", "creationMoment", "body", "bookkeeper.userAccount.identity.fullName", "investmentRound.ticker");

	}

	@Override
	public AccountingRecord findOne(final Request<AccountingRecord> request) {
		assert request != null;

		AccountingRecord result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
