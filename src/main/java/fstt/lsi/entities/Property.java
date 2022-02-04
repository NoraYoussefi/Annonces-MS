package fstt.lsi.entities;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;


@Data
@Document(collection = "properties")
public class Property {
	@Id
	private long propertyId;
	private String title;
	private String image;
	private String description;
	//private String legalDoc;
	//private String pkReciever;
	//private String govTitle;
	//private Boolean verified;
	private String address;
	private double price;
	private String userId;
	private Category myType;
	private Methode myMethod;
	

}
