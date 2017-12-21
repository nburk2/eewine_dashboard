<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'wineenergy.label', default: 'FuelPrice')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
<!-- page content -->
<div class="right_col" role="main">
    <div class="">

        <div class="clearfix"></div>
        <g:if test="${flash.info}">
            <div class="alert alert-info" role="alert">
                <strong>Added to Print Que!</strong> Prints every half hour on the hour.
            </div>
        </g:if>

        <div class="row">
            <g:render template="dtnPriceTable"/>
        </div>
        <div class="row">
            <g:render template="priceTable"/>
        </div>

    </div>
</div>
<!-- /page content -->

</body>
</html>