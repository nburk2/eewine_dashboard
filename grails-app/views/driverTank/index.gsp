<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'driverTank.label', default: 'Truck')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">

                <g:render template="/layouts/form_nav"/>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Driver Tanks</h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li class="dropdown">
                                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                        <ul class="dropdown-menu" role="menu">
                                            <li><a href="#">Settings 1</a>
                                            </li>
                                            <li><a href="#">Settings 2</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            %{--Scheduled Day--}%
                            <div class="x_title">
                                <h2 class="3rem">Scheduled Day - Today <small class="invisible">--</small></h2>
                                <g:form action="index">
                                    <g:datePicker id="scheduledDate" name="scheduledDate" precision="day" relativeYears="[-3..1]" value="${scheduledDate}"/>
                                    <input type="submit" class="btn btn-success" value="Set Date">
                                    <g:actionSubmit class="btn btn-info pull-right" value="Generate Previous Weeks schedule for current Date" action="generateFromPreviousSchedule"/>
                                </g:form>
                                <div class="clearfix"></div>
                            </div>
                            %{-- Scheduled Day--}%
                            <div class="x_content">

                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <g:sortableColumn class="idTables" property="id" title="Id"/>
                                        <g:sortableColumn class="idTables" property="driver" title="Number"/>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <g:each in="${driverTankList}" var="driverTank">
                                        <tr>
                                            <th scope="row">${driverTank.id}</th>
                                            <th><g:link action="show" id="${driverTank.id}">${driverTank.driver}</g:link></th>
                                        </tr>
                                    </g:each>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="grid-masonry">
                        <g:render template="driverTanks"/>
                    </div>
                </div>

            </div>
        </div>
        <!-- /page content -->

    </body>
</html>