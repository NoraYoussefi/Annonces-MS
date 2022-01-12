package fstt.lsi.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fstt.lsi.entities.Transaction;
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
	Transaction add(Transaction transaction);
	List<Transaction> findAll();
	//List<Transaction> findAllById(String transactionId);
}
//add + getall