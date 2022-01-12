package fstt.lsi.metier;

import java.util.List;

import fstt.lsi.entities.Transaction;



public interface TransactionMetier {
	public Transaction saveTransaction(Transaction c);
	public List<Transaction> listAllTransactions();
	public List<Transaction> getTransactionByUser(Long userId);
	

}
