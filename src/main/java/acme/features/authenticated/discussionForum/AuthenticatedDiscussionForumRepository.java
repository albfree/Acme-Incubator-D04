
package acme.features.authenticated.discussionForum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.discussionForums.DiscussionForum;
import acme.framework.entities.Authenticated;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedDiscussionForumRepository extends AbstractRepository {

	@Query("select df from DiscussionForum df where df.id=?1")
	DiscussionForum findOneById(int id);

	@Query("select df from DiscussionForum df where df.investmentRound.entrepreneur.userAccount.id = ?1")
	Collection<DiscussionForum> findManyByEntrepreneurId(int id);

	@Query("select df from DiscussionForum df where investmentRound.id = (select ap.investment.id from Application ap where ap.investor.userAccount.id = ?1 and ap.status = 'ACCEPTED')")
	Collection<DiscussionForum> findManyByInvestorId(int id);

	@Query("select a from Authenticated a where a.userAccount.id = ?1")
	Authenticated findMyself(int id);
}
