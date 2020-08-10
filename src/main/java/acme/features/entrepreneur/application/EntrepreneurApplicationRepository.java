
package acme.features.entrepreneur.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.id= ?1 and a.investment.entrepreneur.id= ?2")
	Application findOneApplicationById(int applicationID, int entrepreneurID);

	@Query("select a from Application a where a.investment.entrepreneur.id= ?1")
	Collection<Application> findApplicationsToMyInvestmentRounds(int id);

}