<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Account</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <g:select name="account" from="${dashboard.clientData.ClientAccounts.list([sort:"name"])}" class="select2_single form-control" optionValue="name" optionKey="id" value="${tank?.account?.id}" tabindex="-1"/>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="number">Number
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="number" name="number" value="${tank.number}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="creationDate">Timestamp
    </label>
    %{--<div class="col-md-6 col-sm-6 col-xs-12">--}%
        %{--<input type="text" id="timeStamp" name="timeStamp" value="${tank.timeStamp}" class="form-control col-md-7 col-xs-12">--}%
    %{--</div>--}%
    <div class="col-md-6 col-sm-6 col-xs-12">
        <g:datePicker name="creationDate" precision="time" relativeYears="[-5..10]" value="${tank?.creationDate ?: "none"}"/>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="address">Address
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="address" name="address" value="${tank.address}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="location">Location
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="location" name="location" value="${tank.location}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="tankOwnership">Tank Ownership
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="tankOwnership" name="tankOwnership" value="${tank.tankOwnership}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="serialNumber">Serial Number
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="serialNumber" name="serialNumber" value="${tank.serialNumber}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="manufacturer">Manufacturer
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="manufacturer" name="manufacturer" value="${tank.manufacturer}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="size">Size
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="number" id="size" name="size" value="${tank.size}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="type">Type
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="type" name="type" value="${tank.type}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="product">Product
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="product" name="product" value="${tank.product}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Properly Labeled</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="properlyLabeled" class="js-switch" checked="${tank?.properlyLabeled}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tertiary Containment</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="tertiaryContainment" class="js-switch" checked="${tank?.tertiaryContainment}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Painted</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="painted" class="js-switch" checked="${tank?.painted}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="color">Color
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="color" name="color" value="${tank.color}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="paintCondition">Paint Condition
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="paintCondition" name="paintCondition" value="${tank.paintCondition}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Wine Energy Decal</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="wineEnergyLogo" class="js-switch" checked="${tank?.wineEnergyLogo}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="logoCondition">Logo Condition
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="logoCondition" name="logoCondition" value="${tank.logoCondition}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="pumpType">Pump Type
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="pumpType" name="pumpType" value="${tank.pumpType}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="pumpCondition">Pump Condition
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="pumpCondition" name="pumpCondition" value="${tank.pumpCondition}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="pumpPartNumber">Pump Part Number
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="pumpPartNumber" name="pumpPartNumber" value="${tank.pumpPartNumber}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="numberOfDispensers">Number Of Dispensers
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="number" id="numberOfDispensers" name="numberOfDispensers" value="${tank.numberOfDispensers}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="nozzleType">Nozzle Type
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="nozzleType" name="nozzleType" value="${tank.nozzleType}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="hoseGaugeLength">Hose Gauge Length
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="hoseGaugeLength" name="hoseGaugeLength" value="${tank.hoseGaugeLength}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="filterType">Filter Type
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="filterType" name="filterType" value="${tank.filterType}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="filterPartNumber">Filter Part Number
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="filterPartNumber" name="filterPartNumber" value="${tank.filterPartNumber}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="filterCondition">Filter Condition
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="filterCondition" name="filterCondition" value="${tank.filterCondition}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Ecogreen</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="ecogreen" class="js-switch" checked="${tank?.ecogreen}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="ecogreenSerialNumber">Ecogreen Serial Number
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="ecogreenSerialNumber" name="ecogreenSerialNumber" value="${tank.ecogreenSerialNumber}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12">Tank Gauge</label>
    <div class="col-md-9 col-sm-9 col-xs-12">
        <div class="">
            <label>
                <g:checkBox name="tankGauge" class="js-switch" checked="${tank?.tankGauge}" />
            </label>
        </div>
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="comments">Comments
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        <input type="text" id="comments" name="comments" value="${tank.comments}" class="form-control col-md-7 col-xs-12">
    </div>
</div>
<div class="form-group">
    <label class="control-label col-md-R3 col-sm-3 col-xs-12" for="tankImage">Image File
    </label>
    <div class="col-md-6 col-sm-6 col-xs-12">
        %{--<g:submitButton action="uploadTankImage" name="uploadTankImage" type="submit" class="btn btn-success" value="Upload Tanks Image"/>--}%
        <g:link class="btn btn-primary" params="[id:tank.id]" action="uploadTankImage">Upload Tanks Image</g:link>
        %{--<input class="" type="file" name="tankImage" accept="image/*">--}%
        %{--<input type="text" id="imageUrl" name="imageUrl" value="${tank.imageUrl}" required="required" class="form-control col-md-7 col-xs-12">--}%
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