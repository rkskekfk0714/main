$("#username").focusout(function(){

	     if($('#username').val() == ""){
	   		$('#check').text('아이디를 입력해주세요.');
	   	  	$('#check').css('color', 'red');

	     }else{
	    	 $('#check').hide();
	     }
	     });

$("#name").focusout(function(){
	     if($('#name').val() == ""){
	   	 $('#check').text('이름을 입력해주세요');
	   	 $('#check').css('color', 'red');
	     }else{
	    	 $('#check').hide();
	     }
});

$("#email").focusout(function(){
	     if($('#email').val() == ""){
	   	 $('#check').text('이메일을 입력해주세요');
	   	 $('#check').css('color', 'red');
	     }else{
	    	 $('#check').hide();
	     }
});