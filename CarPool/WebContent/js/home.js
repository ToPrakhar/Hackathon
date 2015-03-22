$( document ).on( "pageinit", "#home-page", function() {
    $( document ).on( "swipeleft swiperight", "#demo-page", function( e ) {
        // We check if there is no open panel on the page because otherwise
        // a swipe to close the left panel would also open the right panel (and v.v.).
        // We do this by checking the data that the framework stores on the page element (panel: open).
        if ( $.mobile.activePage.jqmData( "panel" ) !== "open" ) {
            if ( e.type === "swipeleft"  ) {
                $( "#right-panel" ).panel( "open" );
            } else if ( e.type === "swiperight" ) {
                $( "#left-panel" ).panel( "open" );
            }
        }
    });
});

$( document ).ready(function() {

$(".moredetails").on("click", function(){
	$(this).parent().siblings(".moredetail-child").slideToggle("fast");	
});

$(".logout").on("click", function(){
	 	var cookies = document.cookie.split(";");

	    for (var i = 0; i < cookies.length; i++) {
	    	var cookie = cookies[i];
	    	var eqPos = cookie.indexOf("=");
	    	var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
	    	document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
	    }
	    
	    location.href = "#home-page-register";
});


authenticated= getCookie("auth");

// if user is already authenticated redirect to jsp page
if(authenticated=='true')
	{
	window.location = 'Index.html';
	}

//hard coded user name and password
$( "#submitPassword" ).click(function() {
	if($('#existing-email').val()=='rider@infosys.com'&& $('#password').val()=='12345')
		{
		setCookie('auth',true,5);
		window.location = 'Index.html';
		}
	else
		{
		$( "#errorPopup" ).popup("open");
		}
	});

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires ;
} 

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) == 0) return c.substring(name.length,c.length);
    }
    return "";
}

$( ".invite-friend" ).click(function() {
	if($.isNumeric($('.invite').val())){
		var url="sendmail?email=null"+"&mobile="+$('#mobileNumber').val();
	}
	else{
		var url="sendmail?email="+$('#email').val()+"&mobile=null";
	}
	var jqxhr = $.get( url, function() {
		$( "#successPopup" ).popup("open");
		setTimeout(function(){ 
			window.location = 'Index.html';
			}, 2000);
		});
});


$( "#register" ).click(function() {

		var url="sendmail?email="+$('#email').val()+"&mobile="+$('#mobileNumber').val();
		var jqxhr = $.get( url, function() {
			$( "#successPopup" ).popup("open");
			setTimeout(function(){ 
				window.location = 'Authentication.html';
				}, 2000);
			});
});

var addvehicle = "<div class=\"form-child\"><label for=\"select-custom-20\" class=\"bold\">Vehicle Registration No</label>"+ 
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
"</div></div>";

$(".add-vehicle").on("click", function(){
	$(".parent-driver").append(addvehicle).trigger('create');	
});

$("#new-user-tap").on("click", function(){
	$(".returning-user").hide();
	$(".new-user").show();
});

$("#old-user-tap").on("click", function(){
	$(".new-user").hide();
	$(".returning-user").show();
});

$("#paid-tap").on("click", function(){
});

$("#unpaid-tap").on("click", function(){
	setTimeout(function(){$("#loadingdemo").show(); }, 1000);
});

$("#unpaid-tap").on("click", function(){
	setTimeout(function(){$("#loadingdemo").show(); }, 1000);
});

$( ".ui-authenticate-form" ).submit(function( event ) {
	//authentication successful
	//make ajax call if no hard coding
  if ( $( ".emailpwd" ).val() === "123456" && $( ".phonepwd" ).val() === "1234") {
   $( ".ui-authenticate-form" ).fadeOut("slow");
   $(".middle-body").fadeOut("slow");
   $( ".ui-post-authenticate-form" ).fadeIn( 5000 );
   $("#last-body2").fadeIn( 5000 );
   event.preventDefault();
  }
});

$( ".set-password" ).click(function( event ) {
	if($(".post-authentication1").val()!=$(".post-authentication2").val()){
		$( ".message-log2" ).replaceWith( '<div class="message-log2">Both Passwords does not match </div>' );
		$( ".message-log2" ).fadeOut(4000);
		event.stopPropagation();
		event.preventDefault();
		}
	});

});


$(document).on("pageinit",function(){
	  
	var listvariable ="<div class=\"child \">"+
	"<div class=\"child-99 text-align bold\">"+
	"<div class=\"child-70\">Black Camry MH-14 5463</div>"+
	"<div class=\"child-30\"> Trip Cost: 5$</div>"+
	"<div class=\"child-70\">Time 6PM-7PM</div>"+
	"<div class=\"child-30\"><a class=\"button\">Book</a></div>"+
	"<div class=\"child-100 text-align\">"+
	"<a class=\"button font-12 moredetails\">More Details</a></div>"+
	"<div class=\"child-100 text-align moredetail-child bold\">"+
	"<div class=\"line\"></div>"+
	"<div class=\"child-50\">prakhar_gupta06@infosys.com</div>"+
	"<div class=\"child-50\">Mobile Num: 678-697-8784</div>"+
	"<div class=\"child-50 charity\"></div>"+
	"<div class=\"child-50 rating\">7/7 Rating</div>"+
	"<div class=\"child-100\">North Springs --> Sandy Springs --> Dunwoody  --> Buckhead</div></div></div></div>"
					

$(".parent-list").append(listvariable + listvariable + listvariable + listvariable);							
					
});

//to hide the note section of reset password
$(document).on('pageinit',".authentication-page",function (){ 
	   var page = $('.authentication-page'); 
       page.find('#last-body2').hide();
       page.find('.ui-post-authenticate-form').hide();
	     });



function insertUser(){
	
var inputData = '{"userName":"ashwani","password":"'+$(".post-authentication1").val()+'"}';
	
$.ajax({
    url : 'service/insertUser',
    type : "POST",
    accepts : "application/json",
    data : inputData,
    dataType : "json",
    headers : {
    Accept : "application/json"
   },
     error : function(data) {
	     
    },
    contentType : "application/json; charset=utf-8",
    
    // Populate data in accordian
    success : function(data) {
        }
});
}							
							
							
							
							
							
							
