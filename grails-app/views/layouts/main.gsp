<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="WineEnergyPortal"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <asset:link rel="icon" href="wine-logo.png" type="image/x-ico" />
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>EEWine | </title>

    <g:layoutHead/>
</head>
<body  class="nav-md">

    <div class="container body">
        <div class="main_container">

            <g:render template="/layouts/side_nav"/>

            <g:layoutBody/>

            <g:render template="/layouts/main_footer"/>

        </div>
    </div>

    <g:if test="${controllerName == 'officeBoard'}">
        <asset:javascript src="application.js"/>
    </g:if>
    <g:else>
        <asset:javascript src="forms.js"/>
    </g:else>

</body>
</html>
