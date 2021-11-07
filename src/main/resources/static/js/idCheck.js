function openIdChk(){

    window.name = "parentForm";
    window.open("/idCheckForm",
            "chkForm", "width=500, height=300, resizable = no, scrollbars = no");
}

// 아이디 입력창에 값 입력시 hidden에 idUncheck를 세팅한다.
        // 이렇게 하는 이유는 중복체크 후 다시 아이디 창이 새로운 아이디를 입력했을 때
        // 다시 중복체크를 하도록 한다.
        function inputIdChk(){
            document.userInfo.idDuplication.value ="idUncheck";
        }

$(function(){

//비밀번호 확인
	$('#pw2').blur(function(){
	   if($('#pw').val() != $('#pw2').val()){
	    	if($('#pw2').val()!=''){
		    alert("비밀번호가 일치하지 않습니다.");
	    	    $('#pw2').val('');
	          $('#pw2').focus();
	       }
	    }
	})
});






/*
//아이디 중복확인을 ajax방식으로 처리
  $("#username").keyup(function(){
   var msg="";

   if(validate_username($("#username").val())&& $("#username").val().length>2){
    //유효성 검사를 통과한 경우 중복확인을 하자
    $.ajax({
     <c:url>'>url:"<c:url value='/member/ajaxCheckId.do'/>",
     data:"username="+$("username").val(),
     dataType:"json",
     type:"get",
     success:function(res){
      //true, false
      if(!res){
       msg="이미 등록된 아이디 입니다.";
       $("#checkId").val("N");
      }else{
       msg="사용가능한 아이디 입니다.";
       $("#checkId").val("Y");
      }
      $("#errorMessage").html(msg);
     },
     error:function(xhr, status, error){
      alert(error);
     },
    });
   }else{
    //유효성 검사를 통과하지 못한 경우 - 에러 처리
    msg="아이디 규칙에 맞지 않습니다.";
    $("#checkId").val("Y");
   }
   $("#errorMessage").html(msg);
  });

 }); //document.ready

 */