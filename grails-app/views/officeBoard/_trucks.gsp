<div class="col-md-7 col-sm-5 col-xs-12">
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
            <div class="table-responsive">
                <table class="table table-striped jambo_table bulk_action">
                    <thead>
                    <tr>
                        <th class="dashboard">Truck #</th>
                        <th class="dashboard">Year</th>
                        <th class="dashboard">Vapor</th>
                        <th class="dashboard">I/P</th>
                        <th class="dashboard">State</th>
                        <th class="dashboard">Airport</th>
                        <th class="dashboard">Tag</th>
                    </tr>
                    </thead>

                    <tbody>
                    <g:each in="${truckList}" var="truck">
                        <tr>
                            <th class="dashboard"><g:link action="show" id="${truck.id}">${truck.number}</g:link></th>
                            <th class="dashboard">${truck.modelYear}</th>
                            <g:if test="${truck?.tankVKExpDate?.year == (new java.util.Date()).year && truck?.tankVKExpDate?.month == (new java.util.Date()).month || (truck?.tankVKExpDate ?: new Date() + 1) <= new Date()}">
                                <th class="dashboard alert-danger">${truck.tankVKExpDate?.format("MM/yy")}</th>
                            </g:if>
                            <g:elseif test="${truck?.tankVKExpDate?.year == (new java.util.Date()).year && truck?.tankVKExpDate?.month <= (new java.util.Date()).month + 2 || truck?.tankVKExpDate?.year == (new java.util.Date()).year + 1 && (((new java.util.Date()).month - truck?.tankVKExpDate?.month) > 9)}">
                                <th class="dashboard alert-warning">${truck.tankVKExpDate?.format("MM/yy")}</th>
                            </g:elseif>
                            <g:else>
                                <th class="dashboard">${truck.tankVKExpDate?.format("MM/yy")}</th>
                            </g:else>
                            <g:if test="${truck?.tankIPExpDate?.year == (new java.util.Date()).year && truck?.tankIPExpDate?.month == (new java.util.Date()).month || (truck?.tankIPExpDate ?: new Date() + 1) <= new Date()}">
                                <th class="dashboard alert-danger">${truck.tankIPExpDate?.format("MM/yy")}</th>
                            </g:if>
                            <g:elseif test="${truck?.tankIPExpDate?.year == (new java.util.Date()).year && truck?.tankIPExpDate?.month <= (new java.util.Date()).month + 2 || truck?.tankIPExpDate?.year == (new java.util.Date()).year + 1 && (((new java.util.Date()).month - truck?.tankIPExpDate?.month) > 9)}">
                                <th class="dashboard alert-warning">${truck.tankIPExpDate?.format("MM/yy")}</th>
                            </g:elseif>
                            <g:else>
                                <th class="dashboard">${truck.tankIPExpDate?.format("MM/yy")}</th>
                            </g:else>
                            <g:if test="${truck?.stateInspectionExpDate?.year == (new java.util.Date()).year && truck?.stateInspectionExpDate?.month == (new java.util.Date()).month || (truck?.stateInspectionExpDate ?: new Date() + 1) <= new Date()}">
                                <th class="dashboard alert-danger">${truck.stateInspectionExpDate.format("MM/yy")}</th>
                            </g:if>
                            <g:elseif test="${truck?.stateInspectionExpDate?.year == (new java.util.Date()).year && truck?.stateInspectionExpDate?.month <= (new java.util.Date()).month + 2 || truck?.stateInspectionExpDate?.year == (new java.util.Date()).year + 1 && (((new java.util.Date()).month - truck?.stateInspectionExpDate?.month) > 9)}">
                                <th class="dashboard alert-warning">${truck.stateInspectionExpDate?.format("MM/yy")}</th>
                            </g:elseif>
                            <g:else>
                                <th class="dashboard">${truck.stateInspectionExpDate?.format("MM/yy")}</th>
                            </g:else>
                            %{--airport--}%
                            <g:if test="${truck?.airportExpDate?.year == (new java.util.Date()).year && truck?.airportExpDate?.month == (new java.util.Date()).month || (truck?.airportExpDate ?: new Date() + 1) <= new Date()}">
                                <th class="dashboard alert-danger">${truck.airportExpDate.format("MM/yy")}</th>
                            </g:if>
                            <g:elseif test="${truck?.airportExpDate?.year == (new java.util.Date()).year && truck?.airportExpDate?.month <= (new java.util.Date()).month + 2 || truck?.airportExpDate?.year == (new java.util.Date()).year + 1 && (((new java.util.Date()).month - truck?.airportExpDate?.month) > 9)}">
                                <th class="dashboard alert-warning">${truck.airportExpDate?.format("MM/yy")}</th>
                            </g:elseif>
                            <g:else>
                                <th class="dashboard">${truck.airportExpDate?.format("MM/yy")}</th>
                            </g:else>
                            %{--Tags--}%
                            <g:if test="${truck?.tag?.year == (new java.util.Date()).year && truck?.tag?.month == (new java.util.Date()).month || (truck?.tag ?: new Date() + 1) <= new Date()}">
                                <th class="dashboard alert-danger">${truck.tag.format("MM/yy")}</th>
                            </g:if>
                            <g:elseif test="${truck?.tag?.year == (new java.util.Date()).year && truck?.tag?.month <= (new java.util.Date()).month + 2 || truck?.tag?.year == (new java.util.Date()).year + 1 && (((new java.util.Date()).month - truck?.tag?.month) > 9)}">
                                <th class="dashboard alert-warning">${truck.tag?.format("MM/yy")}</th>
                            </g:elseif>
                            <g:else>
                                <th class="dashboard">${truck.tag?.format("MM/yy")}</th>
                            </g:else>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>


        </div>
    </div>
</div>