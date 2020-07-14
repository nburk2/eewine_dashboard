<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Driver</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <g:select name="driver" from="${dashboard.data.Driver.list([sort:"firstName"])}" class="select2_single form-control" optionKey="id" value="${driverTank?.driver?.id}" tabindex="-1"/>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Accounts</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <g:select name="tanks" size="7" from="${dashboard.data.tanks.list([sort:"name"])}" noSelection="['':'']" class="select2_single form-control" optionKey="id" value="${driverTank?.tanks?.id}" tabindex="-1" multiple="true"/>
    </div>
</div>
<div class="form-group">
    <label for="scheduledDay" class="control-label col-md-3 col-sm-3 col-xs-12">Scheduled Day</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker id="scheduledDay" name="scheduledDay" precision="day" relativeYears="[-3..10]" value="${driverTank?.scheduledDay ?: "none"}" noSelection="['':'']"/>
    </div>
</div>
<div class="ln_solid"></div>
<div class="form-group">
    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
        <g:link class="btn btn-primary" action="index">Cancel</g:link>

        <g:if test="${actionName == "create" || actionName == "save"}">
            <g:submitButton name="create" type="submit" class="btn btn-success" value="Create"/>
        </g:if>
        <g:else>
            <g:submitButton name="update" type="submit" class="btn btn-success" value="Update"/>
        </g:else>

    </div>
</div>