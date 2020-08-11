%{--<g:form id="demo-form2" url="[resource:driverTank, action:'edit']" params="[scheduledDate:scheduledDate]" class="form-horizontal form-label-left">--}%
<g:each in="${driverTankList}" var="driverTank">
    <div class="grid-item">
        <div class="x_content">
            <p style="margin-top: -10px;margin-bottom: 0px;" class="text-center"><big><b>
                ${dashboard.data.DriverTruck.findByDriver(driverTank.driver).truck.number}
            </b></big></p>
            <g:if test="${driverTank.driver.colorType == null}">
                <p style="color:black;" class="text-center"><big><b>
                    <g:link action="edit" params="[driverTank:driverTank,scheduledDate:scheduledDate]">
                        ${driverTank?.driver?.firstName}
                    </g:link>
                </b></big></p>
            </g:if>
            <g:else>
                <p style=";background-color: ${driverTank.driver.colorType};color:black;" class="text-center"><big><b>
                <g:link action="edit" params="[driverTank:driverTank,scheduledDate:scheduledDate]">
                    ${driverTank?.driver?.firstName}
                </g:link>
                </b></big></p>
            </g:else>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <tbody>
                    <g:if test="${driverTank.loadTime}">
                        <tr class="bg-warning">
                            <td colspan="3" style="color:black;" class="dashboard text-center"> <b>${driverTank.loadTime}</b></td>
                        </tr>
                    </g:if>
                    <g:each in="${driverTank.tanks}" var="tank">
                        <tr>

                            <th class="dashboard">${tank.account.number} (${tank.tankNum})</th>
                            <th class="dashboard">${tank.account.name}</th>
                            <g:if test="${tank.account.keyRequired}">
                                <th class="dashboard">Key <i class="fa fa-key pull-right"></i></th>
                            </g:if>
                            <g:elseif test="${tank.account.combo}">
                                <th class="dashboard">combo <i class="fa fa-calculator pull-right"></i></th>
                            </g:elseif>
                            <g:else test="${tank.account.openLock}">
                                <th class="dashboard">Open</th>
                            </g:else>
                        </tr>
                    </g:each>
                    <g:if test="${driverTank.startTime}">
                        <tr>
                            <td colspan="3" style="color:black" class="dashboard text-center"> <b>${driverTank.startTime}</b></td>
                        </tr>
                    </g:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</g:each>
%{--</g:form>--}%
<div class="grid-item">
    <div class="x_content">
        <p style="margin-top: -10px;margin-bottom: 0px;" class="text-center"><big><b>123</b></big></p>
        <p style="background-color:red;color:black;" class="text-center">
            %{--<g:actionSubmit name="edit${driverTank.driver.id}" type="submit" value="${driverTank.driver}"/>--}%
            <big><b><g:link action="edit" params="[driverTank:driverTank]">Brandon</g:link></b></big>
        </p>

        <div class="table-responsive">
            <table class="table table-bordered table-hovor">
                <tbody>
                <tr class="bg-warning">
                    <td colspan="3" style="color:black;" class="dashboard text-center"> <b>Load after shift</b></td>
                </tr>
                <tr>
                    <td class="dashboard">54321 </td>
                    <td class="dashboard">CBS Spring </td>
                    <td class="dashboard">combo <i class="fa fa-calculator pull-right"></i></td>
                </tr>
                <tr>
                    <td class="dashboard">123456 </td>
                    <td class="dashboard">CBS Spring </td>
                    <td class="dashboard">Key <i class="fa fa-key pull-right"></i></td>
                </tr>
                <tr>
                    <td colspan="3" style="color:black" class="dashboard text-center"> <b>After 5</b></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
    <div class="grid-item">
        <div class="x_content">
                <p style="background-color:lightblue;color:black;" class="text-center"><big><b>Johnson</b></big></p>
            <div class="table-responsive">
                <table class="table table-bordered">
                    <tbody>
                        <tr>
                                <td class="dashboard">123456 (1)</td>
                                <td class="dashboard">CBS Spring </td>
                                <td class="dashboard">Key <i class="fa fa-key pull-right"></i></td>
                        </tr>
                        <tr>
                            <td class="dashboard">54321 </td>
                            <td class="dashboard">CBS Spring </td>
                            <td class="dashboard">Open</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

