package TwitterCrawler;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TweetMongoRepo extends MongoRepository<Tweet, String>{
	
	<S extends Tweet> List<S> insert(Iterable<S> entities);

}
