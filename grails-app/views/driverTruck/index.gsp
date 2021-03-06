<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'driverTruck.label', default: 'DriverTruck')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">

                <g:render template="/layouts/form_nav"/>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-8 col-sm-8 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Truck Drivers</h2>
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
                            <div class="x_content">

                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <g:sortableColumn class="idTables" property="id" title="Id"/>
                                        %{--<g:sortableColumn class="idTables" property="useDate" title="Use Date"/>--}%
                                        <g:sortableColumn class="idTables" property="driver.firstName" title="Driver First Name"/>
                                        <g:sortableColumn class="idTables" property="driver.lastName" title="Driver Last Name"/>
                                        <g:sortableColumn class="idTables" property="truck.number" title="Truck Number"/>
                                        <g:sortableColumn class="idTables" property="off" title="Off"/>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <g:each in="${driverTruckList}" var="driverTruck">
                                        <tr>
                                            <th scope="row">${driverTruck.id}</th>
                                            %{--<th>${driverTruck.useDate.format("MM/dd/YYYY")}</th>--}%
                                            <th><g:link action="show" id="${driverTruck.id}">${driverTruck.driver.firstName}</g:link></th>
                                            <th>${driverTruck.driver.lastName}</th>
                                            <th>${driverTruck?.truck?.number}</th>
                                            <th>${driverTruck?.off}</th>
                                        </tr>
                                    </g:each>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>

                    <div class="col-md-4 col-sm-4 col-xs-12">
                        <g:render template="currentList"/>
                    </div>

                </div>

            </div>
        </div>
        <!-- /page content -->
    </body>
</html>