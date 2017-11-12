<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head></head>
<body>
    <form:form action="save" method="post" modelAttribute="book">
        <div>
            Tytuł: <form:input path="title"/>
        </div>
        <div>
            Autor: <form:input path="author"/>
        </div>
        <div>
            Rating: <form:input type="number" path="rating"/>
        </div>
        <div>
            <form:select path="publisher" items="${publishers}" itemValue="id" itemLabel="name"/>
        </div>
        <div>
            Opis <form:textarea path="description" rows="3" cols="30"/>
        </div>
        <div>
            <input type="submit" value="Dodaj książkę">
        </div>
    </form:form>
</body>
</html>