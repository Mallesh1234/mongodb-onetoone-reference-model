package mongodb.onetoone.reference.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import mongodb.onetoone.reference.model.Company;

@Repository
public interface CompanyRespository extends MongoRepository<Company, Integer> {

}
