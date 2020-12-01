<%--@elvariable id="Titolo2" type=""--%>
<%--@elvariable id="Titolo" type=""--%>

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


                <!-- Lista Prenotazioni -->
                <div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
                    <%--@elvariable id="listaPrenotazioni" type=""--%>
                    <form:form method="GET" modelAttribute="listaPrenotazioni">
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
                                <th scope="col">Aggiorna</th>
                                <th scope="col">Elimina</th>
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
                                    <td>
                                        <form action="<spring:url value="aggiorna"/>" method="get">
                                            <input type="hidden" name="id" value="${prenotazione.id}">
                                            <input type="submit" value="Aggiorna">
                                        </form>
                                    <td>
                                        <form action="<spring:url value="elimina"/>" method="POST">
                                            <input type="hidden" name="id" value="${prenotazione.id}">
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