package fstt.lsi.services;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fstt.lsi.feign.userFeign;
import fstt.lsi.dao.PropertyRepository;
//import fstt.lsi.RT.ResponseTemplate;
import fstt.lsi.entities.Property;
import fstt.lsi.metier.PropertyMetier;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/annonces")
//@RequiredArgsConstructor
public class AnnonceController {
	@Autowired
	private userFeign userfeign;
	
	static Long i=(long) 1;
	
	@Autowired
	private PropertyMetier propertyMetier;
	
	@Autowired
	private PropertyRepository propertyRepository;
	

	@PostMapping("/ajouter")
	public Property saveProperty(@RequestBody Property property, HttpServletRequest request) {
		String id = userfeign.getUserId(request.getHeader("Authorization"));
		property.setUserId(id);
		property.setPropertyId(i++);
		 return propertyMetier.saveProperty(property);
		//return userfeign.getUserId(request.getHeader("Authorization"));
	}

	@GetMapping("/consulterById")
	public List<Property> showPropertyListByUserId(HttpServletRequest request) {
		String id = userfeign.getUserId(request.getHeader("Authorization"));
		return propertyRepository.findAllByUserId(id);
	}
	
	@GetMapping("/consulter")
	public List<Property> showAllProperties() {
		return propertyRepository.findAll();
	}

	 
}
