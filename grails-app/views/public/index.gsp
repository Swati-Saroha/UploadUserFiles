<%--
  Created by IntelliJ IDEA.
  User: ongraph
  Date: 10/09/19
  Time: 3:56 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Upload Files</title>
    <asset:stylesheet href="bootstrap.css"/>
    <asset:stylesheet href="bootstrap.js"/>
</head>

<body>
<g:uploadForm controller="public" action="uploadFeaturedImage">
    <div class="container mt-3">
        <input type="file" name="myFile" id="file">
        <input type="submit" value="Submit">
    </div>
</g:uploadForm>
</body>
</html>