
package com.tweetized.emotion;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import java.io.FileNotFoundException;
import java.util.Properties;
import twitter4j.conf.ConfigurationBuilder;

public class SentimentAnalysis {

    public static ConfigurationBuilder cb = new ConfigurationBuilder();
    public  StanfordCoreNLP pipeline;
    
    public SentimentAnalysis() throws FileNotFoundException {
       Properties props;
    props = new Properties();
    props.put("annotators", "tokenize, ssplit, parse, sentiment");
    pipeline = new StanfordCoreNLP(props);
    
      
	}

    public  String GetEmotion(String tweet) {

		int mainSentiment = -1;
                String emotion;
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
                 switch (mainSentiment) {
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
                    emotion="N/A";
                    break;
            }
		return emotion;
	}
  
}
