package fstt.lsi.dao;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import fstt.lsi.entities.Property;

@Repository
public interface PropertyRepository extends MongoRepository<Property, Long> {
	
	Property findByPropertyId(Long propertyId);
	List<Property> findAllByUserId(String id);
	
	@Query("{'verified' : true}")
	List<Property> findByVerified();
	
	@Query("{'verified' : false}")
	List<Property> findByVerified1();
	
	@Query("{'sold' : true}")
	List<Property> findBySold();
	
	@Query("{'sold' : false}")
	List<Property> findBySold1();
	
	@Query("{'sold' : true}")
	List<Property> findSoldByUserId(String id);
	
	@Query("{'sold' : false}")
	List<Property> findNonSoldByUserId(String id);
	
	@Query("{'verified' : true}")
	List<Property> findVerifiedByUserId(String id);
	
	@Query("{'verified' : false}")
	List<Property> findNonVerifiedByUserId(String id);
	
	
	@Query("{'verified' : true,'sold' : false}")
	List<Property> findVerifiedAndNonSold();
}
