$( document ).ready(function() {

	$(".vehile-model").change(function() {
		if ($(this).val() != "Make") {
			console.log("if");
			$('select.vehicle-color').selectmenu('enable');	
		} else {
			console.log("else");
			$('select.vehicle-color').selectmenu('disable');
		}
	});
	
});
