package mongodb.onetoone.reference.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mongodb.onetoone.reference.model.Company;
import mongodb.onetoone.reference.model.Contact;
import mongodb.onetoone.reference.repository.CompanyRespository;
import mongodb.onetoone.reference.repository.ContactRepository;
import mongodb.onetoone.reference.service.SequenceGeneratorService;

@RestController
@RequestMapping("/rest")
public class OneToOneController {

	@Autowired
	private CompanyRespository companyRepo;
	
	@Autowired
	private ContactRepository contactRepo;
	
	@Autowired
	private SequenceGeneratorService sequenceGen;
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Company>> findAll()
	{
		Company com = new Company();
		
		com.setName("Amazon");
		com.setId(sequenceGen.generateSequence(Company.SEQUENCE_NAME));
		
		Contact c = new Contact();
		c.setId(sequenceGen.generateSequence(Contact.SEQUENCE_NAME));
		c.setAddress("Dharani Nagar");
		c.setPhoneNumber("9014427324");
		contactRepo.save(c);
		
		com.setContact(c);
		companyRepo.save(com);
		
		return new ResponseEntity<List<Company>>(companyRepo.findAll(),HttpStatus.OK);
	}
}
