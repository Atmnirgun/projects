<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    <title><c:out value="${title}">Home</c:out></title>
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
                        <a href="add-company">
                            <button class="btn btn-link mx-3">Add Company</button>
                        </a>
                    </div>
                    <hr>
                    <ul class="nav nav-pills flex-column mb-auto">
                        <c:forEach items="${companies}" var="com">
                            <c:if test="${company!=null}">
                                <li class="nav-item text-center">
                                    <a href="company/${com.comp_id}" class="nav-link active" aria-current="page">
                                        ${com.name}
                                    </a>
                                </li>
                            </c:if>
                            <c:if test="${company == null}">
                                <li class="nav-item text-center">
                                    <a href="company/${com.comp_id}" class="nav-link" aria-current="page">
                                            ${com.name}
                                    </a>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </div>
            </main>
        </div>
        <div class="col-8">
            <c:if test="${company==null}">
                <div class="alert alert-primary d-flex align-items-center" role="alert">
                    <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Info:"><use xlink:href="#info-fill"/></svg>
                    <div>
                        Please select a company from left hand side.
                    </div>
                </div>
            </c:if>
            <c:if test="${company!=null}">
            <div class="container mt-4 mb-4 text-center">
                <h5>Company Details - ${company.name} </h5>
            </div>

            <div class="container justify-content-start mb-3">
                <div class="row">
                    <div class="d-flex col-md-12 text-right gap-2">
                        <h5 style="text-align:left">Company - ${company.name}</h5>
                        <a href="edit/${company.comp_id}"><button type="button" class="btn btn-link pt-0">Edit</button></a>
                        <c:if test="${departments.size()==0}"><a href="delete/${company.comp_id}"><button type="button" class="btn btn-link pt-0">Remove</button></a></c:if>
                        <a href="add-department?comp_id=${company.comp_id}"><button type="button" class="btn btn-link pt-0">Add Department</button></a>
                    </div>
                </div>
            </div>
            <hr/>

            <c:if test="${departments.size()>0}">
                <c:forEach items="${departments}" var="dep">
            <div class="container">
                <div class="row">
                    <div class="d-flex col-md-12 text-right gap-2 mt-3">
                        <h5 style="text-align:left">Department:${dep.name}</h5>
                        <a href="edit-department/${dep.dept_id}"><button type="button" class="btn btn-link pt-0">Edit</button></a>
                        <a href="delete-department/${dep.dept_id}?comp_id=${company.comp_id}"><button type="button" class="btn btn-link pt-0">Remove</button></a>
                        <a href="staff?comp_id=${company.comp_id}&deptId=${dep.dept_id}"><button type="button" class="btn btn-link pt-0">Add Staff</button></a>
                    </div>
                </div>
                <c:forEach items="${staffMap}" var="entry">
                    <c:if test="${(entry.key == dep.dept_id) and (entry.value.size()>0)}">
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
                                <c:forEach items="${entry.value}" var="st">
                                <tr class="text-center">
                                    <th scope="row">${st.staff_id}</th>
                                    <td>${st.name}</td>
                                    <td>${st.gender} </td>
                                    <td>${st.join_date}</td>
                                    <td>
                                        <a href="edit-staff/${st.staff_id}?comp_id=${company.comp_id}"><button class="btn btn-link">Edit</button></a>
                                        <a href="delete-staff/${st.staff_id}?comp_id=${company.comp_id}"><button class="btn btn-link">Remove</button></a>
                                    </td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </c:if>
                    <c:if test="${entry.value.size()==0}">
                        <h5 class="fw-lighter text-center">No staff found.</h5>
                    </c:if>
                </c:forEach>
            </div>
                    <hr/>
                    <c:if test="${departments.size()==0}">
                        <h5 class="fw-lighter text-center">No department found.</h5>
                    </c:if>
                </c:forEach>

            </c:if>
        </div>
    </div>
    </c:if>
    </div>
</div>
</body>
</html>
