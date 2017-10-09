<g:set var="status" value="${0}"/>
<g:each in="${tankInfoList}" var="site">
    <div class="col-md-6 col-sm-6 col-xs-12">
        <div class="x_panel">
            <div class="x_title">
                <h2>${site.name} - Volumes</h2>
            <div class="clearfix"></div>
            </div>
            <div class="x_content">

            <g:each in="${site.tanks}" var="tank">
                <div class="col-md-4">
                    <p class="text-center">${tank.key}</p>
                    <div id="echart_gauge${status}" style="height: 370px; -webkit-user-select: none; position: relative; background-color: transparent;" _echarts_instance_="ec_1507307496700">
                        <div style="position: relative; overflow: hidden; width: 294px; height: 370px; cursor: pointer;">
                            <canvas width="294" height="370" data-zr-dom-id="zr_0" style="position: absolute; left: 0px; top: 0px; width: 294px; height: 370px; -webkit-user-select: none;"></canvas>
                        </div>
                    </div>
                </div>

                <div hidden>${status ++}</div>
            </g:each>

            </div>
        </div>
    </div>
</g:each>