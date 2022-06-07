<%--
  Created by IntelliJ IDEA.
  User: atmaramn
  Date: 3/6/2022
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <title><c:out value="${title}">Home</c:out></title>
</head>
<body>
<div class="container mt-3">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <h1 class="text-center mb-3">Fill the Company details</h1>
            <form action="edit-company?comp_id=${company.comp_id}" method="post">
                <div class="form-group">
                    <label for="name">Company Name</label>
                    <input type="text" class="form-control" id="name" name="name" value="${company.name}" placeholder="Enter Company name here"/>
                </div>
                <div class="form-group">
                    <label for="country">Country</label>
                    <input class="form-control" name="country" id="country" value="${company.country}" placeholder="Enter country here" />
                </div>
                <%--<div class="form-group">
                    <label for="fdate">Foundation Date</label>
                    <input type="date" placeholder="Enter foundation date here" name="foundation_date" class="form-control" id="fdate">
                </div>--%>
                <div class="container text-center">
                    <a href="${pageContext.request.contextPath}/company/${company.comp_id}" class="btn btn-outline-danger">Back</a>
                    <button type="submit" class="btn btn-primary">Update</button>
                </div>
            </form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</body>
</html>
