$( document ).ready(function() {
	var addvehicle = "<label for=\"select-custom-20\" class=\"bold\">Vehicle Registration No</label>"+ 
	"<input type=\"text\" name=\"registration-number\" placeholder=\"Vehicle Registration Number\" class=\"registration-number\" />"+
	"<label for=\"select-custom-20\" class=\"bold label-margin\">Vehicle Model</label>"+     
	"<select name=\"vehile-model\" class=\"vehile-model\" id=\"select-custom-20\" data-native-menu=\"false\">"+
	"<option value=\"Make\" selected=\"selected\">Make</option>"+
	"<option value=\"Acura\" oid=\"2\">Acura</option>"+
	"<option value=\"BMW\" oid=\"5\">BMW</option>"+
	"<option value=\"Buick\" oid=\"7\">Buick</option>"+
	"<option value=\"Chevrolet\" oid=\"9\">Chevrolet</option>"+
	"<option value=\"Chrysler\" oid=\"10\">Chrysler</option>"+
	"<option value=\"Dodge\" oid=\"13\">Dodge</option>"+
	"<option value=\"FIAT\" oid=\"430\">FIAT</option>"+
	"<option value=\"Ford\" oid=\"15\">Ford</option>"+
	"<option value=\"GMC\" oid=\"16\">GMC</option>"+
	"<option value=\"Honda\" oid=\"18\">Honda</option>"+
	"<option value=\"Hyundai\" oid=\"20\">Hyundai</option>"+
	"<option value=\"Kia\" oid=\"25\">Kia</option>"+
	"<option value=\"Lincoln\" oid=\"28\">Lincoln</option>"+
	"<option value=\"Mazda\" oid=\"30\">Mazda</option>"+
	"<option value=\"Mitsubishi\" oid=\"34\">Mitsubishi</option>"+
	"<option value=\"Nissan\" oid=\"35\">Nissan</option>"+
	"<option value=\"Scion\" oid=\"45\">Scion</option>"+
	"<option value=\"Subaru\" oid=\"47\">Subaru</option>"+
	"<option value=\"Toyota\" oid=\"49\">Toyota</option>"+
	"<option value=\"Volkswagen\" oid=\"50\">Volkswagen</option>"+
	"</select>"+
	"<label for=\"select-custom-21\" class=\"bold label-margin\">Vehicle Color</label>"+
	"<select name=\"select-custom-21\" class=\"vehicle-color\" id=\"select-custom-21\" data-native-menu=\"false\" disable>"+
	"<option value=\"Color\">Color</option>           "+
	"<option value=\"Red\">Red</option>         "+
	"<option value=\"Black\">Black</option>"+
	"<option value=\"Blue\">Blue</option>"+
	"<option value=\"Grey\">Grey</option>"+
	"<option value=\"Green\">Green</option>"+
	"<option value=\"Yellow\">Yellow</option>"+
	"<option value=\"White\">White</option>"+
	"<option value=\"Cream\">Cream</option>"+
	"<option value=\"Orange\">Orange</option>"+
	"<option value=\"Brown\">Brown</option>"+
	"<option value=\"Pink\">Pink</option>"+
	"<option value=\"light blue\">Light Blue</option>"+
	"<option value=\"Golden\">Golden</option>"+
	"<option value=\"Meheroon\">Meheroon</option>"+
	"<option value=\"Others\">Others</option>     "+
	"</select>"+
	"<div class=\"save-form\">"+
		"<button type=\"submit\" data-theme=\"b\" name=\"sace\" value=\"submit-value\" class=\"save-form\">SAVE</button>"+
	"</div>";
	
	$(".add-vehicle").on("click", function(){
		var childbody = $(".parent-driver").children()
		$(".parent-driver").append(addvehicle);	
	});
	
});

$(document).on("pageinit","#vehicle-details-page",function(){
});
