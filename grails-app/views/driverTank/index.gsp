<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'driverTank.label', default: 'Truck')}" />
        %{--<link rel="stylesheet" href="extensions/reorder-rows/bootstrap-table-reorder-rows.css">--}%
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
                            <g:if test="${driverTankList.size()==0}">
                                <div class="x_title">
                                    <g:form action="generateLastWeeksDay">
                                        <div class="row">
                                            <div class="col-md-6">
                                                %{--<h2 class="3rem">Scheduled Day - Today <small class="invisible">--</small></h2>--}%
                                                <g:datePicker id="scheduledDate" name="scheduledDate" precision="day" relativeYears="[-3..1]" value="${scheduledDate}"/>
                                                <g:actionSubmit action="index" type="submit" class="btn btn-success" value="Set Date"/>
                                                <g:actionSubmit class="btn btn-info pull-right" value="Generate Previous Weeks schedule" action="generateLastWeeksDay"/>
                                            </div>
                                            <div class="pull-right col-md-5">
                                                <g:actionSubmit class="btn btn-info" value="Generate Specific Schedule" action="generateSpecificDay"/>
                                                <g:datePicker id="specificDate" name="specificDate" precision="day" relativeYears="[-3..1]" value="${scheduledDate}"/>
                                            </div>
                                        </div>
                                    </g:form>
                                    <div class="clearfix"></div>
                                </div>
                            </g:if>
                            %{-- Scheduled Day--}%
                            <g:form id="demo-form2" url="[resource:driverTank, action:'edit']" params="[scheduledDate:scheduledDate]" class="form-horizontal form-label-left">
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
                                                %{--<g:actionSubmit name="edit${driverTank.driver.id}" type="submit" value="${driverTank.driver}"/>--}%
                                                <th>
                                                    <g:link action="edit" params="[driverTank:driverTank,scheduledDate:scheduledDate]">
                                                        ${driverTank.driver.firstName}
                                                    </g:link>
                                                </th>
                                            </tr>
                                        </g:each>
                                        </tbody>
                                    </table>

                                </div>
                            </g:form>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <h3 class="text-center">${scheduledDate.format("MM-dd-yyyy")}</h3>
                </div>
                <div class="row">
                    <div class="grid-masonry">
                        <g:render template="driverTanks"/>
                    </div>
                </div>

            </div>
        </div>
        <!-- /This is declared in the main.gsp -->
    %{--<script src="https://cdnjs.cloudflare.com/ajax/libs/TableDnD/0.9.1/jquery.tablednd.js" integrity="sha256-d3rtug+Hg1GZPB7Y/yTcRixO/wlI78+2m08tosoRn7A=" crossorigin="anonymous"></script>--}%
    %{--<script type="text/javascript">--}%
        %{--$(document).ready(function() {--}%
            %{--// Initialise the table--}%
            %{--$("#table-1").tableDnD();--}%
        %{--});--}%
    %{--</script>--}%

    </body>

</html>