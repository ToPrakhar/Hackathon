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
	    
	    location.href = "register.html";
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

							
							
							
							
							
							
							