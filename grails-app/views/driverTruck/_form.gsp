<%@ page import="dashboard.data.Driver" %>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Driver</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <g:select name="driver" from="${dashboard.data.Driver.list()}" class="select2_single form-control" optionKey="id" value="${driverTruck?.driver?.id}" tabindex="-1"/>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Truck</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <g:select name="truck" from="${dashboard.data.Truck.list()}" noSelection="['':'']" class="select2_single form-control" optionKey="id" value="${driverTruck?.truck?.id}" tabindex="-1"/>
    </div>
</div>
%{--<div class="form-group">--}%
    %{--<label for="useDate" class="control-label col-md-3 col-sm-3 col-xs-12">Use Date</label>--}%
    %{--<div class="col-md-6 col-sm-6 col-xs-12">--}%
        %{--<g:datePicker name="useDate" precision="day" relativeYears="[-5..5]" value="${driverTruck?.useDate}"/>--}%
    %{--</div>--}%
%{--</div>--}%
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Driver Off</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="off" class="js-switch" checked="${driverTruck?.off}" />
            </label>
        </div>
    </div>
</div>
<div class="ln_solid"></div>
<div class="form-group">
    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
        <g:link class="btn btn-primary" id="${driverTruck?.id}" action="show">Cancel</g:link>

        <g:if test="${actionName == "create" || actionName == "save"}">
            <g:submitButton name="create" type="submit" class="btn btn-success" value="Create"/>
        </g:if>
        <g:else>
            <g:submitButton name="update" type="submit" class="btn btn-success" value="Update"/>
        </g:else>

    </div>
</div>