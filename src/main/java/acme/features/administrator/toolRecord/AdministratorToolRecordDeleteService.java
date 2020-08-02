
package acme.features.administrator.toolRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.records.ToolRecord;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorToolRecordDeleteService implements AbstractDeleteService<Administrator, ToolRecord> {

	// Internal state -----------------------------------------------------------

	@Autowired
	AdministratorToolRecordRepository repository;

	// AbstractListService<Administrator, TechnologyRecord>


	@Override
	public boolean authorise(final Request<ToolRecord> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<ToolRecord> request, final ToolRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "activitySector", "inventorsName", "description", "website", "email", "indication", "starsRate");
	}

	@Override
	public void bind(final Request<ToolRecord> request, final ToolRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void validate(final Request<ToolRecord> request, final ToolRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void delete(final Request<ToolRecord> request, final ToolRecord entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
	}

	@Override
	public ToolRecord findOne(final Request<ToolRecord> request) {
		assert request != null;

		ToolRecord res;
		int id;

		id = request.getModel().getInteger("id");
		res = this.repository.findOneById(id);
		return res;
	}

}
