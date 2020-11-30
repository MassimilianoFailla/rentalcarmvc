<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
      integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login - RentalCar</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.1/js/materialize.min.js"></script>


    <script>

        (function ($) {
            "use strict";

            // Options for Message
            //----------------------------------------------
            var options = {
                'btn-loading': '<i class="fa fa-spinner fa-pulse"></i>',
                'btn-success': '<i class="fa fa-check"></i>',
                'btn-error': '<i class="fa fa-remove"></i>',
                'msg-success': 'All Good! Redirecting...',
                'msg-error': 'Wrong login credentials!',
                'useAJAX': true,
            };

            // Login Form
            //----------------------------------------------
            // Validation
            $("#login-form").validate({
                rules: {
                    lg_username: "required",
                    lg_password: "required",
                },
                errorClass: "form-invalid"
            });

            // Form Submission
            $("#login-form").submit(function () {
                remove_loading($(this));

                if (options['useAJAX'] == true) {
                    // Dummy AJAX request (Replace this with your AJAX code)
                    // If you don't want to use AJAX, remove this
                    dummy_submit_form($(this));

                    // Cancel the normal submission.
                    // If you don't want to use AJAX, remove this
                    return false;
                }
            });


            // Forgot Password Form
            //----------------------------------------------
            // Validation
            $("#forgot-password-form").validate({
                rules: {
                    fp_email: "required",
                },
                errorClass: "form-invalid"
            });

            // Form Submission
            $("#forgot-password-form").submit(function () {
                remove_loading($(this));

                if (options['useAJAX'] == true) {
                    // Dummy AJAX request (Replace this with your AJAX code)
                    // If you don't want to use AJAX, remove this
                    dummy_submit_form($(this));

                    // Cancel the normal submission.
                    // If you don't want to use AJAX, remove this
                    return false;
                }
            });

            // Loading
            //----------------------------------------------
            function remove_loading($form) {
                $form.find('[type=submit]').removeClass('error success');
                $form.find('.login-form-main-message').removeClass('show error success').html('');
            }

            function form_loading($form) {
                $form.find('[type=submit]').addClass('clicked').html(options['btn-loading']);
            }

            function form_success($form) {
                $form.find('[type=submit]').addClass('success').html(options['btn-success']);
                $form.find('.login-form-main-message').addClass('show success').html(options['msg-success']);
            }

            function form_failed($form) {
                $form.find('[type=submit]').addClass('error').html(options['btn-error']);
                $form.find('.login-form-main-message').addClass('show error').html(options['msg-error']);
            }

            // Dummy Submit Form (Remove this)
            //----------------------------------------------
            // This is just a dummy form submission. You should use your AJAX function or remove this function if you are not using AJAX.
            function dummy_submit_form($form) {
                if ($form.valid()) {
                    form_loading($form);

                    setTimeout(function () {
                        form_success($form);
                    }, 2000);
                }
            }

        })(jQuery);

    </script>


    <style>

        html,
        body {
            background: #efefef;
            padding: 10px;
            font-family: 'Varela Round';
        }

        a {
            color: #aaaaaa;
            transition: all ease-in-out 200ms;
        }

        a:hover {
            color: #333333;
            text-decoration: none;
        }

        /*=== 3. Text Outside the Box ===*/
        .etc-login-form {
            color: #919191;
            padding: 10px 20px;
        }

        .etc-login-form p {
            margin-bottom: 5px;
        }

        .login-form-1 {
            max-width: 300px;
            border-radius: 5px;
            display: inline-block;
        }

        .main-login-form {
            position: relative;
        }

        .login-form-1 .form-control {
            border: 0;
            box-shadow: 0 0 0;
            border-radius: 0;
            background: transparent;
            color: #555555;
            padding: 7px 0;
            font-weight: bold;
            height: auto;
        }

        .login-form-1 .form-control::-webkit-input-placeholder {
            color: #999999;
        }

        .login-form-1 .form-control:-moz-placeholder,
        .login-form-1 .form-control::-moz-placeholder,
        .login-form-1 .form-control:-ms-input-placeholder {
            color: #999999;
        }

        .login-form-1 .form-group {
            margin-bottom: 0;
            border-bottom: 2px solid #efefef;
            padding-right: 20px;
            position: relative;
        }

        .login-form-1 .form-group:last-child {
            border-bottom: 0;
        }

        .login-group {
            background: #ffffff;
            color: #999999;
            border-radius: 8px;
            padding: 10px 20px;
        }

        .login-group-checkbox {
            padding: 5px 0;
        }

        .login-form-1 .login-button {
            position: absolute;
            right: -25px;
            top: 50%;
            background: #ffffff;
            color: #999999;
            padding: 11px 0;
            width: 50px;
            height: 50px;
            margin-top: -25px;
            border: 5px solid #efefef;
            border-radius: 50%;
            transition: all ease-in-out 500ms;
        }

        .login-form-1 .login-button:hover {
            color: #555555;
            transform: rotate(450deg);
        }

        .login-form-1 .login-button.clicked {
            color: #555555;
        }

        .login-form-1 .login-button.clicked:hover {
            transform: none;
        }

        .login-form-1 .login-button.clicked.success {
            color: #2ecc71;
        }

        .login-form-1 .login-button.clicked.error {
            color: #e74c3c;
        }

        label.form-invalid {
            position: absolute;
            top: 0;
            right: 0;
            z-index: 5;
            display: block;
            margin-top: -25px;
            padding: 7px 9px;
            background: #777777;
            color: #ffffff;
            border-radius: 5px;
            font-weight: bold;
            font-size: 11px;
        }

        label.form-invalid:after {
            top: 100%;
            right: 10px;
            border: solid transparent;
            content: " ";
            height: 0;
            width: 0;
            position: absolute;
            pointer-events: none;
            border-color: transparent;
            border-top-color: #777777;
            border-width: 6px;
        }

        .login-form-main-message {
            background: #ffffff;
            color: #999999;
            border-left: 3px solid transparent;
            border-radius: 3px;
            margin-bottom: 8px;
            font-weight: bold;
            height: 0;
            padding: 0 20px 0 17px;
            opacity: 0;
            transition: all ease-in-out 200ms;
        }

        .login-form-main-message.show {
            height: auto;
            opacity: 1;
            padding: 10px 20px 10px 17px;
        }

        .login-form-main-message.success {
            border-left-color: #2ecc71;
        }

        .login-form-main-message.error {
            border-left-color: #e74c3c;
        }

        [type="checkbox"]:not(:checked),
        [type="checkbox"]:checked,
        [type="radio"]:not(:checked),
        [type="radio"]:checked {
            position: absolute;
            left: -9999px;
        }

        [type="checkbox"]:not(:checked) + label,
        [type="checkbox"]:checked + label,
        [type="radio"]:not(:checked) + label,
        [type="radio"]:checked + label {
            position: relative;
            padding-left: 25px;
            padding-top: 1px;
            cursor: pointer;
        }

        /* checkbox aspect */
        [type="checkbox"]:not(:checked) + label:before,
        [type="checkbox"]:checked + label:before,
        [type="radio"]:not(:checked) + label:before,
        [type="radio"]:checked + label:before {
            content: '';
            position: absolute;
            left: 0;
            top: 2px;
            width: 17px;
            height: 17px;
            border: 0px solid #aaa;
            background: #f0f0f0;
            border-radius: 3px;
            box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.3);
        }

        /* checked mark aspect */
        [type="checkbox"]:not(:checked) + label:after,
        [type="checkbox"]:checked + label:after,
        [type="radio"]:not(:checked) + label:after,
        [type="radio"]:checked + label:after {
            position: absolute;
            color: #555555;
            transition: all .2s;
        }

        /* checked mark aspect changes */
        [type="checkbox"]:not(:checked) + label:after,
        [type="radio"]:not(:checked) + label:after {
            opacity: 0;
            transform: scale(0);
        }

        [type="checkbox"]:checked + label:after,
        [type="radio"]:checked + label:after {
            opacity: 1;
            transform: scale(1);
        }

        /* disabled checkbox */
        [type="checkbox"]:disabled:not(:checked) + label:before,
        [type="checkbox"]:disabled:checked + label:before,
        [type="radio"]:disabled:not(:checked) + label:before,
        [type="radio"]:disabled:checked + label:before {
            box-shadow: none;
            border-color: #8c8c8c;
            background-color: #878787;
        }

        [type="checkbox"]:disabled:checked + label:after,
        [type="radio"]:disabled:checked + label:after {
            color: #555555;
        }

        [type="checkbox"]:disabled + label,
        [type="radio"]:disabled + label {
            color: #8c8c8c;
        }

        /* accessibility */
        [type="checkbox"]:checked:focus + label:before,
        [type="checkbox"]:not(:checked):focus + label:before,
        [type="checkbox"]:checked:focus + label:before,
        [type="checkbox"]:not(:checked):focus + label:before {
            border: 1px dotted #f6f6f6;
        }

        /* hover style just for information */
        label:hover:before {
            border: 1px solid #f6f6f6 !important;
        }

        /*=== Customization ===*/
        /* radio aspect */
        [type="checkbox"]:not(:checked) + label:before,
        [type="checkbox"]:checked + label:before {
            border-radius: 3px;
        }

        [type="radio"]:not(:checked) + label:before,
        [type="radio"]:checked + label:before {
            border-radius: 35px;
        }

        /* selected mark aspect */
        [type="checkbox"]:not(:checked) + label:after,
        [type="checkbox"]:checked + label:after {
            content: 'â';
            top: 0;
            left: 2px;
            font-size: 14px;
        }

        [type="radio"]:not(:checked) + label:after,
        [type="radio"]:checked + label:after {
            content: '\2022';
            top: 0;
            left: 3px;
            font-size: 30px;
            line-height: 25px;
        }

        /*=== 9. Misc ===*/
        .logo {
            padding: 15px 0;
            font-size: 25px;
            color: #aaaaaa;
            font-weight: bold;
        }


    </style>

</head>
<form:form method="POST" modelAttribute="Login">

    <div class="text-center" style="padding:50px 0">
        <div class="logo">Login - Rental Car</div>

        <div class="login-form-1">
            <div id="login" class="center">
                <div class="login-form-main-message"></div>
                <div class="main-login-form">
                    <div class="login-group">

                        <div class="form-group">
                            <label class="sr-only">Username</label>
                            <input type="text" class="form-control" id="lg_username" name="username"
                                   placeholder="username">
                        </div>

                        <div class="form-group">
                            <label class="sr-only">Password</label>
                            <input type="password" class="form-control" id="lg_password" name="password"
                                   placeholder="password">
                        </div>

                    </div>
                    <button type="submit" class="login-button"><i class="fa fa-chevron-right">Login</i></button>
                </div>

                    <%--<spring:url value="/inserisciUtente" var="registerUrl"/>--%>
                <div class="etc-login-form">
                    <p>Non sei registrato? <a href="/utente/registrazione">Registrati</a></p>
                </div>
                </form>
            </div>
        </div>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
                integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
                crossorigin="anonymous"></script>

    </div>
</form:form>
</html>