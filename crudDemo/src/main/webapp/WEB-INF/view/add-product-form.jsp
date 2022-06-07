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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
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
                                <span class="fs-4 mx-1">Companies</span>
                            </a>
                        </div>
                        <hr>
                        <ul class="nav nav-pills flex-column mb-auto">
                            <li class="nav-item text-center">
                                <a href="company/${com.comp_id}" class="nav-link active" aria-current="page">
                                    ${com.name}
                                </a>
                            </li>
                            <li class="nav-item text-center">
                                <a href="company/${com.comp_id}" class="nav-link" aria-current="page">
                                    ${com.name}
                                </a>
                            </li>
                        </ul>
                    </div>
                </main>
            </div>
            <div class="col-8">
                <div class="container mt-4 mb-4 text-center">
                    <h5>Company Details</h5>
                </div>
                <hr />

                <div class="container">
                    <div class="row">
                        <table class="table table-bordered">
                            <div class="text-center mt-2">
                                <h5>Staff</h5>
                            </div>
                            <thead class="text-center">
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Gender</th>
                                    <th scope="col">Joining Date</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="text-center">
                                    <th scope="row">${st.staff_id}</th>
                                    <td>${st.name}</td>
                                    <td>${st.gender} </td>
                                    <td>${st.join_date}</td>
                                    <td>
                                        <a href="edit-staff/${st.staff_id}?comp_id=${company.comp_id}"><button
                                                class="btn btn-link">Edit</button></a>
                                        <a href="delete-staff/${st.staff_id}?comp_id=${company.comp_id}"><button
                                                class="btn btn-link">Remove</button></a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <hr />
            </div>
        </div>
    </div>
</body>

</html>