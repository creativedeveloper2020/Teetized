package com.tweetized.emotion;

import java.io.Serializable;
import java.util.List;

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

    private int count;
    public int getCountProperty() {
        return count;
    }
    public void setCountProperty(int count) {
        this.count = count;
    }

    private int VPositiveCount;
    public int getVPositiveCountProperty() {
        return VPositiveCount;
    }
    public void setVPositiveCountProperty(int VPositiveCount) {
        this.VPositiveCount = VPositiveCount;
    }

    private int PositiveCount;
    public int getPositiveCountProperty() {
        return PositiveCount;
    }
    public void setPositiveCountProperty(int PositiveCount) {
        this.PositiveCount = PositiveCount;
    }

    private int NaturalCount;
    public int getNaturalCountProperty() {
        return NaturalCount;
    }
    public void setNaturalCountProperty(int NaturalCount) {
        this.NaturalCount = NaturalCount;
    }

    private int NegativeCount;
    public int getNegativeCountProperty() {
        return NegativeCount;
    }
    public void setNegativeCountProperty(int NegativeCount) {
        this.NegativeCount = NegativeCount;
    }

    private int VNegativeCount;
    public int getVNegativeCountProperty() {
        return VNegativeCount;
    }
    public void setVNegativeCountProperty(int VNegativeCount) {
        this.VNegativeCount = VNegativeCount;
    }
  
    
}
