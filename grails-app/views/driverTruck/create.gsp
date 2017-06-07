<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <asset:stylesheet src="switchery.min.css"/>
    <asset:javascript src="switchery.min.js"/>
    <g:set var="entityName" value="${message(code: 'driverTruck.label', default: 'DriverTruck')}" />
    <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
    <body>
        <div class="right_col" role="main">
            <div class="">

                <g:render template="/layouts/form_nav"/>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-8 col-sm-8 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Create Driver & Truck Association</h2>

                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <br />
                                <g:form id="demo-form2" url="[resource:driverTruck, action:'save']" class="form-horizontal form-label-left">

                                    <g:render template="form"/>

                                </g:form>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <g:render template="currentList"/>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>
