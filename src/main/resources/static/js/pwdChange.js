function updatePwd(){
    let pwd1 = $("#pwd1").val();
    let pwd2 = $("#pwd2").val();
    let id = $("#userId").val()

    if(pwd1 == pwd2){
        $("#pwdChange").attr("action", "/pwdChange/" + id);
        $("#pwdChange").submit();
    } else {
        alert("비밀번호가 서로 다릅니다 .")
    }

}