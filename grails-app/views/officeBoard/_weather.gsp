%{--<div class="row">--}%
    %{--<div class="col-sm-12">--}%
        %{--<div class="x_panel">--}%
            %{--<div class="x_content" style="text-align: center">--}%
                %{--<div id="weather"></div>--}%
                %{--<h3>Forecast</h3>--}%
            %{--</div>--}%
        %{--</div>--}%
    %{--</div>--}%
%{--</div>--}%
%{--<div class="row">--}%
    %{--<div class="col-sm-12">--}%
        %{--<div class="x_panel">--}%
            %{--<div class="x_content">--}%
                %{--<div class="table-responsive">--}%
                    %{--<table class="table table-striped jambo_table bulk_action">--}%
                        %{--<thead>--}%
                            %{--<tr>--}%
                                %{--<th class="dashboard">day</th>--}%
                                %{--<th class="dashboard">high</th>--}%
                                %{--<th class="dashboard">low</th>--}%
                                %{--<th class="dashboard">weather</th>--}%
                            %{--</tr>--}%
                        %{--</thead>--}%
                        %{--<tbody id="forecast" class="table">--}%
                        %{--</tbody>--}%
                    %{--</table>--}%
                %{--</div>--}%
            %{--</div>--}%
        %{--</div>--}%
    %{--</div>--}%
%{--</div>--}%

<div class="row">
    <div class="col-sm-12 col-xs-12">
        <div class="x_panel">
            <div id="weather" class="x_content" style="text-align: center">
                <div>
                    <ul>
                        <li><big>Manassas</big></li>
                        <br>
                        <li><small>${forecastMap[0].condition}</small></li>
                    </ul>
                    <h2><image src="${forecastMap[0].icon}"/> 75°F</h2>
                </div>
                <h3>Today</h3>
                <div class="row">
                    <g:each status="i" in="${forecastMap}" var="forecast">
                        <g:if test="${i < 3}">
                            <div class="col-xs-4">
                                <ul>
                                    <li>
                                        ${forecast.hour}
                                    </li>
                                    <br>
                                    <li>
                                        <image src="${forecast.icon}" style="width:100%"/>
                                    </li>
                                    <br>
                                    <li>
                                        ${forecast.condition}
                                    </li>
                                </ul>
                            </div>
                        </g:if>
                    </g:each>
                </div>
                <div class="row">
                    <g:each status="i" in="${forecastMap}" var="forecast">
                        <g:if test="${i > 2}">
                            <div class="col-xs-4">
                                <ul>
                                    <li>
                                        ${forecast.hour}
                                    </li>
                                    <br>
                                    <li>
                                        <image src="${forecast.icon}" style="width:100%"/>
                                    </li>
                                    <br>
                                    <li>
                                        ${forecast.condition}
                                    </li>
                                </ul>
                            </div>
                        </g:if>
                    </g:each>
                </div>
            </div>
        </div>
    </div>
</div>
