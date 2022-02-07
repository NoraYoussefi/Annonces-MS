package fstt.lsi.services;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fstt.lsi.feign.userFeign;
import fstt.lsi.dao.PropertyRepository;
//import fstt.lsi.RT.ResponseTemplate;
import fstt.lsi.entities.Property;
import fstt.lsi.metier.PropertyMetierImp;
import fstt.lsi.services.*;




import java.io.IOException;


import org.springframework.http.HttpStatus;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.web.multipart.MultipartFile;

import fstt.lsi.entities.LoadFile;





@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/annonces")
public class AnnonceController {
	@Autowired
	private userFeign userfeign;
	
	

	@Autowired
	private PropertyMetierImp propertyMetierI;
	
	@Autowired
	private PropertyRepository propertyRepository;
	

	@PostMapping("/ajouter")
	public Property saveProperty(@RequestBody Property property, HttpServletRequest request) {
		String id = userfeign.getUserId(request.getHeader("Authorization"));
		property.setUserId(id);
		return propertyMetierI.saveProperty(property);
	}
	
	
	@GetMapping("/product/{id}")
	public Property getPropertyById(@PathVariable("id") String propertyId ) {
		return propertyMetierI.getPropertyById(propertyId);
	}

	
	@GetMapping("/consulterById")
	public List<Property> showPropertyListByUserId(HttpServletRequest request) {
		String id = userfeign.getUserId(request.getHeader("Authorization"));
		return propertyRepository.findAllByUserId(id); //must be changed to metier
	}
	
	
	@GetMapping("/consulter")
	public List<Property> showAllProperties() {
		return propertyRepository.findAll();  //must be changed to metier
	}
	
	
	@GetMapping("/verified")
	public List<Property> getAllVerifiedProducts(){
		return propertyMetierI.findPropertyByVerified();
	}
	
	
	@GetMapping("/nonverified")
	public List<Property> getAllNonVerifiedProducts(){
		return propertyMetierI.findNonVerified();
	}
	
	
	@GetMapping("/sold")
	public List<Property> getSoldProducts(){
		return propertyMetierI.findSoldProducts();
	}
	
	
	@GetMapping("/nonsold")
	public List<Property> getNonSoldProducts(){
		return propertyMetierI.findNonSoldProducts();
	}
	
	
	@GetMapping("/usersold")
	public List<Property> findSoldByUserId(HttpServletRequest request) {
		String id = userfeign.getUserId(request.getHeader("Authorization"));
		return propertyMetierI.findSoldByUserId(id) ;//must be changed to metier
	}
	
	
	@GetMapping("/usernonsold")
	public List<Property> findNonSoldByUserId(HttpServletRequest request) {
		String id = userfeign.getUserId(request.getHeader("Authorization"));
		return propertyMetierI.findNonSoldByUserId(id) ;//must be changed to metier
	}
	
	
	@GetMapping("/userverified")
	public List<Property> findVerifiedByUserId(HttpServletRequest request) {
		String id = userfeign.getUserId(request.getHeader("Authorization"));
		return propertyMetierI.findVerifiedByUserId(id) ;//must be changed to metier
	}
	
	
	@GetMapping("/usernonverified")
	public List<Property> findNonVerifiedByUserId(HttpServletRequest request) {
		String id = userfeign.getUserId(request.getHeader("Authorization"));
		return propertyMetierI.findNonVerifiedByUserId(id) ;//must be changed to metier
	}
	
	
	@GetMapping("/explore")
	public List<Property> findVerifiedAndNonSold() {
		return propertyMetierI.findVerifiedAndNonSold();//must be changed to metier
	}
	
	
	@PostMapping("/validate/{id}")
	public Property validateProperty(@PathVariable("id") String propertyId) {
		Property prop=propertyMetierI.getPropertyById(propertyId);
		prop.setVerified(true);
		return propertyMetierI.saveProperty(prop);
	}
	
	
	@DeleteMapping("/reject/{id}")
	public void RejectProperty(@PathVariable("id") String propertyId) {
		propertyRepository.deleteById(propertyId);
	}
	
	
	@GetMapping("/explore/{id}")
	public List<Property> findVerifiedAndNonSoldByUserId(@PathVariable("id") String userId){
		return propertyMetierI.findVerifiedAndNonSoldByUserId(userId);
	}
	
	
	@PostMapping("/buy/{id}")
	public void buyProperty(@PathVariable("id") String propertyId) {
		Property prop=propertyMetierI.getPropertyById(propertyId);
		prop.setSold(true);
		propertyMetierI.saveProperty(prop);
	}
	
	
	
	
	
	@Autowired
    private FileController fileController;

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) throws IOException {
        return new ResponseEntity<>(fileController.addFile(file), HttpStatus.OK);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<ByteArrayResource> download(@PathVariable String id) throws IOException {
        LoadFile loadFile = fileController.downloadFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(loadFile.getFileType() ))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + loadFile.getFilename() + "\"")
                .body(new ByteArrayResource(loadFile.getFile()));
    }

	

	
	

	

	 
}
