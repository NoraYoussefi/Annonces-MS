
package fstt.lsi.metier;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;

//import fstt.lsi.RT.ResponseTemplate;
import fstt.lsi.entities.Property;



public interface PropertyMetier {
	public Property saveProperty(Property c);
	public List<Property> listProperty();
	public List<Property> getPropertyByUser(Long userId);
	
	public List<Property> findPropertyByVerified();
	
	public List<Property> findNonVerified();
	
	public List<Property> findSoldProducts();
	
	public List<Property> findNonSoldProducts();
	
	public List<Property> findSoldByUserId(String id);
	
	public List<Property> findNonSoldByUserId(String id);
	
	public List<Property> findVerifiedByUserId(String id);
	
	public List<Property> findNonVerifiedByUserId(String id);
	
	public List<Property> findVerifiedAndNonSold();
	
}
