<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="property.text" var="textBundle" scope="session"/>

<fmt:message bundle="${textBundle}" key="label.value.bikes" var="bikes"/>
<fmt:message bundle="${textBundle}" key="label.value.users" var="users"/>
<fmt:message bundle="${textBundle}" key="label.value.logout" var="logout"/>

<header>
    <a href="controller?command=show_all_bikes">${bikes}</a>
    <a href="controller?command=show_all_users">${users}</a>
    <a href="controller?command=logout">${logout}</a>
</header>