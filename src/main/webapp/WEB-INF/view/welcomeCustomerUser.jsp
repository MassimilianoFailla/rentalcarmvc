<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="jumbotron jumbotron-billboard">
    <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1>${intestazione}</h1>
                <br>
                <br>
                <br>
                <br>
                <br>
                <h3>Lista prenotazioni registrate</h3>
                <%--@elvariable id="/homeCustomerUser" type=""--%>
                <form:form method="GET" modelAttribute="/homeCustomerUser">
                    <table class="table table-striped" style="margin-left:auto;margin-right:auto;">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Inizio Prenotazione</th>
                            <th scope="col">Fine Prenotazione</th>
                            <th scope="col">Modello Mezzo Prenotato</th>
                            <th scope="col">Targa Mezzo</th>
                            <th scope="col">Nome Utente</th>
                            <th scope="col">Codice Fiscale</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaPrenotazioni}" var="prenotazione">
                            <tr>
                                <td>${prenotazione.id}</td>
                                <td>${prenotazione.inizioPrenotazione}</td>
                                <td>${prenotazione.finePrenotazione}</td>
                                <td>${prenotazione.mezzo.modello}</td>
                                <td>${prenotazione.mezzo.targa}</td>
                                <td>${prenotazione.utente.nome}</td>
                                <td>${prenotazione.utente.codiceFiscale}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </form:form>
                <br>
                <br>
                <br>
                <br>
                <p>${saluti}</p>
            </div>
        </div>
    </div>
</div>
