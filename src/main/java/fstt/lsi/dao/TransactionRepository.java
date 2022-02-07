package fstt.lsi.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import fstt.lsi.entities.Transaction;
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

	List<Transaction> findAll();

	@Query("{$or :[{'buyerAddress' : ?0},{'sellerAddress' : ?0}] }")
	List<Transaction> findAllBybuyerAddress(String address);
	
	@Query("{'propertyId' : ?0")
	List<Transaction> findAllBypropertyId(long propertyId);
}