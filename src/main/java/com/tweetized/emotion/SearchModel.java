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
    
    
}
