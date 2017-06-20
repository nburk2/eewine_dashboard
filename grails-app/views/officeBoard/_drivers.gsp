<div class="col-md-5 col-sm-5 col-xs-12">
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
                        <th class="column-title dashboard">Last Name</th>
                        <th class="column-title dashboard">Medical Card</th>
                        <th class="column-title dashboard">Drivers License</th>
                        <th class="column-title dashboard">Hazmat</th>
                    </tr>
                    </thead>

                    <tbody>
                    <g:each in="${driverList}" var="driver">
                        <tr>
                            <th class="dashboard">${driver.lastName}</th>
                            <g:if test="${driver?.medCardExpDate?.year == (new java.util.Date()).year && driver?.medCardExpDate?.month == (new java.util.Date()).month || (driver?.medCardExpDate ?: new Date() + 1) <= new Date()}">
                                <th class="dashboard alert-danger">${driver.medCardExpDate?.format("MM/dd/YY")}</th>
                            </g:if>
                            <g:elseif test="${driver?.medCardExpDate?.year == (new java.util.Date()).year && driver?.medCardExpDate?.month <= (new java.util.Date()).month + 2 || driver?.medCardExpDate?.year == (new java.util.Date()).year + 1 && (((new java.util.Date()).month - driver?.medCardExpDate?.month) > 9)}">
                                <th class="dashboard alert-warning">${driver.medCardExpDate?.format("MM/YY")}</th>
                            </g:elseif>
                            <g:else>
                                <th class="dashboard">${driver.medCardExpDate?.format("MM/dd/YY")}</th>
                            </g:else>
                            <g:if test="${driver?.driversLicenseExpDate?.year == (new java.util.Date()).year && driver?.driversLicenseExpDate?.month == (new java.util.Date()).month || (driver?.driversLicenseExpDate ?: new Date() + 1) <= new Date()}">
                                <th class="dashboard alert-danger">${driver.driversLicenseExpDate?.format("MM/dd/YYYY")}</th>
                            </g:if>
                            <g:elseif test="${driver?.driversLicenseExpDate?.year == (new java.util.Date()).year && driver?.driversLicenseExpDate?.month <= (new java.util.Date()).month + 2 || driver?.driversLicenseExpDate?.year == (new java.util.Date()).year + 1 && (((new java.util.Date()).month - driver?.driversLicenseExpDate?.month) > 9)}">
                                <th class="dashboard alert-warning">${driver.driversLicenseExpDate?.format("MM/YY")}</th>
                            </g:elseif>
                            <g:else>
                                <th class="dashboard">${driver.driversLicenseExpDate?.format("MM/dd/YYYY")}</th>
                            </g:else>
                            <g:if test="${driver?.hazmatExpDate?.year == (new java.util.Date()).year && driver?.hazmatExpDate?.month == (new java.util.Date()).month || (driver?.hazmatExpDate ?: new Date() + 1) <= new Date()}">
                                <th class="dashboard alert-danger">${driver.hazmatExpDate?.format("MM/YY")}</th>
                            </g:if>
                            <g:elseif test="${driver?.hazmatExpDate?.year == (new java.util.Date()).year && driver?.hazmatExpDate?.month <= (new java.util.Date()).month + 2 || driver?.hazmatExpDate?.year == (new java.util.Date()).year + 1 && (((new java.util.Date()).month - driver?.hazmatExpDate?.month) > 9)}">
                                <th class="dashboard alert-warning">${driver.hazmatExpDate?.format("MM/YY")}</th>
                            </g:elseif>
                            <g:else>
                                <th class="dashboard">${driver.hazmatExpDate?.format("MM/YY")}</th>
                            </g:else>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>


        </div>
    </div>
</div>