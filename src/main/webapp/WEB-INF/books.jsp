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
  <h1 class="text-center">Check out these books!</h1>
  <div class="row justify-content-center">
    <div class="col-auto">
      <div class="card">
        <div class="card-body">
          <table class="table table-hover table-striped">
            <tr>
              <th>Title</th>
              <th>Description</th>
              <th>Language</th>
              <th># of Pages</th>
              <th>Actions</th>
            </tr>
            <c:forEach var="book" items="${books}">
              <tr>
                <td><a href="/books/${book.id}"><c:out value="${book.title}"/></a></td>
                <td><c:out value="${book.description}"/></td>
                <td><c:out value="${book.language}"/></td>
                <td><c:out value="${book.numberOfPages}"/></td>
                <td>
                  <a href="/books/${book.id}/edit">Edit</a>
                  <form action="/books/${book.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete" class="btn btn-danger">
                  </form>
                </td>
              </tr>
            </c:forEach>
          </table>
          <a href="/books/new">Add Book</a>
        </div>
      </div>
    </div>
  </div>
</body>
</html>

