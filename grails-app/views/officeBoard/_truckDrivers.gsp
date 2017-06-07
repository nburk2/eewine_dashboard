<div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
    <div class="x_panel">
        <div class="x_content">
            <p class="lead">Truck Drivers</p>
            <div class="table-responsive">
                <table class="table">
                    <tbody>
                    <g:each in="${driverTruckList}" var="driverTruck">
                        <tr>
                            <th class="dashboard" style="width:50%">${driverTruck.driver.firstName}</th>
                            <td class="dashboard">${driverTruck?.truck?.number ?: "Off"}</td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>