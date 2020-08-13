
package acme.features.authenticated.discussionForum;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.discussionForums.DiscussionForum;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class AuthenticatedDiscussionForumShowService implements AbstractShowService<Authenticated, DiscussionForum> {

	@Autowired
	AuthenticatedDiscussionForumRepository discussionForumRepository;


	@Override
	public boolean authorise(final Request<DiscussionForum> request) {
		assert request != null;
		Boolean res = true;
		Collection<Authenticated> participants;
		Authenticated myself;
		Principal principal;
		DiscussionForum forum;
		int id;
		int accId;

		principal = request.getPrincipal();
		accId = principal.getAccountId();
		id = request.getModel().getInteger("id");
		forum = this.discussionForumRepository.findOneById(id);
		participants = forum.getParticipants();
		myself = this.discussionForumRepository.findMyself(accId);

		boolean ImEntrepreneur = accId == forum.getInvestmentRound().getEntrepreneur().getUserAccount().getId();

		res = participants.contains(myself) || ImEntrepreneur;

		return res;
	}

	@Override
	public void unbind(final Request<DiscussionForum> request, final DiscussionForum entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "investmentRound", "participants");
	}

	@Override
	public DiscussionForum findOne(final Request<DiscussionForum> request) {
		assert request != null;

		DiscussionForum res;
		int id;

		id = request.getModel().getInteger("id");
		res = this.discussionForumRepository.findOneById(id);

		return res;
	}

}
