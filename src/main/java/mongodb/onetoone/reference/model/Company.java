package mongodb.onetoone.reference.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "company")
public class Company {

	@Transient
    public static final String SEQUENCE_NAME = "company_seq";
	@Id
	private Integer id;
	private String name;
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	@DBRef(lazy = false)
	private Contact contact;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
}
