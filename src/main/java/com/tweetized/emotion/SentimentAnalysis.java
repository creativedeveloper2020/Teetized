
package com.tweetized.emotion;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import twitter4j.conf.ConfigurationBuilder;

public class SentimentAnalysis {

    public static ConfigurationBuilder cb = new ConfigurationBuilder();
    public static StanfordCoreNLP pipeline;
    public static Properties properties = new Properties();
    
 

    public static void init() throws FileNotFoundException {
       Properties props;
    props = new Properties();
    props.put("annotators", "tokenize, ssplit, parse, sentiment");
    pipeline = new StanfordCoreNLP(props);
	}

    public static int findSentiment(String tweet) {

		int mainSentiment = 0;
		if (tweet != null && tweet.length() > 0) {
			int longest = 0;
			Annotation annotation = pipeline.process(tweet);
                        
			for (CoreMap sentence : annotation
					.get(CoreAnnotations.SentencesAnnotation.class)) {
				Tree tree = sentence
						.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
				int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
				String partText = sentence.toString();
				if (partText.length() > longest) {
					mainSentiment = sentiment;
					longest = partText.length();
				}

			}
		}
		return mainSentiment;
	}
  
    public static void main(String[] args) throws FileNotFoundException {
        String topic = "Happy day";
        String emotion="";
        ArrayList<String> tweets = TweetsAdapter.getTweets(topic);
        
        init();
	for(String tweet : tweets) {
            switch (findSentiment(tweet)) {
                case 0:
                    emotion="Very negative";
                    break;
                case 1:
                    emotion="Negative";
                    break;
                case 2:
                    emotion="Natural";
                    break;
                case 3:
                    emotion="Positive";
                    break;
                case 4:
                    emotion="Very positive";
                    break;
                default:
                    break;
            }
	    System.out.println(tweet + " : " + emotion);
	}
    }
    
}
