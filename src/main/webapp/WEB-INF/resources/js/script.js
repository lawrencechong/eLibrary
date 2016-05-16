$(document).ready(function() {
	
	// search results list and grid
    $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');});
    $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');});

    $('.ui.rating')
    .rating('setting', 'onRate', function(value) {
    	debugger
    	window.location.href = '/user/rate/book/' + $(this).data('id') + '/rating/' + value;
    });
});