<div class="row">
    <div class="col-sm-12 col-xs-12">
        <div class="x_panel">
            <div id="weather" class="x_content" style="text-align: center">
                <div>
                    <g:if test="${forecastMap}">
                        <ul>
                            <li><big>Manassas</big></li>
                            <br>
                            <li><small>${forecastMap[0].condition}</small></li>
                        </ul>
                        <h2><image src="${forecastMap[0].icon}"/> ${forecastMap[0].temp}°F</h2>
                    </g:if>
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
                                        ${forecast.temp}°F
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
                                        ${forecast.temp}°F
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
