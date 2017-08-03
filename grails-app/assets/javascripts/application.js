// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require moment.min
//= require weather
//= require bootstrap
//= require_tree gentelella
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}

$(document).ready(function(){
    // $(document).ready(function() {
        $('#menu_toggle').trigger("click");
    // })
    var $container = $('.grid-masonry');
    // initialize
    $container.masonry({
        // columnWidth: 50,
        itemSelector: '.grid-item',
        transitionDuration: 0.2
    });

    function updateTruckStatus(truckStatus) {
        for (var truck in truckStatus) {
            if (truckStatus[truck].keyOn === true) {
                if (truckStatus[truck].lastSpeed === 0) {
                    $("#truck-" + truckStatus[truck].label).attr('class', 'bg-info');
                } else {
                    $("#truck-" + truckStatus[truck].label).attr('class', 'bg-success');
                }
            } else {
                $("#truck-" + truckStatus[truck].label).attr('class', 'bg-danger');
            }
        }
    }

    function poll(fn, callback, errback, timeout, interval) {
        var endTime = Number(new Date()) + (timeout || 1000000);
        interval = interval || 360000;

        (function p() {
            // If the condition is met, we're done!
            if(fn()) {
                callback();
            }
            // If the condition isn't met but the timeout hasn't elapsed, go again
            else if (Number(new Date()) < endTime) {
                setTimeout(p, interval);
            }
            // Didn't match and too much time, reject!
            else {
                errback(new Error('timed out for ' + fn + ': ' + arguments));
            }
        })();
    }

// Usage:  ensure element is visible
    poll(
        function() {
            $.ajax({
                url: "/officeBoard/getLocations.json",
                type:"get",
                dataType: 'json',

                beforeSend: function(xhr) {
                    xhr.withCredentials = true;
                },
                success: function(json) {
                    updateTruckStatus(json)
                },
                error: function(xhr){
                    console.log("verizon location lookup failed"); //<----when no data alert the err msg
                }
            });
        },
        function() {
            // Done, success callback
        },
        function() {
            // Error, failure callback
        }
    );
});
