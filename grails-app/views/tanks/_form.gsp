<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Show Tank</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="showTank" class="js-switch" checked="${tanks?.showTank}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Monday</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="monday" class="js-switch" checked="${tanks?.monday}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tuesday</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="tuesday" class="js-switch" checked="${tanks?.tuesday}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Wednesday</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="wednesday" class="js-switch" checked="${tanks?.wednesday}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Thursday</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="thursday" class="js-switch" checked="${tanks?.thursday}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Friday</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="friday" class="js-switch" checked="${tanks?.friday}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Saturday</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="saturday" class="js-switch" checked="${tanks?.saturday}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Sunday</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="sunday" class="js-switch" checked="${tanks?.sunday}" />
            </label>
        </div>
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