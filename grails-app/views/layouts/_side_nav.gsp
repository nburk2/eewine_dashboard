<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><i class="fa fa-lightbulb-o"></i> <span>EEWine</span></a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile clearfix">
            <div class="profile_pic">
                <asset:image class="img-circle profile_img" src="wine-logo.png"/>
            </div>
            <div class="profile_info">
                <span>Welcome,</span>
                <h2>${sec?.username()}</h2>
            </div>
        </div>
        <!-- /menu profile quick info -->

        <br />

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><g:link controller="officeBoard" action="index">Dashboard</g:link></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-edit"></i> Forms <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><g:link controller="driver" action="index">Driver</g:link></li>
                            <li><g:link controller="account" action="index">Account</g:link></li>
                            <li><g:link controller="truck" action="index">Truck</g:link></li>
                            <li><g:link controller="driverTruck" action="index">Truck Drivers</g:link></li>
                            <li><g:link controller="driverAccount" action="index">Driver Accounts</g:link></li>
                            <li><g:link controller="note" action="index">Notes</g:link></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-desktop"></i> Website Changes <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><g:link controller="winotstop" action="index">Wi-Not-Stop</g:link></li>
                            <li><g:link controller="wineEnergy" action="index">Wine Energy</g:link></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-table"></i> Tables <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><a href="tables.html">Tables</a></li>
                            <li><a href="tables_dynamic.html">Table Dynamic</a></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-table"></i> Tanks <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><g:link controller="veederRoot" action="ninetyPercentages">90% Spreadsheets</g:link></li>
                            <li><g:link controller="veederRoot" action="tankInfo">Tank Levels</g:link></li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-bar-chart-o"></i> Data Presentation <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li><g:link controller="driverAccount" action="updateDriverAccounts">Update Driver Accounts</g:link></li>
                            <li><a href="chartjs.html">Chart JS</a></li>
                            <li><a href="chartjs2.html">Chart JS2</a></li>
                            <li><a href="morisjs.html">Moris JS</a></li>
                            <li><a href="echarts.html">ECharts</a></li>
                            <li><a href="other_charts.html">Other Charts</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>

<!-- top navigation -->
<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <i class="fa fa-user text-primary"></i> ${sec?.username()}
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        %{--<li><a href="javascript:;"> Profile</a></li>--}%
                        %{--<li>--}%
                            %{--<a href="javascript:;">--}%
                                %{--<span class="badge bg-red pull-right">50%</span>--}%
                                %{--<span>Settings</span>--}%
                            %{--</a>--}%
                        %{--</li>--}%
                        %{--<li><a href="javascript:;">Help</a></li>--}%
                        <li><g:link controller='logoff'><i class="fa fa-sign-out pull-right"></i> Logout</g:link></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>
<!-- /top navigation -->