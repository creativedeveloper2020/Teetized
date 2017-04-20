<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="newbean" class="com.tweetized.emotion.SearchModel"/>
<jsp:setProperty name="newbean" property="searchWordProperty" value="<%=request.getParameter("srch")%>"></jsp:setProperty>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Tweetized</h1>
        <form action="newjsp.jsp">
            <input type="search" name="srch" value="<jsp:getProperty name="newbean" property="searchWordProperty"/>" >
            <input type="submit" value="Search">
        </form>
    </body>
</html>
