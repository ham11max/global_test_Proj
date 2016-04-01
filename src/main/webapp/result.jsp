<%--
  Created by IntelliJ IDEA.
  User: HAMMAX
  Date: 30.03.2016
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
    <title>RESULT</title>
</head>
<body>
<div align="center">
  <font size="8"  face="Times New Roman">
    <a href="home.jsp" role="button"  class="btn btn-warning" >Go to main page</a>
  </font>
</div>

<h1 align="center">Result of Searching </h1>
<div align="center">
  <p class="bg-primary">${nameOfProduct} -> ${nameOfFile}</p>
<table class="table table-hover">
  <tr>
    <td align="center">
      <font size="8"  face="Times New Roman">
        <p class="bg-success" >Name of file</p>
      </font>
    </td>

    <td align="center">
      <font size="8"  face="Times New Roman">
        <p class="bg-success">File Entities</p>
      </font>
    </td>
  </tr>
<c:forEach items="${model}" var="model">

  <tr>
    <td align="center"><c:out value="${model.fileName}"/></td>
    <td align="center"><c:out value="${model.fileEntities}"/></td>
  </tr>
</c:forEach>
</table >
  <font size="8"  face="Times New Roman">
    <p class="bg-success">List of the Products by capital letter</p>
  </font>

<table class="table table-bordered">
  <c:forEach items="${values}" var="values">
    <tr>
      <td align="center"><c:out value="${values.letter}"/></td>
      <td align="center"><c:out value="${values.products}"/></td>
    </tr>
  </c:forEach>
</table>


</div>
</body>
</html>
