package springjpa.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import springjpa.entity.User;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String>{
	
	Iterable<User> findAllById(Iterable<String> ids);
	
	
}
