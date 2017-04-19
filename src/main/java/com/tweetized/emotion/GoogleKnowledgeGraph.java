/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tweetized.emotion;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import com.jayway.jsonpath.JsonPath;

//import com.jayway.jsonpath.JsonPath;
//import org.json.simple.*;
//import org.json.simple.parser.JSONParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GoogleKnowledgeGraph {
    public static Properties properties = new Properties();
   

     HttpTransport httpTransport = new NetHttpTransport();
      HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
      JSONParser parser = new JSONParser();
      GenericUrl url = new GenericUrl("https://kgsearch.googleapis.com/v1/entities:search");
    public GoogleKnowledgeGraph() throws FileNotFoundException, IOException{
         properties.load(new FileInputStream("kgsearch.properties"));
    }
    public void GetKnowledge(String query ){
        try {
      
     //GenericUrl url1=new GenericUrl("https://www.googleapis.com/customsearch/v1?q=lkm&key=AIzaSyBCcDOiAde66S_KD30AeF7SU2TGMsQ-RPU");
      url.put("query", query);
      url.put("key", properties.getProperty("API_KEY"));
      url.put("limit", "10");
      url.put("indent", "true");
      String u=url.getRawPath();
      HttpRequest request = requestFactory.buildGetRequest(url);
      
      HttpResponse httpResponse = request.execute();
      JSONObject response = (JSONObject) parser.parse(httpResponse.parseAsString());
      JSONArray elements = (JSONArray) response.get("itemListElement");
      for (Object element : elements) {
          System.out.println("Google Knowledge: ");
        System.out.println(JsonPath.read(element, "$.result.name").toString());
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    }
}
