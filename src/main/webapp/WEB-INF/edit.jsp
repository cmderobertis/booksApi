<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Tacos</title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
  <script src="/webjars/jquery/jquery.min.js"></script>
  <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h2 class="text-center">Edit Book</h2>
<div class="row justify-content-center">
  <div class="col-8">
    <div class="card">
      <div class="card-body">
        <%--@elvariable id="book" type=""--%>
        <form:form action="/books/${book.id}" method="post" modelAttribute="book">
          <input type="hidden" name="_method" value="put">
          <p class="form-control d-flex flex-column">
            <form:label path="title">Title</form:label>
            <form:errors path="title" cssClass="text-danger"/>
            <form:input path="title"/>
          </p>
          <p class="form-control d-flex flex-column">
            <form:label path="description">Description</form:label>
            <form:errors path="description" cssClass="text-danger"/>
            <form:textarea path="description"/>
          </p>
          <p class="form-control d-flex flex-column">
            <form:label path="language">Language</form:label>
            <form:errors path="language" cssClass="text-danger"/>
            <form:input path="language"/>
          </p>
          <p class="form-control d-flex flex-column">
            <form:label path="numberOfPages">Pages</form:label>
            <form:errors path="numberOfPages" cssClass="text-danger"/>
            <form:input type="number" path="numberOfPages"/>
          </p>
          <input type="submit" value="Submit" class="btn btn-primary"/>
        </form:form>
      </div>
    </div>
  </div>
</div>
<a href="${pageContext.request.contextPath}/books">Back to books</a>
</body>
</html>
