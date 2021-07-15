package mongodb.onetoone.reference;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import mongodb.onetoone.reference.model.Company;

class MongodbOnetomanyReferenceModelApplicationTests extends TestRoot{

	@Autowired
	private MockMvc mockmvc;
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	public void findAll()
	{
		try {
			String result = mockmvc.perform(get("/rest/findAll")).andDo(print()).andReturn().getResponse().getContentAsString();
			
			List<Company> list = this.mapper.readValue(result, List.class);
			
			assertTrue(list.size()>0);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertTrue(false);
		}
		
	}
	
}
