<%@ page import="dashboard.data.Note" %>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="message">Message <span class="required">*</span>
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="message" name="message" value="${note.message}" required="required" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Message Type</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <g:select name="messageType" from="${dashboard.data.Note.MessageType}" class="select2_single form-control" optionValue="prettyName" value="${note?.messageType}" tabindex="-1"/>
    </div>
</div>
<div class="form-group">
    <label for="useFrom" class="control-label col-md-3 col-sm-3 col-xs-12">Use From</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker id="useFrom" name="useFrom" precision="day" relativeYears="[-5..10]" value="${note?.useFrom}"/>
    </div>
</div>
<div class="form-group">
    <label for="useTo" class="control-label col-md-3 col-sm-3 col-xs-12">Use To</label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker name="useTo" precision="day" relativeYears="[-5..10]" value="${note?.useTo}"/>
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