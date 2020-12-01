<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<div class="jumbotron jumbotron-billboard">
    <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>${Titolo}</h2>
                <p>${Titolo2}</p>
            </div>
        </div>
    </div>
</div>

<%--@elvariable id="Utente" type=""--%>
<form:form method="POST" modelAttribute="Utente">
    <table>
        <tr>
            <td>Nome:</td>
            <td><input type="text" name="nome" value="${utente.nome}"
                       required></td>
        </tr>
        <tr>
            <td>Cognome:</td>
            <td>
                <input type="text" name="cognome" value="${utente.cognome}"
                       required>
            </td>
        </tr>
        <tr>
            <td>Data Di Nascita:</td>
            <td><input type="date" name="dataNascita" value="${utente.dataNascita}"
                       required></td>
        </tr>
        <tr>
            <td>Codice Fiscale:</td>
            <td><input type="text" name="codiceFiscale"
                       value="${utente.codiceFiscale}" required></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email" value="${utente.email}"
                       required></td>
        </tr>
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username"
                       value="${utente.username}" required></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"
                       value="${utente.password}" required></td>
        </tr>

        <td>Tipologia Account:</td>
        <td>
            <select name="role">
                <option value="SuperUser">SuperUser</option>
                <option value="Customer">Customer</option>
                name="role" value="${utente.role}" required>
            </select>
        </td>

        </tr>

        <c:if test="${utente.id ne null}">
            <tr>
                <td colspan="2"><input type="submit" value="Aggiorna"></td>
            </tr>
        </c:if>
        <c:if test="${utente.id eq null}">
            <tr>
                <td colspan="2"><input type="submit" value="Salva"></td>
            </tr>
        </c:if>
    </table>
</form:form>