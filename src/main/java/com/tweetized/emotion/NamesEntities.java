/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tweetized.emotion;

import com.algorithmia.Algorithmia;
import com.algorithmia.AlgorithmiaClient;
import com.algorithmia.algo.AlgoResponse;

/**
 *
 * @author Ahmad
 */
public class NamesEntities {
    public static final String apiKey="simP6TBi/cQXPmsTPkVFsATkbYi1";

public static String NamedEntityRec( String tweet) throws Exception
    {
        AlgorithmiaClient client = Algorithmia.client(apiKey);
        com.algorithmia.algo.Algorithm algo = client.algo("algo://StanfordNLP/NamedEntityRecognition/0.2.0");
        AlgoResponse result;
        result = algo.pipe(tweet);
        return (result.asJsonString());
    }
}
