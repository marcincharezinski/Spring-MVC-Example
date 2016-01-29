<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="utf-8">
    <title>Spring MVC Application</title>

    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
</head>

<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">logout</a>
            <h1>Jobs</h1>
            <p>All the available jobs in our application</p>
        </div>

    </div>
</section>
<div class="container">
    <h1>Post a new job offer</h1>
    <form:form method="post" action="add" commandName="product" role="form">
        <div class="form-group">
            <form:label path="name">Title:</form:label>
            <form:input path="name" class="form-control" placeholder="Job title"/>
            <form:errors path="name" cssClass="text-danger"/>
        </div>
        <button type="submit" class="btn btn-default">Add</button>
    </form:form>

</div>
</body>
</html>
