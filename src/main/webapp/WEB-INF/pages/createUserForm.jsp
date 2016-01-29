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
<div class="container">
    <h1>
        <div class="form-group">
            <form:form modelAttribute="user" class="form-horizontal">
                <input type="hidden" name="id" value="${user.id}"/>

                <div class="control-group" id="user">
                    <label class="control-label">Job Title </label>

                    <c:out value="${user.product.name} "/>
                </div>
            </form:form>
        </div>
    </h1>
    <form:form method="post" action="new" commandName="user" role="form">
        <div class="form-group">
            <form:label path="firstName">First Name:</form:label>
            <form:input path="firstName" class="form-control" placeholder="First Name"/>
            <form:errors path="firstName" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <form:label path="lastName">Last Name:</form:label>
            <form:input path="lastName" class="form-control" placeholder="Last Name"/>
        </div>
        <div class="form-group">
            <form:label path="email">Email:</form:label>
            <form:input path="email" class="form-control" placeholder="Email"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>
        <button type="submit" class="btn btn-default">Apply</button>

    </form:form>


</div>
</body>
</html>
