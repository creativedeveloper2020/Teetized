/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tweetized.emotion;

import java.beans.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmad
 */
public class SearchModel implements Serializable {
    
  
    
    public SearchModel() {
      SearchWord="";
    }
    String SearchWord;
    public String getSearchWordProperty() {
        return SearchWord;
    }
    
    public void setSearchWordProperty(String value) {
        if (value!=null)
       SearchWord=value;
    }
     List<TweetModel> result;
      public void setResultProperty(List<TweetModel> value) {
        if (value!=null)
       result=value;
      }
       public List<TweetModel> getResultProperty() {
       return result ;
    }
  
    
}
