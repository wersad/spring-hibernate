<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head></head>
<body>
    <form:form method="post" modelAttribute="person">
        <div>
            Login: <form:input path="login"/>
        </div>
        <div>
            E-main: <form:input type="email" path="email"/>
        </div>
        <div>
            Password: <form:password path="password"/>
        </div>
        <div>
            Grupa: <form:select path="personGroup.id" items="${groups}" itemValue="id" itemLabel="name"/>
        </div>
        <div>
            <input type="submit" value="Dodaj osobę">
        </div>
    </form:form>
</body>
</html>