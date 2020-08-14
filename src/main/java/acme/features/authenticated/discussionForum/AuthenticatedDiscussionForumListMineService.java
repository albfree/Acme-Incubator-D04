
package acme.features.authenticated.discussionForum;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.discussionForums.DiscussionForum;
import acme.entities.roles.Entrepreneur;
import acme.entities.roles.Investor;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedDiscussionForumListMineService implements AbstractListService<Authenticated, DiscussionForum> {

	@Autowired
	AuthenticatedDiscussionForumRepository discussionForumRepository;


	@Override
	public boolean authorise(final Request<DiscussionForum> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<DiscussionForum> request, final DiscussionForum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment");
	}

	@Override
	public Collection<DiscussionForum> findMany(final Request<DiscussionForum> request) {
		assert request != null;

		Set<DiscussionForum> res;
		Principal principal;
		int id;

		principal = request.getPrincipal();
		res = new HashSet<DiscussionForum>();
		id = principal.getAccountId();

		if (principal.hasRole(Investor.class)) {
			res.addAll(this.discussionForumRepository.findManyByInvestorId(id));
		} else if (principal.hasRole(Entrepreneur.class)) {
			res.addAll(this.discussionForumRepository.findManyByEntrepreneurId(id));
		}

		return res;
	}

}
