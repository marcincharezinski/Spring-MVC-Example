<!doctype html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
            <div class="container">
                <form:form action="products/add" method="get"><input type="submit"
                                                                     class="btn btn-primary btn-xs pull-right"
                                                                     value="Post a new job offer"/>
                </form:form>
            </div>
            <h1>Jobs</h1>
            <p>All the available jobs in our application</p>

        </div>
    </div>
</section>
<div class="container">
    <blockquote>
        <h1><p class="lead">Backend jobs</p></h1>
    </blockquote>

    <c:if test="${!empty products}">

        <section class="container">
            <div class="row">
                <c:forEach items="${products}" var="product">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${product.name}</h3>
                                <p>
                                    <a
                                            href=" <spring:url value="products/${product.id}/user/new.html" /> "
                                            class="btn btn-primary">Apply
                                    </a>
                                </p>

                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>
    </c:if>
</div>
<div class="container">
    <blockquote>
        <h1><p class="lead">Frontend jobs</p></h1>
    </blockquote>
</div>
<div class="container">
    <blockquote>
        <h1><p class="lead">Mobile jobs</p></h1>
    </blockquote>
</div>
</body>
</html>
