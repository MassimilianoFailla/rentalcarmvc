<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="jumbotron jumbotron-billboard">
    <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>${intestazione}</h2>
                <br>
                <br>
                <br>
                <br>
                <br>
                <h3>Lista utenti customer</h3>
                <%--@elvariable id="/homeSuperUser" type=""--%>
                <form:form method="GET" modelAttribute="/homeSuperUser">
                    <table class="table table-striped" style="margin-left:auto;margin-right:auto;">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Nome</th>
                            <th scope="col">Cognome</th>
                            <th scope="col">D.Nascita</th>
                            <th scope="col">Codice Fiscale</th>
                            <th scope="col">Email</th>
                            <th scope="col">Username</th>
                            <th scope="col">Password</th>
                            <th scope="col">Tipologia</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaUtenti}" var="utente">
                            <tr>
                                <td>${utente.id}</td>
                                <td>${utente.nome}</td>
                                <td>${utente.cognome}</td>
                                <td>${utente.dataNascita}</td>
                                <td>${utente.codiceFiscale}</td>
                                <td>${utente.email}</td>
                                <td>${utente.username}</td>
                                <td>${utente.password}</td>
                                <td>${utente.role}</td>
                            </tr>
                        </c:forEach>
                        <br>
                        <br>
                        <br>
                        </tbody>
                    </table>
                </form:form>
                <p>${saluti}</p>
            </div>
        </div>
    </div>
</div>
