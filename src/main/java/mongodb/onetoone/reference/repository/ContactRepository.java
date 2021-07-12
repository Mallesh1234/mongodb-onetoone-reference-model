package mongodb.onetoone.reference.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mongodb.onetoone.reference.model.Contact;

public interface ContactRepository extends MongoRepository<Contact, Integer> {

}
