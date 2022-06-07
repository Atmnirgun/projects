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
    <script src="<c:url value="/resources/js/department.js" />"></script>
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
                            <a href="${pageContext.request.contextPath}/" class="nav-link" aria-current="page">
                                Company
                            </a>
                        </li>
                        <li class="nav-item text-center">
                            <a href="department" class="nav-link active" aria-current="page">
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
            <table class="table table-borderless">
                <form id="form" action="handle-department" method="post">
                    <div class="text-center mt-2">
                        <h5>Fill the department details</h5>
                    </div>
                    <tbody>
                    <tr>
                        <td>
                            <label for="name">Department Name</label>
                        </td>
                        <td>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Enter department name here" required/></td>
                    </tr>
                    <tr>
                        <td>
                            <label for="comp_id">Company</label>
                        </td>
                        <td>
                            <select class="form-control" name="comp_id" id="comp_id">
                                <option value="-1">Select Company</option>
                                <c:forEach items="${companies}" var="comp">
                                <option value="${comp.comp_id}">${comp.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
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
    </div>
</div>
<div>
    <div class="container">
        <div class="row">
            <table class="table table-bordered" id="table">
                <thead class="text-center">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Company</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${departments}" var="dep">
                    <tr class="text-center">
                        <th scope="row">${dep.dept_id}</th>
                        <td>${dep.name}</td>
                        <td>${dep.comp_name}</td>
                        <td>
                            <button class="btn btn-link" onclick="editDept(${dep.dept_id})">Edit</button>
                            <button class="btn btn-link" onclick="removeDept(${dep.dept_id})">Remove</button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
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