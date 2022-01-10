
package fstt.lsi.metier;

import java.util.List;

//import fstt.lsi.RT.ResponseTemplate;
import fstt.lsi.entities.Property;



public interface PropertyMetier {
	public Property saveProperty(Property c);
	public List<Property> listProperty();
//	public List<Property> listOwnerProperty();
//	public ResponseTemplate getPropertyByUser(Integer userId);
	//public ResponseTemplate getPropertyByUser(long propertyId);
//	public ResponseTemplate getPropertyByUser(Long userId);
	public List<Property> getPropertyByUser(Long userId);
	


}
