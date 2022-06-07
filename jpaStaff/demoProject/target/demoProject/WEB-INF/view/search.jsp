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
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <script src="<c:url value="/resources/js/staff.js"/>"></script>
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
                            <a href="department" class="nav-link" aria-current="page">
                                Department
                            </a>
                        </li>
                        <li class="nav-item text-center">
                            <a href="search" class="nav-link active" aria-current="page">
                                Staff
                            </a>
                        </li>
                    </ul>
                </div>
            </main>
        </div>
        <div class="col-8">
            <%--<div class="container">
            <div class="col-3"></div>--%>
            <div class="col-8">
                <table class="table table-borderless">
                    <form action="handle-staff" method="post">
                        <div class="text-center mt-2">
                            <h5>Fill the staff details</h5>
                        </div>
                        <tbody>
                        <tr>
                            <td>
                                <label for="name">Staff Name</label>
                            </td>
                            <td><input type="text" class="form-control" id="name" name="name" placeholder="Enter staff name here" required/></td>
                        </tr>
                        <tr>
                            <td>
                                <label for="nric">Nric</label></td>
                            <td>
                                <input class="form-control" name="nric" id="nric" placeholder="Enter nric id here" required></td>
                        </tr>
                        <tr>
                            <td>
                                <label>Gender</label>
                            </td>
                            <td>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="male" value="M">
                                    <label class="form-check-label" for="male">Male</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="female" value="F">
                                    <label class="form-check-label" for="female">Female</label>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="tel">Tel NO</label>
                            </td>
                            <td>
                                <input class="form-control" name="tel_hp" id="tel" placeholder="Enter tel no here" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="jdate">Joining date</label>
                            </td>
                            <td>
                                <input type="date" placeholder="Enter joining date here" name="join_date" class="form-control" id="jdate" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="dobdate">DOB</label>
                            </td>
                            <td>
                                <input type="date" placeholder="Enter DOB here" name="dob" class="form-control" id="dobdate" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="comp_id">Company</label>
                            </td>
                            <td>
                                <select class="form-control" name="comp_id" id="comp_id" onchange="onCompanyChange()">
                                    <option value="-1" selected>Select Company</option>
                                    <c:forEach items="${companies}" var="comp">
                                        <option value="${comp.comp_id}">${comp.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="dept_id">Department</label>
                            </td>
                            <td>
                                <select class="form-control" name="dept_id" id="dept_id">
                                    <option value="-1" selected>Select Department</option>
                                        <%--<option value="${dept.dept_id}">${dept.name}</option>--%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label for="sup_id">Supervisor Id</label>
                            </td>
                            <td>
                                <select class="form-control" name="supervisor_id" id="sup_id">
                                    <option value="-1">Select Supervisor</option>
                                    <c:forEach items="${staffs}" var="sup">
                                        <option value="${sup.staff_id}">${sup.name}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            </td>
                            <td>
                                <button type="submit" id="button" class="btn btn-primary">Add</button>
                            </td>
                        </tr>
                        </tbody>
                    </form>
                </table>
            </div>
           <%-- <div class="col-3"></div>
            </div>--%>
        </div>
    </div>
</div>
<div>
    <div class="container">
        <div class="row">
            <table class="table table-bordered" id="table">
                <div class="text-center mt-2">
                    <h5>Staffs</h5>
                </div>
                <thead class="text-center">
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">NRIC</th>
                    <th scope="col">GENDER</th>
                    <th scope="col">TEL HP</th>
                    <th scope="col">JOIN DATE</th>
                    <th scope="col">DOB</th>
                    <th scope="col">DEPTARTMENT</th>
                    <th scope="col">SUPERVISOR</th>
                    <th scope="col">ACTION</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${staffs}" var="staff">
                    <tr class="text-center">
                        <th scope="row">${staff.staff_id}</th>
                        <td>${staff.name}</td>
                        <td>${staff.nric}</td>
                        <td>${staff.gender}</td>
                        <td>${staff.tel_hp}</td>
                        <td><fmt:formatDate value="${staff.join_date}" pattern="yyyy-MM-dd" /></td>
                        <td><fmt:formatDate value="${staff.dob}" pattern="yyyy-MM-dd" /></td>
                        <td>${staff.dept_name}</td>
                        <td>${staff.sup_name}</td>
                        <td>
                            <button class="btn btn-link" onclick="editStaff(${staff.staff_id},${staff.comp_id})">Edit</button>
                            <button class="btn btn-link" onclick="removeStaff(${staff.staff_id})">Remove</button>
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