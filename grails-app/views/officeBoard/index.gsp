<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to the Wine Energy Portal</title>
</head>
<body>
    <div class="right_col" role="main">
        <div class="row">
            <div class="col-md-4 col-sm-6 col-xs-12">

                <g:render template="weather"/>

                <div class="row">
                    <div class="grid-masonry">
                        <g:render template="truckDrivers"/>
                        <g:render template="driverAccounts"/>
                    </div>
                </div>
            </div>

            %{--<div class="clearfix"></div>--}%

            <div class="col-md-8 col-sm-8 col-xs-12">
                <div class="row">
                    <div class="col-md-3 col-sm-2 col-xs-12">
                        <g:render template="notes"/>
                    </div>
                    <div class="col-lg-9 col-md-9 col-sm-10 col-xs-12">
                        %{--<iframe src="https://col-xs-12alendar.google.com/calendar/embed?height=600&amp;wkst=1&amp;bgcolor=%23FFFFFF&amp;src=190bua44b6u2m6n799sqmsnbvd4mg4qr%40import.calendar.google.com&amp;color=%23182C57&amp;ctz=America%2FNew_York" style="border-width:0" width="100%" height="400px" min-height="100%" frameborder="0" scrolling="no"></iframe>--}%
                        <iframe src="https://outlook.office365.com/owa/calendar/38d674a96a4c4a398cb40dd6e631082f@eewine.com/2e86edcb534e4f679696128e42d4dd3f2706831291944545199/calendar.html" style="border-width:0" width="100%" height="400px" min-height="100%" frameborder="0" allowfullscreen="true" scrolling="yes"></iframe>
                    </div>
                </div>

                <div class="row">
                    <!--Drivers table -->
                    <g:render template="drivers"/>
                    %{--Truck table--}%
                    <g:render template="trucks"/>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
