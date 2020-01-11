package TwitterCrawler;

import java.util.Date;

import org.springframework.data.annotation.Id;

import twitter4j.GeoLocation;
import twitter4j.HashtagEntity;
import twitter4j.Place;
import twitter4j.Status;
import twitter4j.User;

public class Tweet {
	
	Date createdAt;
	@Id Long id;
	String text;
	String source;
	GeoLocation geoLocation;
	Place place;
	HashtagEntity[] hashtagEntities;
	User user;
	String lang;
	
	Tweet(Status status){
		this.createdAt = status.getCreatedAt();
		this.id = status.getId();
		this.text = status.getText();
		this.source = status.getSource();
		this.geoLocation = status.getGeoLocation();
		this.place = status.getPlace();
		this.hashtagEntities = status.getHashtagEntities();
		this.user = status.getUser();
		this.lang = status.getLang();
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public GeoLocation getGeoLocation() {
		return geoLocation;
	}

	public void setGeoLocation(GeoLocation geoLocation) {
		this.geoLocation = geoLocation;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public HashtagEntity[] getHashtagEntities() {
		return hashtagEntities;
	}

	public void setHashtagEntities(HashtagEntity[] hashtagEntities) {
		this.hashtagEntities = hashtagEntities;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}
	
	
	
	
}
