package com.tweetized.Controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.tweetized.emotion.GoogleKnowledgeGraph;
import com.tweetized.emotion.NamedEntities;
import com.tweetized.emotion.SearchModel;
import com.tweetized.emotion.SentimentAnalysis;
import com.tweetized.emotion.TweetModel;
import com.tweetized.emotion.TweetsAdapter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ahmad
 */
@WebServlet(urlPatterns = {"/Search"}, initParams = {
    @WebInitParam(name = "srch", value = "")})
public class SearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         
        List<TweetModel> res=new ArrayList<>();
        TweetsAdapter adapter=new TweetsAdapter();
        List<String> tweets= adapter.getTweets(request.getParameter("srch"));
        SentimentAnalysis analyzer=new SentimentAnalysis();
        NamedEntities ner=new NamedEntities();
        GoogleKnowledgeGraph gng=new GoogleKnowledgeGraph();
        for(String tweet:tweets){
            try {
                TweetModel tweetModel=new TweetModel();
                tweetModel.setTweetProperty(tweet);
                tweetModel.setEmotionProperty(analyzer.GetEmotion(tweet));
                tweetModel.setKnowledgeProperty(gng.GetKnowledge(ner.NamedEntityRec(tweet)));
                res.add(tweetModel);
            } catch (Exception ex) {
                Logger.getLogger(SearchModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        SearchModel sm=new SearchModel();
        sm.setResultProperty(res);
        sm.setSearchWordProperty(request.getParameter("srch"));
       request.setAttribute("Tweets", sm);
    RequestDispatcher  disp=request.getRequestDispatcher("/newjsp.jsp");
    disp.forward(request, response);
    
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
