<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.tweetized.emotion.KnowledgeModel"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.tweetized.emotion.TweetModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="Tweets" type="com.tweetized.emotion.SearchModel" scope="request"/>
<jsp:setProperty name="Tweets" property="searchWordProperty" value="<%=request.getParameter("srch")%>"></jsp:setProperty>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="CSS/chart.css" type="text/css"/>
        <link rel="stylesheet" href="CSS/site2.css" type="text/css">
    </head>
    <body style="text-justify: auto ;padding: 20%;padding-top: 0px">
        <h1 style="text-align: center">Tweetized</h1>
        <form action="/Tweetized/Search" style="text-align: center">
            <input type="text" name="srch" value="<jsp:getProperty name="Tweets" property="searchWordProperty"/>" >
            <input type="submit"  name ="sub" value="Search">
            <p><input type="number" name="cnt" value="<jsp:getProperty name="Tweets" property="countProperty"/>" ></p>
        </form>
<div >
                <p>
                    
                    <c:forEach var="tt" items="${Tweets.resultProperty}">
                    <div style="background-color: lightsteelblue; margin: 10px ;padding: 10px;border-radius: 25px;" >
                    <p > 
                        <c:if test="${tt.emotion=='Very Positive'}"> 
                            <img src="/Tweetized/Happy.ico" style="width:30px;height:30px;" align="middle">
                             </c:if>
                            <c:if test="${tt.emotion=='Positive'}"> 
                            <img src="/Tweetized/Happy.ico" style="width:30px;height:30px;" align="middle">
                             </c:if>
                            <c:if test="${tt.emotion=='Negative'}"> 
                                <img src="/Tweetized/Sad.ico" style="width:30px;height:30px;" align="middle">
                             </c:if>
                            <c:if test="${tt.emotion=='Very Negative'}"> 
                                <img src="/Tweetized/Sad.ico" style="width:30px;height:30px;" align="middle">
                             </c:if>
                                <c:catch>${tt.emotion}</c:catch>
                            </p>
                   
                     <p> <c:catch>${tt.tweet}</c:catch></p>
                     <p>
                     <c:forEach var="gg" items="${tt.knowledge}" >
                         <a href="<c:catch>${gg.url}"</c:catch>> <c:catch>${gg.title}</c:catch></a>&nbsp;&nbsp;&nbsp;
                     </c:forEach>
                     </p>
                    </div>
                    </c:forEach>
                </p>
            </div>
        <div>
             <div id="wide"><ul class="chart">
  <li>
      <span style="height:${Tweets.VPositiveCountProperty*100/Tweets.countProperty}%" title="Very Positive ${Tweets.VPositiveCountProperty*100/Tweets.countProperty}%"></span>
  </li>
  <li>
      <span style="height:${Tweets.positiveCountProperty*100/Tweets.countProperty}%" title="Positive ${Tweets.positiveCountProperty*100/Tweets.countProperty}%"></span>
  </li>
  <li>
      <span style="height:${Tweets.naturalCountProperty*100/Tweets.countProperty}%" title="Natural ${Tweets.naturalCountProperty*100/Tweets.countProperty}%"></span>
  </li>
  <li>
      <span style="height:${Tweets.negativeCountProperty*100/Tweets.countProperty}%" title="Negative ${Tweets.negativeCountProperty*100/Tweets.countProperty}%"></span>
  </li>
   <li>
       <span style="height:${Tweets.VNegativeCountProperty*100/Tweets.countProperty}%" title="Very Negative ${Tweets.VNegativeCountProperty*100/Tweets.countProperty}%"></span>
  </li>
</ul>    </div>
            
        </div>
    </body>
</html>
