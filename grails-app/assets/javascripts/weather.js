
$(document).ready(function(){
    // loadWeather('Manassas',''); //@params location, woeid
    // loadGeolocation();
});


function loadGeolocation() {
    navigator.geolocation.getCurrentPosition(function(position) {
        console.log(position.coords.latitude+','+position.coords.longitude)
        loadWeather(position.coords.latitude+','+position.coords.longitude); //load weather using your lat/lng coordinates
    });
}

function loadWeather(location, woeid) {
    $.simpleWeather({
        location: location,
        woeid: '',
        unit: 'f',
        success: function(weather) {
            html = '<h2><i class="icon-'+weather.code+'" style="font-size:60px"></i> '+weather.temp+'&deg;'+weather.units.temp+'</h2>';
            html += '<ul><li>'+weather.city+', '+weather.region+'</li>';
            html += '<li>'+weather.text+'</li></ul>';
            forecasthtml = '';
            for(var i=1;i < 4;i++){
                forecasthtml += '<tr><th>'+weather.forecast[i].day+'</th>';
                forecasthtml += '<th>'+weather.forecast[i].high+'&deg;</th>';
                forecasthtml += '<th>'+weather.forecast[i].low+'&deg;</th>';
                forecasthtml += '<th>'+weather.forecast[i].text+'</th></tr>';
            }
            forecasthtml += '</tbody>';

            $("#weather").html(html);
            $("#forecast").html(forecasthtml);
        },
        error: function(error) {
            $("#weather").html('<p>'+error+'</p>');
            $("#forecast").html('<p>'+error+'</p>');
        }
    });
}
