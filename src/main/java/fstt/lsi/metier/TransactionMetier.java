package fstt.lsi.metier;

import java.util.List;

import org.springframework.stereotype.Service;

import fstt.lsi.entities.Transaction;


public interface TransactionMetier {
	
	public Transaction saveTransaction(Transaction t);
	public List<Transaction> listAllTransactions();
	public List<Transaction> getTransactionByUser(String address);


}