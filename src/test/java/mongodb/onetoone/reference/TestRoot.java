package mongodb.onetoone.reference;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MongodbOnetoOneReferenceModelApplication.class)
@AutoConfigureMockMvc
public class TestRoot {

	@Test
	void contextLoads() {
	}
}
