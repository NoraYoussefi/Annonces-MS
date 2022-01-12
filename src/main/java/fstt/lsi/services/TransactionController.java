package fstt.lsi.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fstt.lsi.dao.TransactionRepository;
import fstt.lsi.entities.Transaction;
import fstt.lsi.metier.TransactionMetier;


@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
//	@Autowired
//	private userFeign userfeign;
	
	@Autowired
	private TransactionMetier transactionMetier;
	
	

	@PostMapping("/addTransaction")
	public Transaction saveTransaction(@RequestBody Transaction transaction) {
		 return transactionMetier.saveTransaction(transaction);
	}
//	@GetMapping("/consulterById")
//	public List<Transaction> showPropertyListByUserId(String transactionId) {
//		return transactionRepository.findAllById(transactionId);
//	}
	
	@GetMapping("/consulter")
	public List<Transaction> showAllProperties() {
		return transactionRepository.findAll();
	}


}
