<div class="col-md-6 col-sm-6 col-xs-12">
    <div class="x_panel">
        <div class="x_title">
            <h2>Drivers</h2>
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
                        <th class="column-title dashboard">First Name</th>
                        <th class="column-title dashboard">Last Name</th>
                        <th class="column-title dashboard">Medical Card</th>
                        <th class="column-title dashboard">Drivers License</th>
                        <th class="column-title dashboard">Hazmat</th>
                    </tr>
                    </thead>

                    <tbody>
                    <g:each in="${driverList}" var="driver">
                        <tr>
                            <th class="dashboard">${driver.firstName}</th>
                            <th class="dashboard">${driver.lastName}</th>
                            <th class="dashboard">${driver.medCardExpDate?.format("MM/dd/YY")}</th>
                            <th class="dashboard">${driver.driversLicenseExpDate?.format("MM/dd/YYYY")}</th>
                            <th class="dashboard">${driver.hazmatExpDate?.format("MM/YY")}</th>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>


        </div>
    </div>
</div>