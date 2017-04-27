package com.tweetized.emotion;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TweetsAdapter {

    public static  String apiKey="simP6TBi/cQXPmsTPkVFsATkbYi1";
    
       public  List<String> getTweets(String topic,int count) {
        
                ConfigurationBuilder cb = new ConfigurationBuilder();
                cb.setDebugEnabled(true)
                    .setOAuthConsumerKey("eHLKODQI77MY1Dc4yCdYkpVLi")            
                  .setOAuthConsumerSecret("6a9o58SbFKEvmLNY4IuEz7yOzqEjw9ue4gtu4Kftw2CFk6RRqt")             
                  .setOAuthAccessToken("836048635603320832-TkbA9jbQ4cNxWHBwg4Ie3J0iy33cbIi")            
                  .setOAuthAccessTokenSecret("HjBGNCJ6AOWzlcDjcEqpDs0m4G5lW5cyNvOYTstrcVCJv");                
     
                TwitterFactory tf = new TwitterFactory(cb.build());
                Twitter twitter = tf.getInstance();
		
		List<String> tweetList =new ArrayList<>();
                int i=0;
		try {
			Query query = new Query(topic);
			QueryResult result;
			do {
				result = twitter.search(query);
				List<Status> tweets = result.getTweets();
				for (Status tweet : tweets) {
                                        i=i+1;
					tweetList.add(tweet.getText());
                                     //    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
        if (i>count)break;
				}
                                 if (i>count)break;
			} while ((query = result.nextQuery()) != null);
                        System.out.println(i);
		} catch (TwitterException te) {
			System.out.println("Failed to search tweets: " + te.getMessage());
		}
		return tweetList;
	}    
}
