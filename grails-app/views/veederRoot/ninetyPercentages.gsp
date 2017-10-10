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