<%@ page import="java.math.RoundingMode; java.math.MathContext" %>
<div class="grid-masonry">
<g:each status="i" in="${tankInfoList}" var="tankInfo">
    <div class="grid-item">
        <div class="x_content">
            <div class="x_title">
                <g:if test="${tankInfo.lastUpdateSuccess == false}">
                    <h2>${tankInfo.name} <small class="bg-danger" style="display: inline;">${tankInfo.lastUpdate}</small></h2>
                </g:if>
                <g:else>
                    <h2>${tankInfo.name} <small style="display: inline;">${tankInfo.lastUpdate}</small></h2>
                </g:else>
                <div class="clearfix"></div>
            </div>
            <div class="x_content">

                <table class="table">
                    <thead>
                    <tr>
                        <th>Tank</th>
                        <g:each in="${tankInfo.tanks}" var="tank">
                            <th>${tank.key}</th>
                        </g:each>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">Full Volume</th>
                        <g:each in="${tankInfo.tanks}" var="tank">
                            <td>
                                <b style="color:black">${tankInfo.tanks."${tank.key}".fullvolume}</b>
                            </td>
                        </g:each>
                    </tr>
                    <tr>
                        <th scope="row">Volume</th>
                        <g:each in="${tankInfo.tanks}" var="tank">
                            <td>
                                <b style="color:black">${tankInfo.tanks."${tank.key}".volume}</b>
                            </td>
                        </g:each>
                    </tr>
                    <tr class="bg-success">
                        <th scope="row">90%</th>
                        <g:each in="${tankInfo.tanks}" var="tank">
                            <td>
                                <g:if test="${(tankInfo.tanks."${tank.key}".ullage).matches("\\d+")}">
                                    <b style="color:black">${((tankInfo.tanks."${tank.key}".ullage ?: 0) as int) - ((tankInfo.tanks."${tank.key}".fullvolume ?: 1) * 0.1).setScale(0, java.math.RoundingMode.HALF_UP)}</b>
                                </g:if>
                                <g:else>
                                    <b class="bg-danger">Error, Please update the tank Data again.</b>
                                </g:else>
                            </td>
                        </g:each>
                    </tr>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</g:each>
</div>

<style>
.grid-item {
    background: #fff;
    border: 1px solid #E6E9ED;
    width: 31%;
    margin:0 1% 5px;
    padding: 10px 10px 0px 10px;
    float: left;
    -webkit-column-break-inside: avoid;
    -moz-column-break-inside: avoid;
    column-break-inside: avoid;
    opacity: 1;
    display: inline-block;
}
@media only screen and (max-width: 960px) {
    .grid-item {
        background: #fff;
        border: 1px solid #E6E9ED;
        width: 100%;
        margin:0 1% 5px;
        padding: 10px 10px 0px 10px;
        float: left;
        -webkit-column-break-inside: avoid;
        -moz-column-break-inside: avoid;
        column-break-inside: avoid;
        opacity: 1;
        display: inline-block;
    }
}
</style>