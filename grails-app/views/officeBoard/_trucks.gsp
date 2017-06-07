<div class="col-md-6 col-sm-6 col-xs-12">
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
                        <th class="dashboard">Truck Number</th>
                        <th class="dashboard">Year</th>
                        <th class="dashboard">Vapor</th>
                        <th class="dashboard">Internal Pressure</th>
                        <th class="dashboard">State Inspection</th>
                    </tr>
                    </thead>

                    <tbody>
                    <g:each in="${truckList}" var="truck">
                        <tr>
                            <th class="dashboard"><g:link action="show" id="${truck.id}">${truck.number}</g:link></th>
                            <th class="dashboard">${truck.modelYear}</th>
                            <th class="dashboard">${truck.tankVKExpDate?.format("MM/YY")}</th>
                            <th class="dashboard">${truck.tankIPExpDate?.format("MM/YY")}</th>
                            <th class="dashboard">${truck.stateInspectionExpDate.format("MM/YY")}</th>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>


        </div>
    </div>
</div>