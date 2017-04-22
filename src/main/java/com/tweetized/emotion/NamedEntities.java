/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tweetized.emotion;

import com.algorithmia.Algorithmia;
import com.algorithmia.AlgorithmiaClient;
import com.algorithmia.algo.AlgoResponse;
import org.json.JSONArray;

public class NamedEntities {
    public static  String apiKey="simP6TBi/cQXPmsTPkVFsATkbYi1";

public  String  NamedEntityRec( String tweet) throws Exception
    {
        AlgorithmiaClient client = Algorithmia.client(apiKey);
        com.algorithmia.algo.Algorithm algo = client.algo("algo://StanfordNLP/NamedEntityRecognition/0.2.0");
        AlgoResponse result;
        result = algo.pipe("{\"document\":\""+tweet+"\"}");
        String query="";
        System.out.println(result.asJsonString());
       JSONArray arr=new JSONArray(result.asJsonString());
       for (int i=0;i<arr.length();++i){
           JSONArray arr1=arr.getJSONArray(i);
            for (int i1=0;i1<arr1.length();++i1){
                JSONArray arr11=arr1.getJSONArray(i1);
                for (int i11=0;i11<arr11.length();++i11){
                    query=query+arr11.getString(i11)+" ";
                    System.out.println(arr11.getString(i11));
                    break;
                }
            }
       }
        return query;
    }
}
