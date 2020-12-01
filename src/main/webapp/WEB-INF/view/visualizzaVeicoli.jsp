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

                <!-- Lista Veicoli -->
                <div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
                    <%--@elvariable id="listaVeicoli" type=""--%>
                    <form:form method="GET" modelAttribute="listaVeicoli">
                        <table class="table table-striped" style="margin-left:auto;margin-right:auto;">
                            <thead class="thead-dark">
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Casa Costruttrice</th>
                                <th scope="col">Modello</th>
                                <th scope="col">Anno Immatricolazione</th>
                                <th scope="col">Targa</th>
                                <th scope="col">Aggiorna</th>
                                <th scope="col">Cancella</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listaVeicoli}" var="mezzo">
                                <tr>
                                    <td>${mezzo.id}</td>
                                    <td>${mezzo.casaCostruttrice}</td>
                                    <td>${mezzo.modello}</td>
                                    <td>${mezzo.annoImmatricolazione}</td>
                                    <td>${mezzo.targa}</td>
                                    <td>
                                        <form action="<spring:url value="aggiorna"/>" method="GET">
                                            <input type="hidden" name="id" value="${mezzo.id}">
                                            <input type="submit" value="Aggiorna">
                                        </form>
                                    <td>
                                        <form action="<spring:url value="elimina"/>" method="POST">
                                            <input type="hidden" name="id" value="${mezzo.id}">
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