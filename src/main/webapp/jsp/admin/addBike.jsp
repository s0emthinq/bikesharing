<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="property.text" var="textBundle" scope="session"/>

    <fmt:message bundle="${textBundle}" key="label.value.latitude" var="latitude"/>
    <fmt:message bundle="${textBundle}" key="label.value.longitude" var="longitude"/>
    <fmt:message bundle="${textBundle}" key="label.value.costPerHour" var="costPerHour"/>
    <fmt:message bundle="${textBundle}" key="label.value.status" var="status"/>
    <fmt:message bundle="${textBundle}" key="label.value.idOrganisation" var="idOrganisation"/>
    <fmt:message bundle="${textBundle}" key="label.value.action" var="action"/>
    <fmt:message bundle="${textBundle}" key="label.value.update" var="update"/>
    <fmt:message bundle="${textBundle}" key="label.value.delete" var="delete"/>
    <fmt:message bundle="${textBundle}" key="label.value.logout" var="logout"/>
    <fmt:message bundle="${textBundle}" key="label.value.addBike" var="addBike"/>
    <title>${addBike}</title>
</head>
<body>
<c:import url="/jsp/admin/adminHeader.jsp"/>
<form name="addBikeForm" action="controller" method="post">
    <div align="center">
        <input type="hidden" name="command" value="add_bike">
        ${latitude}:
        <input type="text" name="latitude" />
        <br/>${longitude}:
        <input type="text" name="longitude" />
        <br/>${costPerHour}:
        <input type="text" name="cost_per_hour" />
        <br/>${status}:
        <input type="text" name="status" />
        <br/>${idOrganisation}:
        <input type="text" name="id_organisation" />
        <br/><br/><input type="submit" value="${addBike}" > <br/>
        ${message}
    </div>
</form>
</body>
</html>
