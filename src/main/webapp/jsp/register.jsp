<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.language}"/>
    <fmt:setBundle basename="property.text" var="textBundle" scope="session"/>
    <fmt:message bundle="${textBundle}" key="button.value.changeLanguage" var="change_language"/>
    <fmt:message bundle="${textBundle}" key="label.value.login" var="name"/>
    <fmt:message bundle="${textBundle}" key="button.value.login" var="loginButton"/>
    <fmt:message bundle="${textBundle}" key="label.value.login" var="loginLabel"/>
    <fmt:message bundle="${textBundle}" key="label.value.password" var="password"/>
    <fmt:message bundle="${textBundle}" key="label.value.repeatPassword" var="repeatPassword"/>
    <fmt:message bundle="${textBundle}" key="label.value.email" var="email"/>
    <fmt:message bundle="${textBundle}" key="button.value.register" var="register"/>
    <title>${loginLabel}</title></head>
<body>

<div align="center">
    <form name="loginForm" method="POST" action="controller">
        <input type="hidden" name="command" value="register"/>
        ${loginLabel}:<br/>
        <input type="text" name="login"/>
        <br/>${password}:<br/>
        <input type="password" name="password"/>
        <br/>${repeatPassword}:<br/>
        <input type="password" name="repeated_password"/>
        <br/>${email}:<br/>
        <input type="text" name="email"/>
        <br/>
        <br/>
        <input type="submit" value="${register}"/>
    </form>
    <a href="controller?command=forward_to_login">${loginButton}</a>
    <br/>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="change_language"/>
        <input type="submit" value="${change_language}"/>
    </form>
    ${message}
</div>
</body>

<c:import url="/jsp/footer.jsp"/>
</html>