package fstt.lsi.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fstt.lsi.dao.TransactionRepository;
import fstt.lsi.entities.Transaction;
import fstt.lsi.feign.userFeign;
import fstt.lsi.metier.TransactionMetier;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private userFeign userfeign;
	
	@Autowired
	private TransactionMetier transactionMetier;
	
	

	@PostMapping("/addTransaction")
	public Transaction saveTransaction(@RequestBody Transaction transaction) {
		 return transactionMetier.saveTransaction(transaction);
	}
	
	@GetMapping("/consulterById")
	public List<Transaction> showTransactionListByUserId(HttpServletRequest request) {
		String id = userfeign.getUserId(request.getHeader("Authorization"));
		return transactionMetier.getTransactionByUser(id);
	}
	
	@GetMapping("/consulterId")
	public String showTransactionUserId(HttpServletRequest request) {
		String id = userfeign.getUserId(request.getHeader("Authorization"));
		return id;
	}
	
	
	@GetMapping("/consulter")
	public List<Transaction> showAllProperties() {
		return transactionRepository.findAll();
	}


}