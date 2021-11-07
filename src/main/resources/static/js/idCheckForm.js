var httpRequest = null;


        // httpRequest 객체 생성
        function getXMLHttpRequest(){
            var httpRequest = null;

            if(window.ActiveXObject){
                try{
                    httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
                } catch(e) {
                    try{
                        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e2) { httpRequest = null; }
                }
            }
            else if(window.XMLHttpRequest){
                httpRequest = new window.XMLHttpRequest();
            }
            return httpRequest;
        }


        // 회원가입창의 아이디 입력란의 값을 가져온다.
        function pValue(){
            document.getElementById("username").value = opener.document.userInfo.id.value;
        }

        // 아이디 중복체크
        function idCheck(){

            var id = document.getElementById("username").value;

            if (!id) {
                alert("아이디를 입력하지 않았습니다.");
                return false;
            }
            else if((id < "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")){
                alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
                return false;
            }
            else
            {
                var param="id="+id
                httpRequest = getXMLHttpRequest();
                httpRequest.onreadystatechange = callback;
                httpRequest.open("POST", "idCheckForm", true);
                httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                httpRequest.send(param);
            }
        }

        function callback(){
            if(httpRequest.readyState == 4){
                // 결과값을 가져온다.
                var resultText = httpRequest.responseText;
                if(resultText == 0){
                    alert("사용할수없는 아이디입니다.");
                    document.getElementById("cancelBtn").style.visibility='visible';
                    document.getElementById("useBtn").style.visibility='hidden';
                    document.getElementById("msg").innerHTML ="";
                }
                else if(resultText == 1){
                    document.getElementById("cancelBtn").style.visibility='hidden';
                    document.getElementById("useBtn").style.visibility='visible';
                    document.getElementById("msg").innerHTML = "사용 가능한 아이디입니다.";
                }
            }
        }

        // 사용하기 클릭 시 부모창으로 값 전달
        function sendCheckValue(){
            // 중복체크 결과인 idCheck 값을 전달한다.
            opener.document.userInfo.idDuplication.value ="idCheck";
            // 회원가입 화면의 ID입력란에 값을 전달
            opener.document.userInfo.id.value = document.getElementById("username").value;

            if (opener != null) {
                opener.chkForm = null;
                self.close();
            }
        }