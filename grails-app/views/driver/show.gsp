<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'driver.label', default: 'Driver')}" />
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
                                <p class="lead">Show Driver</p>
                                <div class="table-responsive">
                                    <table class="table">
                                        <tbody>
                                        <tr>
                                            <th style="width:50%">First Name:</th>
                                            <td>${driver.firstName}</td>
                                        </tr>
                                        <tr>
                                            <th>Last Name:</th>
                                            <td>${driver.lastName}</td>
                                        </tr>
                                        <tr>
                                            <th>Color:</th>
                                            <g:if test="${driver.colorType}">
                                                <td style="color: ${driver.colorType}">${driver.colorType}</td>
                                            </g:if>
                                            <g:else>
                                                <td>None</td>
                                            </g:else>
                                        </tr>
                                        <tr>
                                            <th>Medical Card:</th>
                                            <td>${driver.medCardExpDate}</td>
                                        </tr>
                                        <tr>
                                            <th>Drivers License:</th>
                                            <td>${driver.driversLicenseExpDate}</td>
                                        </tr>
                                        <tr>
                                            <th>Hazmat:</th>
                                            <td>${driver.hazmatExpDate}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <g:form id="demo-form2" url="[resource:driver, action:'edit']" class="form-horizontal form-label-left">
                                <div class="form-group">
                                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                        <g:link class="btn btn-primary" action="index">Cancel</g:link>

                                            <g:submitButton name="update" type="submit" class="btn btn-success" value="Edit"/>
                                            <g:actionSubmit action="delete" name="delete" type="submit" class="btn btn-danger" value="Delete" onclick="return confirm('${message(code: 'default.button.delete.driver.confirm', default: 'Are you sure?')}');"/>

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
