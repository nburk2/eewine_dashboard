<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <asset:stylesheet src="switchery.min.css"/>
    <asset:javascript src="switchery.min.js"/>
    <g:set var="entityName" value="${message(code: 'clientaccounts.label', default: 'ClientAccounts')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>
<div class="right_col" role="main">
    <div class="">

        <g:render template="/layouts/form_nav"/>

        <div class="clearfix"></div>
        <g:if test="${account.hasErrors()}">
            <div class="alert alert-danger" role="alert">
                ${account.errors}
            </div>
        </g:if>

        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Create Account</h2>

                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <br />
                        <g:form id="demo-form2" url="[resource:account, action:'save']" class="form-horizontal form-label-left">

                            <g:render template="form"/>

                        </g:form>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
</html>
