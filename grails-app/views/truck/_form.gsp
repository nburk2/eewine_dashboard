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
        <g:datePicker id="stateInspectionExpDate" name="stateInspectionExpDate" precision="day" relativeYears="[-3..10]" value="${truck?.stateInspectionExpDate ?: "none"}" noSelection="['':'']"/>
    </div>
</div>
<div class="form-group">
    <label for="tankVKExpDate" class="control-label col-md-3 col-sm-3 col-xs-12">Tank VK</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker name="tankVKExpDate" precision="day" relativeYears="[-3..10]" value="${truck?.tankVKExpDate ?: "none"}" noSelection="['':'']"/>
    </div>
</div>
<div class="form-group">
    <label for="tankIPExpDate" class="control-label col-md-3 col-sm-3 col-xs-12">Tank IP</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker name="tankIPExpDate" precision="day" relativeYears="[-3..10]" value="${truck?.tankIPExpDate ?: "none"}" noSelection="['':'']"/>
    </div>
</div>
<div class="form-group">
    <label for="tankIPExpDate" class="control-label col-md-3 col-sm-3 col-xs-12">Airport</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker name="airportExpDate" precision="day" relativeYears="[-3..10]" value="${truck?.airportExpDate ?: "none"}" noSelection="['':'']"/>
    </div>
</div>
<div class="form-group">
    <label for="tag" class="control-label col-md-3 col-sm-3 col-xs-12">Tag</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker name="tag" precision="day" relativeYears="[-3..10]" value="${truck?.tag ?: "none"}" noSelection="['':'']"/>
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