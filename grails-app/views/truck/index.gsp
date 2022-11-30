<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'truck.label', default: 'DriverAccount')}" />
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
                            <h2>Trucks</h2>
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
                                    <g:sortableColumn class="idTables" property="number" title="Number"/>
                                    <g:sortableColumn class="idTables" property="modelYear" title="Model Year"/>
                                    <g:sortableColumn class="idTables" property="stateInspectionExpDate" title="State Inspection"/>
                                    <g:sortableColumn class="idTables" property="tankVKExpDate" title="Tank VK"/>
                                    <g:sortableColumn class="idTables" property="tankIPExpDate" title="Tank IP"/>
                                    <g:sortableColumn class="idTables" property="airportExpDate" title="Airport"/>
                                    <g:sortableColumn class="idTables" property="tag" title="Tag"/>
                                </tr>
                                </thead>
                                <tbody>
                                <g:each in="${truckList}" var="truck">
                                    <tr>
                                        <th scope="row">${truck.id}</th>
                                        <th><g:link action="show" id="${truck.id}">${truck.number}</g:link></th>
                                        <th>${truck.modelYear}</th>
                                        <th>${truck.stateInspectionExpDate}</th>
                                        <th>${truck.tankVKExpDate}</th>
                                        <th>${truck.tankIPExpDate}</th>
                                        <th>${truck.airportExpDate}</th>
                                        <th>${truck.tag}</th>
                                    </tr>
                                </g:each>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
<!-- /page content -->

</body>
</html>