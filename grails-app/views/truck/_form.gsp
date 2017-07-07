<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">Number <span class="required">*</span>
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="number" id="number" name="number" value="${truck.number}" required="required" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="modelYear">Model Year<span class="required">*</span>
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="number" id="modelYear" name="modelYear" value="${truck.modelYear}" required="required" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label for="stateInspectionExpDate" class="control-label col-md-3 col-sm-3 col-xs-12">State Inspection</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker id="stateInspectionExpDate" name="stateInspectionExpDate" precision="day" relativeYears="[-5..5]" value="${truck?.stateInspectionExpDate}" noSelection="['':'']"/>
    </div>
</div>
<div class="form-group">
    <label for="tankVKExpDate" class="control-label col-md-3 col-sm-3 col-xs-12">Tank VK</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker name="tankVKExpDate" precision="day" relativeYears="[-150..2000]" value="${truck?.tankVKExpDate}" noSelection="['':'']"/>
    </div>
</div>
<div class="form-group">
    <label for="tankIPExpDate" class="control-label col-md-3 col-sm-3 col-xs-12">Tank IP</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker name="tankIPExpDate" precision="day" relativeYears="[-5..5]" value="${truck?.tankIPExpDate}" noSelection="['':'']"/>
    </div>
</div>
<div class="form-group">
    <label for="tankIPExpDate" class="control-label col-md-3 col-sm-3 col-xs-12">Airport</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker name="airportExpDate" precision="day" relativeYears="[-5..5]" value="${truck?.airportExpDate}" noSelection="['':'']"/>
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