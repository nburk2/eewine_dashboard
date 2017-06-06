<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'account.label', default: 'Account')}" />
    <title><g:message code="default.edit.label" args="[entityName]" /></title>
</head>
<body>
    <div class="right_col" role="main">
        <div class="">

            <g:render template="/layouts/form_nav"/>

            <div class="clearfix"></div>

            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Edit Account</h2>

                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <br />
                            <g:form id="demo-form2" url="[resource:account, action:'update']" class="form-horizontal form-label-left" method="PUT">
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
