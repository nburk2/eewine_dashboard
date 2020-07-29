<g:each in="${driverTankList}" var="driverTank">
    <div class="grid-item">
        <div class="x_content">
            <g:if test="${driverTank.driver.colorType == null}">
                <p style="color:black;" class="text-center"><big><b>${driverTank?.driver?.firstName}</b></big></p>
            </g:if>
            <g:else>
                <p style="background-color:red;color:black;" class="text-center"><big><b>Brandon</b></big></p>
                <p style=";background-color: ${driverTank.driver.colorType};color:black;"><big><b> ${driverTank?.driver?.firstName}</b></big></p>
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
<div class="grid-item">
    <div class="x_content">
        <p style="background-color:red;color:black;" class="text-center"><big><b>Brandon</b></big></p>

        <div class="table-responsive">
            <table class="table table-bordered">
                <tbody>
                <tr class="bg-warning">
                    <td colspan="3" style="color:black;" class="dashboard text-center"> <b>Load after shift</b></td>
                </tr>
                <tr>
                    <th class="dashboard">54321 </th>
                    <th class="dashboard">CBS Spring </th>
                    <th class="dashboard">combo <i class="fa fa-calculator pull-right"></i></th>
                </tr>
                <tr>
                    <th class="dashboard">123456 </th>
                    <th class="dashboard">CBS Spring </th>
                    <th class="dashboard">Key <i class="fa fa-key pull-right"></i></th>
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
                                <th class="dashboard">123456 (1)</th>
                                <th class="dashboard">CBS Spring </th>
                                <th class="dashboard">Key <i class="fa fa-key pull-right"></i></th>
                        </tr>
                        <tr>
                            <th class="dashboard">54321 </th>
                            <th class="dashboard">CBS Spring </th>
                            <th class="dashboard">Open</th>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

