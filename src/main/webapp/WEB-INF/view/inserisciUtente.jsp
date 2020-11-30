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

                <!-- Form Dati Cliente -->
                <div class="tab-pane fade show active" id="dati" role="tabpanel" aria-labelledby="dati-tab">
                    <form:form method="POST" modelAttribute="Utente">
                    <div class="form-body">
                        <div class="form-row">

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="Nome">Nome</label>
                                    <form:input id="Nome" path="nome" type="text" class="form-control"/>
                                </div>

                                <div class="form-group col-md-6">
                                    <label for="Cognome">Cognome </label>
                                    <form:input id="Cognome" path="cognome" type="text" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="Data Nascita">Data nascita </label>
                                    <form:input id="Data Nascita" path="dataNascita" type="date" class="form-control"/>
                                </div>

                                <div class="form-group col-md-3">
                                    <label for="Codice Fiscale">Codice Fiscale </label>
                                    <form:input id="Codice Fiscale" path="codiceFiscale" type="text"
                                                class="form-control"/>
                                </div>

                                <div class="form-group col-md-3">
                                    <label for="Email">Email</label>
                                    <form:input id="Email" path="email" type="email" class="form-control"/>
                                </div>
                            </div>

                            <div class="form-group col-md-6">
                                <label for="Username">Username</label>
                                <form:input id="Username" path="username" type="text" class="form-control"/>
                            </div>

                            <div class="form-group col-md-6">
                                <label for="Password">Password</label>
                                <form:input id="Password" path="password" type="password" class="form-control"/>
                            </div>

                        </div>

                        <div class="form-group">
                            <label for="Role">Tipologia Account: </label>
                            <div class="mt-radio-inline">
                                <label class="mt-radio">
                                    <form:radiobutton id="Role" class="form-check-input" path="role"
                                                      value="SuperUser" checked="true"/>
                                    <span>SuperUser</span>
                                </label>
                                <label class="mt-radio">
                                    <form:radiobutton class="form-check-input" path="role" value="Customer"/>
                                    <span>Customer</span>
                                </label>
                            </div>
                        </div>

                        <hr class="line-form">

                        <jsp:useBean id="utente" scope="request" type="com.sun.org.apache.xml.internal.security.signature.SignatureProperty"/>
                        <c:if test="${utente.id ne null}">
                            <tr>
                                <td colspan="2"><input type="submit" value="Modifica"></td>
                            </tr>
                        </c:if>
                        <c:if test="${utente.id eq null}">
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