package acme.features.inventor.chimpum;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.chimpum.Chimpum;
import acme.entities.inventions.Invention;
import acme.entities.inventions.InventionType;
import acme.entities.systemConfiguration.SystemConfiguration;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface InventorChimpumRepository extends AbstractRepository{
	
	@Query("SELECT c from Chimpum c")
	Collection<Chimpum> findChimpums();
	
	@Query("Select c from Chimpum c WHERE c.id = :chimpumId")
	Chimpum findOneChimpumById(int chimpumId);

	@Query("SELECT c FROM SystemConfiguration c")
	SystemConfiguration getSystemConfiguration();
	@Query("SELECT i FROM Invention i  WHERE i.inventionType = :type")
	Collection<Invention> findAllInventionsByType(InventionType type);
}
