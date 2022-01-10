package fstt.lsi.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import fstt.lsi.RT.ResponseTemplate;
import fstt.lsi.RT.User;
import fstt.lsi.dao.PropertyRepository;
import fstt.lsi.entities.Property;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PropertyMetierImp implements PropertyMetier {
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	    //RestTemplate
//	@Autowired
//	public RestTemplate restTemplate;

	@Override
	public Property saveProperty(Property c) {
		// TODO Auto-generated method stub
		return propertyRepository.save(c);
	}
	
	@Override
	public List<Property> listProperty() {
		// TODO Auto-generated method stub
		return propertyRepository.findAll();
	}
//	@Override
//	public List<Property> listOwnerProperty(){
//		return propertyRepository.findB();
//	}
//	@Override
//	public ResponseTemplate getPropertyByUser(Long propertyId) {
//        //log.info("Inside getUserWithDepartment of UserService");
//        ResponseTemplate vo = new ResponseTemplate();
//        Property property = propertyRepository.findByPropertyId(propertyId);
//
//        User user =
//                restTemplate.getForObject("http://localhost:9191/annonces/" + property.getUserId()
//                        ,User.class);
//
//        vo.setProperty(property);
//        vo.setUser(user);
//
//        return  vo;
//    }
	@Override
	public List<Property> getPropertyByUser(Long userId){
	
		
		
		return propertyRepository.findAll();
		
	}

}
