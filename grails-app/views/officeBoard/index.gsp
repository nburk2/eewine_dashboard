<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>

    <asset:link rel="icon" href="favicon.ico" type="image/x-ico" />
</head>
<body>
    <div class="right_col" role="main">
        <div class="row">

            <!-- start of weather widget -->
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Daily active users <small>Sessions</small></h2>
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
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="temperature"><b>Monday</b>, 07:30 AM
                                    <span>F</span>
                                    <span><b>C</b></span>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-4">
                                <div class="weather-icon">
                                    <canvas height="84" width="84" id="partly-cloudy-day"></canvas>
                                </div>
                            </div>
                            <div class="col-sm-8">
                                <div class="weather-text">
                                    <h2>Texas <br><i>Partly Cloudy Day</i></h2>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12">
                            <div class="weather-text pull-right">
                                <h3 class="degrees">23</h3>
                            </div>
                        </div>

                        <div class="clearfix"></div>

                        <div class="row weather-days">
                            <div class="col-sm-2">
                                <div class="daily-weather">
                                    <h2 class="day">Mon</h2>
                                    <h3 class="degrees">25</h3>
                                    <canvas id="clear-day" width="32" height="32"></canvas>
                                    <h5>15 <i>km/h</i></h5>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <div class="daily-weather">
                                    <h2 class="day">Tue</h2>
                                    <h3 class="degrees">25</h3>
                                    <canvas height="32" width="32" id="rain"></canvas>
                                    <h5>12 <i>km/h</i></h5>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <div class="daily-weather">
                                    <h2 class="day">Wed</h2>
                                    <h3 class="degrees">27</h3>
                                    <canvas height="32" width="32" id="snow"></canvas>
                                    <h5>14 <i>km/h</i></h5>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <div class="daily-weather">
                                    <h2 class="day">Thu</h2>
                                    <h3 class="degrees">28</h3>
                                    <canvas height="32" width="32" id="sleet"></canvas>
                                    <h5>15 <i>km/h</i></h5>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <div class="daily-weather">
                                    <h2 class="day">Fri</h2>
                                    <h3 class="degrees">28</h3>
                                    <canvas height="32" width="32" id="wind"></canvas>
                                    <h5>11 <i>km/h</i></h5>
                                </div>
                            </div>
                            <div class="col-sm-2">
                                <div class="daily-weather">
                                    <h2 class="day">Sat</h2>
                                    <h3 class="degrees">26</h3>
                                    <canvas height="32" width="32" id="cloudy"></canvas>
                                    <h5>10 <i>km/h</i></h5>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- end of weather widget -->
            <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
                <div class="x_panel">
                    <div class="x_content">
                        <p class="lead">Truck Drivers</p>
                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                <g:each in="${driverTruckList}" var="driverTruck">
                                    <tr>
                                        <th style="width:50%">${driverTruck.driver.firstName}</th>
                                        <td>${driverTruck.truck.number}</td>
                                    </tr>
                                </g:each>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
                <iframe src="https://calendar.google.com/calendar/embed?height=600&amp;wkst=1&amp;bgcolor=%23FFFFFF&amp;src=190bua44b6u2m6n799sqmsnbvd4mg4qr%40import.calendar.google.com&amp;color=%23182C57&amp;ctz=America%2FNew_York" style="border-width:0" width="100%" height="400px" min-height="100%" frameborder="0" scrolling="no"></iframe>
                <!-- <iframe src="https://outlook.office365.com/owa/calendar/38d674a96a4c4a398cb40dd6e631082f@eewine.com/2e86edcb534e4f679696128e42d4dd3f2706831291944545199/calendar.html" style="border-width:0" width="100%" height="400px" min-height="100%" frameborder="0" scrolling="yes"></iframe> -->
            </div>
        </div>

        <div class="clearfix"></div>

        <div class="row">
            <!--Drivers table -->
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
                                    <th class="column-title">First Name</th>
                                    <th class="column-title">Last Name</th>
                                    <th class="column-title">Medical Card</th>
                                    <th class="column-title">Drivers License</th>
                                    <th class="column-title">Hazmat</th>
                                </tr>
                                </thead>

                                <tbody>
                                <g:each in="${driverList}" var="driver">
                                    <tr>
                                        <th>${driver.firstName}</th>
                                        <th>${driver.lastName}</th>
                                        <th>${driver.medCardExpDate?.format("MM/dd/YY")}</th>
                                        <th>${driver.driversLicenseExpDate?.format("MM/dd/YYYY")}</th>
                                        <th>${driver.hazmatExpDate?.format("MM/YY")}</th>
                                    </tr>
                                </g:each>
                                </tbody>
                            </table>
                        </div>


                    </div>
                </div>
            </div>
            %{--Truck table--}%
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
                                    <th>Truck Number</th>
                                    <th>Year</th>
                                    <th>Vapor</th>
                                    <th>Internal Pressure</th>
                                    <th>State Inspection</th>
                                </tr>
                                </thead>

                                <tbody>
                                <g:each in="${truckList}" var="truck">
                                    <tr>
                                        <th><g:link action="show" id="${truck.id}">${truck.number}</g:link></th>
                                        <th>${truck.modelYear}</th>
                                        <th>${truck.tankVKExpDate?.format("MM/YY")}</th>
                                        <th>${truck.tankIPExpDate?.format("MM/YY")}</th>
                                        <th>${truck.stateInspectionExpDate.format("MM/YY")}</th>
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

</body>
</html>
