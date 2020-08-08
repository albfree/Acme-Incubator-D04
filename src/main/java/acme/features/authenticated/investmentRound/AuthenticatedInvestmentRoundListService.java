
package acme.features.authenticated.investmentRound;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRounds.InvestmentRound;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedInvestmentRoundListService implements AbstractListService<Authenticated, InvestmentRound> {

	@Autowired
	private AuthenticatedInvestmentRoundRepository repository;


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

		Collection<InvestmentRound> result;
		result = this.repository.findActiveInvestmentRounds();

		Collection<InvestmentRound> col = result;

		for (InvestmentRound iv : col) {
			if (iv.sumActivitiesBudgets() == false) {
				result.remove(iv);
				//				for (InvestmentRound iv2 : result) {
				//					if (iv.getTicker().equals(iv2.getTicker())) {
				//						result.remove(iv2);
				//						break;
				//					}
				//				}
			}
		}

		//		Double sum = 0.;
		//
		//		for (InvestmentRound iv : result) {
		//			for (Activity act : iv.getWorkProgramme()) {
		//				sum += act.getBudget().getAmount();
		//			}
		//
		//			if (sum != iv.getAmount().getAmount()) {
		//				result.remove(iv);
		//			}
		//		}

		return result;
	}

}
