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
	private String images;
	private String desc;
	private String legaldocs;
	private String publicKey;
	private String govTitle;
	private Boolean verified=false;
	private Boolean sold=false;
	private String physcial_address;
	private double priceusd;
	private String userId;
	private Category category;
	private Methode method;
	

}
