package fstt.lsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import fstt.lsi.dao.PropertyRepository;
import fstt.lsi.entities.Property;
import lombok.extern.slf4j.Slf4j;

@Service

public class PropertyMetierImp implements PropertyMetier {
	
	@Autowired
	private PropertyRepository propertyRepository;
	

	@Override
	public Property saveProperty(Property c) {
		return propertyRepository.save(c);
	}
	
	@Override
	public List<Property> listProperty() {
		return propertyRepository.findAll();
	}

	@Override
	public List<Property> getPropertyByUser(Long userId){
		return propertyRepository.findAll();
	}

	@Override
	public List<Property> findPropertyByVerified() {
		return propertyRepository.findByVerified();
	}

	@Override
	public List<Property> findNonVerified() {
		return propertyRepository.findByVerified1();
	}

	@Override
	public List<Property> findSoldProducts() {
		return propertyRepository.findBySold();
	}

	@Override
	public List<Property> findNonSoldProducts() {
		return propertyRepository.findBySold1();
	}

	@Override
	public List<Property> findSoldByUserId(String id) {
		return propertyRepository.findSoldByUserId(id);
	}

	@Override
	public List<Property> findNonSoldByUserId(String id) {
		return propertyRepository.findNonSoldByUserId(id);
	}

	@Override
	public List<Property> findVerifiedByUserId(String id) {
		return propertyRepository.findVerifiedByUserId(id);
	}

	@Override
	public List<Property> findNonVerifiedByUserId(String id) {
		return propertyRepository.findNonVerifiedByUserId(id);
	}

	@Override
	public List<Property> findVerifiedAndNonSold() {
		return propertyRepository.findVerifiedAndNonSold();
	}
	
	
	

}
