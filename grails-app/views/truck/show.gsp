<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'truck.label', default: 'Truck')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="right_col" role="main">
            <div class="">

                <g:render template="/layouts/form_nav"/>

                <div class="clearfix"></div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="x_panel">
                            <div class="inner_nav_title">
                                <p class="lead">Show Truck</p>
                                <div class="table-responsive">
                                    <table class="table">
                                        <tbody>
                                        <tr>
                                            <th style="width:50%">Number:</th>
                                            <td>${truck.number}</td>
                                        </tr>
                                        <tr>
                                            <th>Model Year:</th>
                                            <td>${truck.modelYear}</td>
                                        </tr>
                                        <tr>
                                            <th>State Inspection:</th>
                                            <td>${truck.stateInspectionExpDate}</td>
                                        </tr>
                                        <tr>
                                            <th>Tank VK:</th>
                                            <td>${truck.tankVKExpDate}</td>
                                        </tr>
                                        <tr>
                                            <th>Tank IP:</th>
                                            <td>${truck.tankIPExpDate}</td>
                                        </tr>
                                        <tr>
                                            <th>Airport:</th>
                                            <td>${truck.airportExpDate}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <g:form id="demo-form2" url="[resource:truck, action:'edit']" class="form-horizontal form-label-left">
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <g:link class="btn btn-primary" action="index">Cancel</g:link>

                                        <g:submitButton name="update" type="submit" class="btn btn-success" value="Edit"/>
                                        <g:actionSubmit action="delete" name="delete" type="submit" class="btn btn-danger" value="Delete" onclick="return confirm('${message(code: 'default.button.delete.truck.confirm', default: 'Are you sure?')}');"/>

                                    </div>
                                </div>
                            </g:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
