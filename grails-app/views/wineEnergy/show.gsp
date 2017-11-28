<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'wineenergy.label', default: 'WineEnergy')}" />
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
                        <p class="lead">Show Wine Energy Entry</p>
                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                <tr>
                                    <th style="width:50%">Name:</th>
                                    <td>${wineEnergy.name}</td>
                                </tr>
                                <tr>
                                    <th>Value:</th>
                                    <td>${wineEnergy.value}</td>
                                </tr>
                                <tr>
                                    <th>Description:</th>
                                    <td>${wineEnergy.description}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <g:form id="demo-form2" url="[resource:wineEnergy, action:'edit']" class="form-horizontal form-label-left">
                        <div class="form-group">
                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                <g:link class="btn btn-primary" action="index">Cancel</g:link>

                                <g:submitButton name="update" type="submit" class="btn btn-success" value="Edit"/>
                                <g:actionSubmit action="delete" name="delete" type="submit" class="btn btn-danger" value="Delete" onclick="return confirm('${message(code: 'default.button.delete.winotstop.confirm', default: 'Are you sure?')}');"/>

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
