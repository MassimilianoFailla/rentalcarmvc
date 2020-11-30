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


                <!-- Form Dati Veicolo -->
                <div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
                    <form:form method="POST" modelAttribute="prenotazione">
                        <div class="form-body">

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="InizioPrenotazione">Inizio Prenotazione</label>
                                    <form:input id="InizioPrenotazione" path="inizioPrenotazione" type="date"
                                                class="form-control"/>
                                </div>

                                <div class="form-group col-md-6">
                                    <label for="FinePrenotazione">Fine Prenotazione</label>
                                    <form:input id="FinePrenotazione" path="finePrenotazione" type="date"
                                                class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label>Veicoli Disponibili</label>
                                <div class="mt-radio-inline">
                                    <form:select path="mezzo.targa"><%--@elvariable id="selected" type=""--%>
                                        <option value="${selected}" selected>${selected}</option>
                                        <c:forEach items="${listaMezzi}" var="veicolo">
                                            <c:if test="${veicolo.targa != selected}">
                                                <option value="${veicolo.targa}">${veicolo.targa}</option>
                                            </c:if>
                                        </c:forEach>
                                    </form:select>
                                </div>
                            </div>
                        </div>

                        <hr class="line-form">

                        <c:if test="${prenotazione.id ne null}">
                            <tr>
                                <td colspan="2"><input type="submit" value="Salva"></td>
                            </tr>
                        </c:if>
                        <c:if test="${prenotazione.id eq null}">
                            <tr>
                                <td colspan="2"><input type="submit" value="Aggiorna"></td>
                            </tr>
                        </c:if>

                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>