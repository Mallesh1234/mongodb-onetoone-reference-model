package mongodb.onetoone.reference.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Document(collation = "company")
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
	
}
