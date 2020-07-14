<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'tanks.label', default: 'Tanks')}" />
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
                            <p class="lead">Show Tank</p>
                            <div class="table-responsive">
                                <table class="table">
                                    <tbody>
                                    <tr>
                                        <th style="width:50%">Account Name:</th>
                                        <td>${tanks.account.name}</td>
                                    </tr>
                                    <tr>
                                        <th>Tank Number:</th>
                                        <td>${tanks.tankNum}</td>
                                    </tr>
                                    <tr>
                                        <th>Monday:</th>
                                        <td>${tanks.Monday}</td>
                                    </tr>
                                    <tr>
                                        <th>Tuesday:</th>
                                        <td>${tanks.Tuesday}</td>
                                    </tr>
                                    <tr>
                                        <th>Wednesday:</th>
                                        <td>${tanks.Wednesday}</td>
                                    </tr>
                                    <tr>
                                        <th>Thursday:</th>
                                        <td>${tanks.Thursday}</td>
                                    </tr>
                                    <tr>
                                        <th>Friday:</th>
                                        <td>${tanks.Friday}</td>
                                    </tr>
                                    <tr>
                                        <th>Saturday:</th>
                                        <td>${tanks.Saturday}</td>
                                    </tr>
                                    <tr>
                                        <th>Sunday:</th>
                                        <td>${tanks.Sunday}</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <g:form id="demo-form2" url="[resource:tanks, action:'edit']" class="form-horizontal form-label-left">
                            <div class="form-group">
                                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <g:link class="btn btn-primary" action="index">Cancel</g:link>

                                    <g:submitButton name="update" type="submit" class="btn btn-success" value="Edit"/>
                                    <g:actionSubmit action="delete" name="delete" type="submit" class="btn btn-danger" value="Delete" onclick="return confirm('${message(code: 'default.button.delete.tanks.confirm', default: 'Are you sure?')}');"/>

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
