<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<section class="container">
    <div class="portlet light bordered">
        <div class="portlet-title tabbable-line">

        </div>
        <div class="portlet-body form">
            <div class="tab-content" id="myTabContent">

                <!-- Lista Utenti -->
                <div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
                    <form:form method="GET" modelAttribute="listaUtenti">
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
                                <th scope="col">Modifica</th>
                                <th scope="col">Elimina</th>
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

                                    <td>
                                        <form action="<spring:url value="modifica/{utente.id}"/>" method="GET">
                                            <input type="hidden" name="id" value="${utente.id}">
                                            <input type="submit" value="Modifica">
                                        </form>
                                    <td>
                                        <form action="<spring:url value="elimina"/>" method="POST">
                                            <input type="hidden" name="id" value="${utente.id}">
                                            <input type="submit" value="Elimina">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>