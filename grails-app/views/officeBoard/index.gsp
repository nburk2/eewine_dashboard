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
                        <p class="lead">Truck Numbers</p>
                        <div class="table-responsive">
                            <table class="table">
                                <tbody>
                                <tr>
                                    <th style="width:50%">Jim</th>
                                    <td>157</td>
                                </tr>
                                <tr>
                                    <th>Ray</th>
                                    <td>294</td>
                                </tr>
                                <tr>
                                    <th>john</th>
                                    <td>971</td>
                                </tr>
                                <tr>
                                    <th>Alex</th>
                                    <td>117</td>
                                </tr>
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
            <!--start of table design  -->
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>Table design <small>Custom design</small></h2>
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

                        <p>Add class <code>bulk_action</code> to table for bulk actions options on row select</p>

                        <div class="table-responsive">
                            <table class="table table-striped jambo_table bulk_action">
                                <thead>
                                <tr class="headings">
                                    <th>
                                        <input type="checkbox" id="check-all" class="flat">
                                    </th>
                                    <th class="column-title">Invoice </th>
                                    <th class="column-title">Invoice Date </th>
                                    <th class="column-title">Order </th>
                                    <th class="column-title">Bill to Name </th>
                                    <th class="column-title">Status </th>
                                    <th class="column-title">Amount </th>
                                    <th class="column-title no-link last"><span class="nobr">Action</span>
                                    </th>
                                    <th class="bulk-actions" colspan="7">
                                        <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                                    </th>
                                </tr>
                                </thead>

                                <tbody>
                                <tr class="even pointer">
                                    <td class="a-center ">
                                        <input type="checkbox" class="flat" name="table_records">
                                    </td>
                                    <td class=" ">121000040</td>
                                    <td class=" ">May 23, 2014 11:47:56 PM </td>
                                    <td class=" ">121000210 <i class="success fa fa-long-arrow-up"></i></td>
                                    <td class=" ">John Blank L</td>
                                    <td class=" ">Paid</td>
                                    <td class="a-right a-right ">$7.45</td>
                                    <td class=" last"><a href="#">View</a>
                                    </td>
                                </tr>
                                <tr class="odd pointer">
                                    <td class="a-center ">
                                        <input type="checkbox" class="flat" name="table_records">
                                    </td>
                                    <td class=" ">121000039</td>
                                    <td class=" ">May 23, 2014 11:30:12 PM</td>
                                    <td class=" ">121000208 <i class="success fa fa-long-arrow-up"></i>
                                    </td>
                                    <td class=" ">John Blank L</td>
                                    <td class=" ">Paid</td>
                                    <td class="a-right a-right ">$741.20</td>
                                    <td class=" last"><a href="#">View</a>
                                    </td>
                                </tr>
                                <tr class="even pointer">
                                    <td class="a-center ">
                                        <input type="checkbox" class="flat" name="table_records">
                                    </td>
                                    <td class=" ">121000038</td>
                                    <td class=" ">May 24, 2014 10:55:33 PM</td>
                                    <td class=" ">121000203 <i class="success fa fa-long-arrow-up"></i>
                                    </td>
                                    <td class=" ">Mike Smith</td>
                                    <td class=" ">Paid</td>
                                    <td class="a-right a-right ">$432.26</td>
                                    <td class=" last"><a href="#">View</a>
                                    </td>
                                </tr>
                                <tr class="odd pointer">
                                    <td class="a-center ">
                                        <input type="checkbox" class="flat" name="table_records">
                                    </td>
                                    <td class=" ">121000037</td>
                                    <td class=" ">May 24, 2014 10:52:44 PM</td>
                                    <td class=" ">121000204</td>
                                    <td class=" ">Mike Smith</td>
                                    <td class=" ">Paid</td>
                                    <td class="a-right a-right ">$333.21</td>
                                    <td class=" last"><a href="#">View</a>
                                    </td>
                                </tr>
                                <tr class="even pointer">
                                    <td class="a-center ">
                                        <input type="checkbox" class="flat" name="table_records">
                                    </td>
                                    <td class=" ">121000040</td>
                                    <td class=" ">May 24, 2014 11:47:56 PM </td>
                                    <td class=" ">121000210</td>
                                    <td class=" ">John Blank L</td>
                                    <td class=" ">Paid</td>
                                    <td class="a-right a-right ">$7.45</td>
                                    <td class=" last"><a href="#">View</a>
                                    </td>
                                </tr>
                                <tr class="odd pointer">
                                    <td class="a-center ">
                                        <input type="checkbox" class="flat" name="table_records">
                                    </td>
                                    <td class=" ">121000039</td>
                                    <td class=" ">May 26, 2014 11:30:12 PM</td>
                                    <td class=" ">121000208 <i class="error fa fa-long-arrow-down"></i>
                                    </td>
                                    <td class=" ">John Blank L</td>
                                    <td class=" ">Paid</td>
                                    <td class="a-right a-right ">$741.20</td>
                                    <td class=" last"><a href="#">View</a>
                                    </td>
                                </tr>
                                <tr class="even pointer">
                                    <td class="a-center ">
                                        <input type="checkbox" class="flat" name="table_records">
                                    </td>
                                    <td class=" ">121000038</td>
                                    <td class=" ">May 26, 2014 10:55:33 PM</td>
                                    <td class=" ">121000203</td>
                                    <td class=" ">Mike Smith</td>
                                    <td class=" ">Paid</td>
                                    <td class="a-right a-right ">$432.26</td>
                                    <td class=" last"><a href="#">View</a>
                                    </td>
                                </tr>
                                <tr class="odd pointer">
                                    <td class="a-center ">
                                        <input type="checkbox" class="flat" name="table_records">
                                    </td>
                                    <td class=" ">121000037</td>
                                    <td class=" ">May 26, 2014 10:52:44 PM</td>
                                    <td class=" ">121000204</td>
                                    <td class=" ">Mike Smith</td>
                                    <td class=" ">Paid</td>
                                    <td class="a-right a-right ">$333.21</td>
                                    <td class=" last"><a href="#">View</a>
                                    </td>
                                </tr>

                                <tr class="even pointer">
                                    <td class="a-center ">
                                        <input type="checkbox" class="flat" name="table_records">
                                    </td>
                                    <td class=" ">121000040</td>
                                    <td class=" ">May 27, 2014 11:47:56 PM </td>
                                    <td class=" ">121000210</td>
                                    <td class=" ">John Blank L</td>
                                    <td class=" ">Paid</td>
                                    <td class="a-right a-right ">$7.45</td>
                                    <td class=" last"><a href="#">View</a>
                                    </td>
                                </tr>
                                <tr class="odd pointer">
                                    <td class="a-center ">
                                        <input type="checkbox" class="flat" name="table_records">
                                    </td>
                                    <td class=" ">121000039</td>
                                    <td class=" ">May 28, 2014 11:30:12 PM</td>
                                    <td class=" ">121000208</td>
                                    <td class=" ">John Blank L</td>
                                    <td class=" ">Paid</td>
                                    <td class="a-right a-right ">$741.20</td>
                                    <td class=" last"><a href="#">View</a>
                                    </td>
                                </tr>
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
