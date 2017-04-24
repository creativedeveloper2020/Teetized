/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tweetized.emotion;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Ahmad
 */
public class KnowledgeModel implements Serializable {
    
   private String title;
   private String url;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
 public String getTitleProperty() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
     public String getUrlProperty() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
}
