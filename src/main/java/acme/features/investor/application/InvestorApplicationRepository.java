
package acme.features.investor.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InvestorApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.id= ?1 and a.investor.id= ?2")
	Application findOneApplicationById(int applicationID, int investorID);

	@Query("select a from Application a where a.investor.id= ?1")
	Collection<Application> findMyApplications(int id);

}
