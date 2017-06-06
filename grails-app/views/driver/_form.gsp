<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstName">First Name <span class="required">*</span>
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="firsName" name="firstName" value="${driver.firstName}" required="required" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastName">Last Name <span class="required">*</span>
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="lastName" name="lastName" value="${driver.lastName}" required="required" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label for="medCardExpDate" class="control-label col-md-3 col-sm-3 col-xs-12">Med Card Exp Date</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker id="medCardExpDate" name="medCardExpDate" precision="day" relativeYears="[-20..1]" value="${driver?.medCardExpDate}"/>
    </div>
</div>
<div class="form-group">
    <label for="driversLicenseExpDate" class="control-label col-md-3 col-sm-3 col-xs-12">Drivers License exp.</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker name="driversLicenseExpDate" precision="day" relativeYears="[-20..1]" value="${driver?.driversLicenseExpDate}"/>
    </div>
</div>
<div class="form-group">
    <label for="hazmatExpDate" class="control-label col-md-3 col-sm-3 col-xs-12">Hazmat exp.</label>
    %{--<div class="col-md-6 xdisplay_inputx form-group has-feedback">--}%
    %{--<input class="form-control has-feedback-left" id="single_cal4" placeholder="First Name" aria-describedby="inputSuccess2Status4" type="text">--}%
    %{--<span class="fa fa-calendar-o form-control-feedback left" aria-hidden="true"></span>--}%
    %{--<span id="inputSuccess2Status4" class="sr-only">(success)</span>--}%
    %{--</div>--}%
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker name="hazmatExpDate" precision="day" relativeYears="[-20..1]" value="${driver?.hazmatExpDate}"/>
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