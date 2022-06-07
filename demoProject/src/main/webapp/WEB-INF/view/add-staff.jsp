<%--
  Created by IntelliJ IDEA.
  User: atmaramn
  Date: 3/6/2022
  Time: 12:25 AM
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
            <h1 class="text-center mb-3">Fill the staff details</h1>
            <form action="handle-staff?comp_id=${comp_id}&deptId=${deptId}" method="post">
                <div class="form-group">
                    <label for="name">Staff Name</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter staff name here"/>
                </div>
                <div class="form-group">
                    <label for="nric">Nric</label>
                    <input class="form-control" name="nric" id="nric" placeholder="Enter nric id here"></input>
                </div>
                <div class="form-group">
                <label>Gender</label>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="inlineRadio1" value="M">
                    <label class="form-check-label" for="inlineRadio1">Male</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="inlineRadio2" value="F">
                    <label class="form-check-label" for="inlineRadio2">Female</label>
                </div>
                </div>
                <div class="form-group">
                    <label for="jdate">Joining date</label>
                    <input type="date" placeholder="Enter joining date here" name="join_date" class="form-control" id="jdate">
                </div>
                <div class="form-group">
                    <label for="dobdate">DOB</label>
                    <input type="date" placeholder="Enter DOB here" name="dob" class="form-control" id="dobdate">
                </div>
                <div class="form-group">
                    <label for="sid">Supervisor Id</label>
                    <input class="form-control" name="supervisor_id" id="sid" placeholder="Enter supervisor id here"></input>
                </div>
                <div class="container text-center">
                    <a href="${pageContext.request.contextPath}/company/${comp_id}" class="btn btn-outline-danger">Back</a>
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>

            </form>
        </div>
        <div class="col-md-3"></div>
    </div>
</div>
</body>
</html>
