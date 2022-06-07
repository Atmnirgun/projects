<%--
  Created by IntelliJ IDEA.
  User: atmaramn
  Date: 3/7/2022
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
            integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
            integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
            crossorigin="anonymous"></script>
    <script src="<c:url value="/resources/js/company.js"/>"></script>
    <title>
        <c:out value="${title}">Home</c:out>
    </title>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col-4">
            <main>
                <div class="d-flex flex-column flex-shrink-0 p-3 bg-light" style="width: 280px;">
                    <div class="d-flex flex-row gap-5">
                        <a href="${pageContext.request.contextPath}/" class="text-decoration-none">
                            <span class="fs-4 mx-1">Staff Management</span>
                        </a>
                    </div>
                    <hr>
                    <ul class="nav nav-pills flex-column mb-auto">
                        <li class="nav-item text-center">
                            <a href="${pageContext.request.contextPath}/" class="nav-link active" aria-current="page">
                                Company
                            </a>
                        </li>
                        <li class="nav-item text-center">
                            <a href="department" class="nav-link" aria-current="page">
                                Department
                            </a>
                        </li>
                        <li class="nav-item text-center">
                            <a href="search" class="nav-link" aria-current="page">
                                Staff
                            </a>
                        </li>
                    </ul>
                </div>
            </main>
        </div>
        <div class="col-8">
            <div class="container">
                <table class="table table-borderless">
                    <form action="handle-company" method="post">
                        <div class="text-center mt-2">
                            <h5>Fill the company details</h5>
                        </div>
                        <tbody>
                        <tr>
                            <td>
                                <label for="name">Company Name</label>
                            </td>
                            <td><input type="text" class="form-control" id="name" name="name" placeholder="Enter company name here" required/></td>
                        </tr>
                        <tr>
                            <td>
                            <label for="country">Country</label>
                            </td>
                            <td>
                            <input class="form-control" name="country" id="country" placeholder="Enter country here" required />
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <label for="fdate">Foundation Date</label>
                            </td>
                            <td>
                            <input type="date" placeholder="Enter foundation date here" name="foundation_date" class="form-control" id="fdate" required>
                            </td>
                        </tr>

                            <td>
                            </td>
                            <td>
                                <button type="submit" id="button" onclick="displayAdd()" class="btn btn-primary">Add</button>
                            </td>
                        </tr>
                        </tbody>
                    </form>
                </table>
            </div>
            <hr />
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <table class="table table-bordered" id="table">
            <thead class="text-center">
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Country</th>
                <th scope="col">Foundation date</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${companies}" var="comp">
                <tr class="text-center">
                    <th scope="row">${comp.comp_id}</th>
                    <td>${comp.name}</td>
                    <td>${comp.country} </td>
                    <td><fmt:formatDate value="${comp.foundation_date}" pattern="yyyy-MM-dd" /></td>
                    <td>
                        <button class="btn btn-link" onclick="editCompany(${comp.comp_id})">Edit</button>


                        <button class="btn btn-link" id="remove" onclick="removeCompany(${comp.comp_id})">Remove</button>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8"
        src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script>
    $(document).ready( function () {
        $('#table').DataTable();
    } );
</script>
</body>
</html>