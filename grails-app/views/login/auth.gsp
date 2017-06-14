<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <meta name="layout" content="main"/>
    <title>Dashboard - Login</title>
</head>

<body>
<div class="right_col" role="main">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><g:message code="springSecurity.login.header"/></h3>
                </div>

                <div class="panel-body">
                    <g:if test='${flash.error}'>
                        <div class='panel-body'><span class="text-danger"><i class="fa fa-warning"></i> ${flash.error}</span></div>
                    </g:if>
                    <g:if test='${flash.message}'>
                        <div class='panel-body'><span class="text-info"><i class="fa fa-info"></i> ${flash.message}</span></div>
                    </g:if>
                    <form action='${postUrl}' method='POST' id='loginForm' class='cssform' autocomplete='off'>
                            <fieldset>
                            <div class="form-group">
                                <input id="username" autocomplete="off" class="form-control" placeholder="Email" name="username" type="text" autofocus>
                            </div>

                            <div class="form-group">
                                <input class="form-control" autocomplete="off" id="password" placeholder="Password" name="password" type="password" value="">
                            </div>

                            <div class="form-group">
                                <g:submitButton name="submit" autocomplete="off" class="btn btn-lg btn-success btn-block" value="Login"/>
                            </div>

                            <g:link controller="login" action="forgotPassword" class="pull-right">Forgot Password?</g:link>
                        </fieldset>
                    </form>


                </div>
            </div>
            <p>
                If your account is locked or you have other problems logging in, please contact <a href="mailto:nburk@eewine.com?Subject=Please%20Unlock%20My%20Account">nburk@</a>.
            </p>
        </div>
    </div>
</div>

</body>
</html>