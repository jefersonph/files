$(function() {
	$( "#file" ).dialog({
		modal: true,
		beforeClose: function(event, ui) { 
			window.history.back();
		}
	});
});