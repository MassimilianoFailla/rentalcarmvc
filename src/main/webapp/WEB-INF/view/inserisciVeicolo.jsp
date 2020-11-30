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
                    <form:form method="POST" modelAttribute="Veicolo">
                    <div class="form-body">

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="CasaCostruttrice">Casa Costruttrice</label>
                                <form:input id="CasaCostruttrice" path="casaCostruttrice" type="text"
                                            class="form-control"/>
                            </div>

                            <div class="form-group col-md-6">
                                <label for="Modello">Modello</label>
                                <form:input id="Modello" path="modello" type="text" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="Anno Immatricolazione">Anno Immatricolazione </label>
                                <form:input id="Anno Immatricolazione" path="annoImmatricolazione" type="date"
                                            class="form-control"/>
                            </div>

                            <div class="form-group col-md-3">
                                <label for="Targa">Targa</label>
                                <form:input id="Targa" path="targa" type="text" class="form-control"/>
                            </div>

                        </div>
                        <div class="form-group">
                            <label for="tipologia">Tipologia Veicolo: </label>
                            <div class="mt-radio-inline">
                                <select name="Tipologia" id="tipologia">
                                    <option value="">Tipologia...</option>
                                    <option value="CityCar">CityCar</option>
                                    <option value="Furgone">Furgone</option>
                                    <option value="Minivan">Minivan</option>
                                    <option value="Berlina">Berlina</option>
                                    <option value="Suv">Suv</option>
                                    <option value="Camioncino">Camioncino</option>
                                </select>
                            </div>
                        </div>

                        <hr class="line-form">

                        <jsp:useBean id="mezzo" scope="request" type="com.sun.org.apache.xml.internal.security.signature.SignatureProperty"/>
                        <c:if test="${mezzo.id ne null}">
                            <tr>
                                <td colspan="2"><input type="submit" value="Aggiorna"></td>
                            </tr>
                        </c:if>
                        <c:if test="${mezzo.id eq null}">
                            <tr>
                                <td colspan="2"><input type="submit" value="Salva"></td>
                            </tr>
                        </c:if>

                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>