function showImage(){
			if($(".emailpwd").val().length==6 && $(".phonepwd").val().length==4){
				$(".ui-block-d").css('display','block');
				$( ".message-log" ).replaceWith( '<div class="message-log">All Fields Complete, Please Verify</div>' );
				$( ".message-log" ).fadeOut(4000);
				}
			 else if($( ".emailpwd" ).val().length == 6 && $(".phonepwd").val().length==0){
				  $( ".message-log" ).replaceWith( '<div class="message-log">Now Please Fill Phone Password</div>' );
				  $( ".message-log" ).fadeOut(4000);
				  $(".phonepwd").focus();
				}
			  else if($( ".phonepwd" ).val().length == 4 && $( ".emailpwd" ).val().length == 0){
				  $( ".message-log" ).replaceWith( '<div class="message-log">Now Please Fill Email Password</div>' );
				  $( ".message-log" ).fadeOut(4000);
				  $(".emailpwd").focus();
			  }
			else{
				$(".ui-block-d").css('display','none');
			}	
		}