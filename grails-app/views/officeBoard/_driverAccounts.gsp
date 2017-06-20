<g:each in="${driverAccounts}" var="driverAccount">
    <div class="grid-item">
        <div class="x_content">
            <g:if test="${driverAccount.driver.colorType == null}">
                <p><big><i class="fa fa-building-o"></i> ${driverAccount?.driver?.firstName}</big></p>
            </g:if>
            <g:else>
                <p style="color: ${driverAccount.driver.colorType}"><big><i class="fa fa-building-o"></i> ${driverAccount?.driver?.firstName}</big></p>
            </g:else>
            <div class="table-responsive">
                <table class="table">
                    <tbody>
                    <g:each in="${driverAccount.accounts}" var="account">
                        <tr>
                            <g:if test="${account.numberOfTickets == 1}">
                                <th class="dashboard"><g:if test="${account.keyRequired}"><i class="fa fa-key pull-right"></i> </g:if>${account.name}</th>
                            </g:if>
                            <g:else>
                                <th class="dashboard"><g:if test="${account.keyRequired}"><i class="fa fa-key pull-right"></i> </g:if>${account.name} <small>"${account.numberOfTickets}"</small></th>
                            </g:else>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</g:each>
