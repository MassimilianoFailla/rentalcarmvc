<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="jumbotron jumbotron-billboard">
    <div class="img"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2>${intestazione}</h2>
                <p>
                    ${saluti}
                </p>
                <a href="<c:url value="/login/loginUtente"/>" id="SignUp" class="btn btn btn-primary btn-lg">Login</a>
                <a href="<c:url value="/utente/registrazione"/>" id="SignIn" class="btn btn-success btn-lg">Registrati</a>
            </div>
        </div>
    </div>
</div>
