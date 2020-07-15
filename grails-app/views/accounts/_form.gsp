<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Account Name <span class="required">*</span>
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="name" name="name" value="${accounts.name}" required="required" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Show Account</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="showAccount" class="js-switch" checked="${accounts?.showAccount}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Key Required</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="keyRequired" class="js-switch" checked="${accounts?.keyRequired}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Open Lock</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="openLock" class="js-switch" checked="${accounts?.openLock}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Combo</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="combo" class="js-switch" checked="${accounts?.combo}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Show Account</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="show" class="js-switch" checked="${accounts?.show}" />
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