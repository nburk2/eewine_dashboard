<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Field Name <span class="required">*</span>
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:if test="${wineEnergy?.hasErrors()}">
            <div class="alert alert-danger">
                <g:renderErrors bean="${wineEnergy}" as="list" field="name"/>
            </div>
        </g:if>
        <input type="text" id="name" name="name" value="${wineEnergy?.name}" required="required" class="form-control col-md-7 col-xs-12">
    </div>
    <div class="col-md-3 col-sm-3">
        <div class="alert alert-info">
            * Name can only consist of letters and hyphens(-)
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="numberOfTickets">Value <span class="required">*</span>
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="value" name="value" value="${wineEnergy?.value}" required="required" class="form-control col-md-7 col-xs-12">
    </div>
</div>

<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="numberOfTickets">Description <span class="required">*</span>
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="description" name="description" value="${wineEnergy?.description}" class="form-control col-md-7 col-xs-12">
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

<script>

</script>