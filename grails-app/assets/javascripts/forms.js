// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require moment.min
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
    var $container = $('.grid-masonry');
    // initialize
    $container.masonry({
        // columnWidth: 50,
        itemSelector: '.grid-item',
        transitionDuration: 0.2
    });
});