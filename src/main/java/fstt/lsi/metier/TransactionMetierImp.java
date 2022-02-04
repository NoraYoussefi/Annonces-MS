
package fstt.lsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fstt.lsi.dao.TransactionRepository;
import fstt.lsi.entities.Transaction;
@Service
public class TransactionMetierImp implements TransactionMetier{

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Transaction saveTransaction(Transaction t) {
	
		return transactionRepository.save(t);
	}

	@Override
	public List<Transaction> listAllTransactions() {
	
		return transactionRepository.findAll();
	}


	@Override
	public List<Transaction> getTransactionByUser(Long userId) {
	
		return transactionRepository.findAll();
	}

}
