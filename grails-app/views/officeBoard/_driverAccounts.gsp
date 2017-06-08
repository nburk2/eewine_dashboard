<g:each in="${driverAccounts}" var="driverAccount">
    <div class="grid-item">
        <div class="x_content">
            <p class="lead"><i class="fa fa-building-o"></i> ${driverAccount?.driver?.firstName}</p>
            <div class="table-responsive">
                <table class="table">
                    <tbody>
                    <g:each in="${driverAccount.accounts}" var="account">
                        <tr>
                            <g:if test="${account.numberOfTickets == 1}">
                                <th class="dashboard">${account.name}</th>
                            </g:if>
                            <g:else>
                                <th class="dashboard">${account.name} <small>"${account.numberOfTickets}"</small></th>
                            </g:else>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</g:each>
