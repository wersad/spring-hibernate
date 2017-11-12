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
            Imię: <form:input path="firstName"/>
        </div>
        <div>
            Nazwisko: <form:input path="lastName"/>
        </div>
        <div> 
            Mężczyzna: <form:radiobutton path="sex" value="M"/>
            Kobieta: <form:radiobutton path="sex" value="F"/>
        </div>
        <div>
            Kraj: <form:select path="country" items="${countryItems}"/>
        </div>
        <div>
            Notatka: <form:textarea path="notes" rows="3" cols="20"/>
        </div>
        <div>
            Chcę otrzymywać wiadomości: <form:checkbox path="receiveMessages"/>
        </div>
         <div>
            Języki programowania: <form:select path="languages" items="${languages}" multiple="true"/>
        </div>
        <div>
            Hobby: <form:checkboxes path="hobbies" items="${hobbies}" itemLabel="name" itemValue="id"/>
        </div>
        <div>
            <input type="submit" value="Dodaj osobę">
        </div>
    </form:form>
</body>
</html>