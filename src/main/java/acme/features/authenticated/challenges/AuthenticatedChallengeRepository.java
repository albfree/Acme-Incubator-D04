
package acme.features.authenticated.challenges;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.challenges.Challenge;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedChallengeRepository extends AbstractRepository {

	@Query("select c from Challenge c where c.id = ?1 and c.deadline > CURRENT_TIMESTAMP")
	Challenge findOneById(int id);

	@Query("select c from Challenge c where c.deadline > CURRENT_TIMESTAMP")
	Collection<Challenge> findManyAll();

}
