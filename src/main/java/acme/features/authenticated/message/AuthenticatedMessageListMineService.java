
package acme.features.authenticated.message;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.discussionForums.DiscussionForum;
import acme.entities.messages.Message;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class AuthenticatedMessageListMineService implements AbstractListService<Authenticated, Message> {

	@Autowired
	AuthenticatedMessageRepository messageRepository;


	@Override
	public boolean authorise(final Request<Message> request) {
		assert request != null;
		Boolean res = true;
		Collection<Authenticated> participants;
		Authenticated myself;
		DiscussionForum forum;
		Principal principal;
		int accId;
		int dfId;

		dfId = request.getModel().getInteger("dfId");

		forum = this.messageRepository.findOneForumById(dfId);
		participants = forum.getParticipants();

		principal = request.getPrincipal();
		accId = principal.getAccountId();
		myself = this.messageRepository.findMyself(accId);

		boolean ImEntrepreneur = accId == forum.getInvestmentRound().getEntrepreneur().getUserAccount().getId();

		res = participants.contains(myself) || ImEntrepreneur;

		return res;
	}

	@Override
	public void unbind(final Request<Message> request, final Message entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "creationMoment", "tags");
	}

	@Override
	public Collection<Message> findMany(final Request<Message> request) {
		assert request != null;
		Collection<Message> res;
		int dfId;

		dfId = request.getModel().getInteger("dfId");
		res = this.messageRepository.findManyByForumId(dfId);

		return res;
	}

}
