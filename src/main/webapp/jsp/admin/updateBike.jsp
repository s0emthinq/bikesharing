<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:import url="/jsp/admin/adminHeader.jsp"/>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.text" var="textBundle" scope="session"/>

<fmt:message bundle="${textBundle}" key="label.value.updatingBike" var="updatingBike"/>
<fmt:message bundle="${textBundle}" key="label.value.latitude" var="latitude"/>
<fmt:message bundle="${textBundle}" key="label.value.longitude" var="longitude"/>
<fmt:message bundle="${textBundle}" key="label.value.costPerHour" var="costPerHour"/>
<fmt:message bundle="${textBundle}" key="label.value.status" var="status"/>
<fmt:message bundle="${textBundle}" key="label.value.idOrganisation" var="idOrganisation"/>
<fmt:message bundle="${textBundle}" key="button.value.update" var="update"/>

<fmt:message bundle="${textBundle}" key="button.value.changeLanguage" var="change_language"/>


<form name="updateBikeForm" action="controller" method="get">
    <div align="center">
        <input type="hidden" name="command" value="update_bike">
        ${updatingBike} №${param.id}
        <input type="hidden" name="id" readonly value="${param.id}">
        <br/>${latitude}:
        <input type="text" name="new_latitude" value="${param.oldLatitude}"/>
        <br/>${longitude}:
        <input type="text" name="new_longitude" value="${param.oldLongitude}"/>
        <br/>${costPerHour}:
        <input type="text" name="new_cost_per_hour" value="${param.oldCostPerHour}"/>
        <br/>${status}:
        <input type="text" name="new_status" value="${param.oldStatus}"/>
        <br/>${idOrganisation}:
        <input type="text" name="new_id_organisation" value="${param.oldIdOrganisation}"/>
        <br/><br/><input type="submit" value=${update}>
        <br/><br/>
</form>
<form action="controller" method="get">
    <input type="hidden" name="command" value="change_language"/>
    <input type="submit" value="${change_language}"/>
</form>
${message}
</div>
</body>
</html>
