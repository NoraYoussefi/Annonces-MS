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

}
