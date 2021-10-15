<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'ninetyPercentages.label', default: 'Ninety Percentages')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>
        <g:if test="${error}">
            <div class="alert alert-danger" role="alert">
                ${error}
            </div>
        </g:if>

        <div class="row">
            <div class="x_panel">
                <div class="x_content">
                    <div class="x_title">
                        <h2 class="3rem">DTN Prices - Today <small class="invisible">--</small></h2>
                        <g:form action="ninetyPercentages">
                            <g:datePicker id="priceDate" name="priceDate" precision="hour" relativeYears="[-3..0]" value="${priceDate}"/>
                            <input type="submit" class="btn btn-success" value="Update">
                        </g:form>
                        %{--<div class="clearfix"></div>--}%
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <g:render template="ninetyPercentage"/>
        </div>
        <div class="row">
            <g:form url="[resource:veederRoot, action:'updateVeederRootData']" class="form-horizontal form-label-left">
                <g:submitButton name="update" type="submit" class="btn btn-success" value="Update Tank Data"/>
            </g:form>
        </div>

    </div>

</div>

</body>
</html>