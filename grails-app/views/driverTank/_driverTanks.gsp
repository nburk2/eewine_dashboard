<g:each in="${driverTankList}" var="driverTank">
    <div class="grid-item">
        <div class="x_content">
            <g:if test="${driverTank.driver.colorType == null}">
                <p><big><i class="fa fa-building-o"></i> ${driverTank?.driver?.firstName}</big></p>
            </g:if>
            <g:else>
                <p style="color: ${driverAccount.driver.colorType}"><big><i class="fa fa-building-o"></i> ${driverTank?.driver?.firstName}</big></p>
            </g:else>
            <div class="table-responsive">
                <table class="table">
                    <tbody>
                    <g:each in="${driverTank.tanks}" var="tank">
                        <tr>
                            %{--<g:if test="${tank.numberOfTickets == 1}">--}%
                                %{--<th class="dashboard"><g:if test="${tank.account.keyRequired}"><i class="fa fa-key pull-right"></i> </g:if>${account.name}</th>--}%
                            %{--</g:if>--}%
                            %{--<g:else>--}%
                                %{--<th class="dashboard"><g:if test="${tank.account.keyRequired}"><i class="fa fa-key pull-right"></i> </g:if>${account.name} <small>"${account.numberOfTickets}"</small></th>--}%
                            %{--</g:else>--}%
                            <g:if test="${tank.account.keyRequired}">
                                <th class="dashboard"><i class="fa fa-key pull-right"></i> </th>
                            </g:if>
                            <g:if test="${tank.account.openLock}">
                                <th class="dashboard">open</th>
                            </g:if>
                            <g:if test="${tank.account.combo}">
                                <th class="dashboard">combo</th>
                            </g:if>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</g:each>
