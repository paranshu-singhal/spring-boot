package TwitterCrawler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

@SpringBootApplication
public class TwitterCrawler implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(TwitterCrawler.class);
	
	@Autowired
	TweetMongoRepo repo;
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(TwitterCrawler.class, args);
	}
	

	public void run(String... args) throws Exception {
		
		repo.deleteAll();
		
		Twitter twitter = TwitterFactory.getSingleton();
	    Query query = new Query("#intern OR #internship");
	    query.geoCode(new GeoLocation(33.980736, -117.337367), 100.0, Query.MILES);
	    
	    List<Tweet> list = new ArrayList<Tweet>();
	    
	    try {
	    	
	    	QueryResult result;
	    	
	    	do {
	    		result = twitter.search(query);
			    for (Status tweet : result.getTweets()) {
			    	list.add(new Tweet(tweet));
			    }
			    
	    	} while((query = result.nextQuery()) != null);
	    	
	    	log.info(String.format("size of list %d", list.size()));
		    repo.insert(list);
	    	
	    } catch(Exception e) {
	    	
	    	e.printStackTrace();
	    }
			
	}
	    
		
}
