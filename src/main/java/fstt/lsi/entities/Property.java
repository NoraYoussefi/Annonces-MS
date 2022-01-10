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
	private String address;
	private double price;
	private String userId;
	private Type myType;
	private Methode myMethod;
	
//	private Collection<String> method = 
//		    new ArrayList<String>(Arrays.asList(new String[] {
//		    		"private",
//		    	    "public",
//		    	     }));
//	private Collection<String> type = 
//		    new ArrayList<String>(Arrays.asList(new String[] {
//		    		"land",
//		    	    "house",
//		    	    "appartement",
//		    	    "immeuble",
//		    	    "commercial listing" }));

}
