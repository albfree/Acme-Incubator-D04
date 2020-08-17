
package acme.features.bookkeeper.investmentRound;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class BookkeeperInvestmentRoundListNotMineService implements AbstractListService<Bookkeeper, InvestmentRound> {

	@Autowired
	private BookkeeperInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "amount");

	}

	@Override
	public Collection<InvestmentRound> findMany(final Request<InvestmentRound> request) {
		assert request != null;

		Principal principal;
		Collection<InvestmentRound> result = new ArrayList<>();

		principal = request.getPrincipal();
		Collection<InvestmentRound> temporalResult = this.repository.findManyInvestmentRoundNotByAC(principal.getActiveRoleId());

		for (InvestmentRound iv : temporalResult) {
			if (iv.sumActivitiesBudgets() == true) {
				result.add(iv);
			}
		}

		return result;
	}

}
