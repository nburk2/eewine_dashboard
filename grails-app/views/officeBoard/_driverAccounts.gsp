<g:each in="${driverAccounts}" var="driverAccount">
    <div class="col-lg-2 col-md-2 col-sm-2 col-xs-3">
        <div class="x_panel">
            <div class="x_content">
                <p class="lead">${driverAccount?.driver?.firstName}</p>
                <div class="table-responsive">
                    <table class="table">
                        <tbody>
                        <g:each in="${driverAccount.accounts}" var="account">
                            <tr>
                                %{--<th class="dashboard" style="width:50%">${driverAccount?.driver?.firstName}</th>--}%
                                <th class="dashboard">${account.name}</th>
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</g:each>
