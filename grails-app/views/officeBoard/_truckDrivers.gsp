<div class="grid-item">
    <div class="x_content">
        <p class="lead"><i class="fa fa-truck"></i> Drivers</p>
        <div class="table-responsive">
            <table class="table">
                <tbody>
                <g:each in="${driverTruckList}" var="driverTruck">
                    <tr id="truck-${driverTruck?.truck?.number ?: "none"}">
                        <th class="dashboard" style="width:50%">${driverTruck.driver.firstName}</th>
                        <td class="dashboard">${driverTruck?.truck?.number ?: "Off"}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>
</div>