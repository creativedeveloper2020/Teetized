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
    </head>
    <body>
        <h1>Tweetized</h1>
        <form action="/Tweetized/Search">
            <input type="search" name="srch" value="<jsp:getProperty name="Tweets" property="searchWordProperty"/>" >
            <input type="submit"  name ="sub" value="Search">
        </form>
            <div>
                <p>
                    
                    <c:forEach var="tt" items="${Tweets.resultProperty}">
                    
                    <p> <c:catch>${tt.emotion}</c:catch></p>
                     <p> <c:catch>${tt.tweet}</c:catch></p>
                    </c:forEach>
                </p>
            </div>
    </body>
</html>
