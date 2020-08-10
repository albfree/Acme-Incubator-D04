
package acme.features.entrepreneur.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EntrepreneurApplicationShowService implements AbstractShowService<Entrepreneur, Application> {

	@Autowired
	private EntrepreneurApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "creationDate", "statement", "investmentOffer", "status");

	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		Principal principal;
		int applicationID;

		principal = request.getPrincipal();
		applicationID = request.getModel().getInteger("id");
		result = this.repository.findOneApplicationById(applicationID, principal.getActiveRoleId());

		return result;
	}

}
