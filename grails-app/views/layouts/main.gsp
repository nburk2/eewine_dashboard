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
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>
        %{--<script>--}%
            %{--$(document).ready(function () {--}%
                %{--if(${controllerName == "driverTank"}) {--}%
                     %{--if(${driverTankList.length > 0}) {--}%
                        %{--for(var index=0;index < driverTankList.length;index++) {--}%
                            %{--var cloneArray = driverTankList.slice();--}%
%{--//                            cloneArray.splice(index,1);--}%
                            %{--var connectWithTables = ""--}%
                            %{--for(var connectIndex = 0; connectIndex < cloneArray.length; connnectIndex++) {--}%
                                %{--if((connectIndex != index) && ((connectIndex + 1) == cloneArray.length)) {--}%
                                    %{--connectWithTables += "#tables-" + connectIndex--}%
                                %{--} else if(((connectIndex + 2) == cloneArray.length) && (connectIndex + 1) == index) {--}%
                                    %{--connectWithTables += "#tables-" + connectIndex--}%
                                %{--} else if(connectIndex != index){--}%
                                    %{--connectWithTables += "#tables-" + connectIndex + ","--}%
                                %{--}--}%
%{--//                              Add one more check for the the input of tables if the index is in the last spot--}%
                            %{--}--}%
%{--//                            create table jquery data--}%
                            %{--$("#table-" + index).sortable({--}%
                                %{--connectWith: connectWithTables--}%
                            %{--});--}%
                        %{--}--}%
                     %{--} else {--}%
                         %{--$("#table-1").sortable({--}%
                             %{--connectWith: "#table-2,#table-3"--}%
                         %{--});--}%
%{--//                     } else {--}%
                         %{--$("#table-1").sortable({--}%
                             %{--connectWith: "#table-2,#table-3"--}%
                         %{--});--}%
                         %{--$("#table-2").sortable({--}%
                             %{--connectWith: "#table-1,#table-3"--}%
                         %{--});--}%
                         %{--$("#table-3").sortable({--}%
                             %{--connectWith: "#table-1,#table-2"--}%
                         %{--});--}%
                     %{--}--}%
                %{--}--}%
            %{--});--}%
        %{--</script>--}%
    </g:else>

    %{-- Scripts to run for specific views after javascript loads --}%
    <g:if test="${controllerName == 'veederRoot' && actionName == 'tankInfo'}">
        <g:render template="/veederRoot/tankInfoScripts"/>
    </g:if>
</body>
</html>
