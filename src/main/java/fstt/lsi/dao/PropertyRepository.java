package fstt.lsi.dao;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fstt.lsi.RT.User;
import fstt.lsi.entities.Property;

@Repository
public interface PropertyRepository extends MongoRepository<Property, Long> {
	Property findByPropertyId(Long propertyId);
	List<Property> findAllByUserId(String id);
}
