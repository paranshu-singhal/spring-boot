package springjpa;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

import com.mongodb.DuplicateKeyException;

import springjpa.entity.User;
import springjpa.repository.UserMongoRepository;

@SpringBootApplication
public class AccessingDataJpaApplication implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SpringApplication.run(AccessingDataJpaApplication.class, args);
		
	}
	
	@Autowired
	UserMongoRepository repository;

	public void run(String... args) throws Exception {
		repository.deleteAll();
		// TODO Auto-generated method stub
//		log.info(userRepository.findAll().toString());
//		
//		log.info(userRepository.findById(1).toString());
		try {
			List<User> list= new ArrayList<User>();
			list.add(new User("Paranshu singhal", "switch.cfl@gmail.com"));
			list.add(new User("soumya bhatnagar", "soumya11207@gmail.com"));
			list.add(new User("shreya sharma", "mkshreya7@gmail.com"));
			list.add(new User("kartikay gupta", "kartikay_gupta@gmail.com"));
			log.info(repository.insert(list).toString());
			//log.info("Storing data in mongodb: " + repository.save(new User("paranshu singhal", "paranshu.singhal@gmail.com")).toString());
			
		} catch(Exception e) {
			log.info("Key already exists");
			
		} finally {
			log.info("Retreiving data from mongodb: " + repository.findAll().toString());
		}
		
	}
	
	

}
