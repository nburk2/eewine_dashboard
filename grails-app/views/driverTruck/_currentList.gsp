<div class="x_panel">
    <div class="x_content">
        <p class="lead">Truck Drivers</p>
        <div class="table-responsive">
            <table class="table">
                <tbody>
                <g:each in="${driverTruckList}" var="driverTruck">
                    <tr>
                        <th style="width:50%">${driverTruck.driver.firstName}</th>
                        <td>${driverTruck?.truck?.number ?: "Off"}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>
</div>