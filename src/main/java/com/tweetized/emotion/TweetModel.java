/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tweetized.emotion;

import java.beans.*;
import java.io.Serializable;
import java.util.List;


public class TweetModel implements Serializable {
    
  private String emotion;
  private String tweet;
  private List<KnowledgeModel> knowledge;

    /**
     * @return the emotion
     */
    public String getEmotionProperty() {
        return emotion;
    }
public String getEmotion() {
        return emotion;
    }
    /**
     * @param emotion the emotion to set
     */
    public void setEmotionProperty(String emotion) {
        this.emotion = emotion;
    }

    /**
     * @return the tweet
     */
    public String getTweetProperty() {
        return tweet;
    }
public String getTweet() {
        return tweet;
    }

    /**
     * @param tweet the tweet to set
     */
    public void setTweetProperty(String tweet) {
        this.tweet = tweet;
    }

    /**
     * @return the knowledge
     */
     public List<KnowledgeModel> getKnowledge() {
        return knowledge;
    }
    public List<KnowledgeModel> getKnowledgeProperty() {
        return knowledge;
    }

    /**
     * @param knowledge the knowledge to set
     */
    public void setKnowledgeProperty(List<KnowledgeModel> knowledge) {
        this.knowledge = knowledge;
    }
    
}
