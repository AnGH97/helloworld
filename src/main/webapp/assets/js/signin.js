$("#check_all").on("change", (e) => {
    $(".check").prop("checked", $(e.currentTarget).prop("checked"));
});


/**(3) 플러그인의 기본 설정 옵션 추가*/
jQuery.validator.setDefaults({
    onkeyup: false,
    onclick: false,
    onfocusout: false,
    showErrors: function(errorMap, errorList){
        if(this.numberOfInvalids()){
            /**(3-1)일반 alert 메시지*/
            alert(errorList[0].message);
            $(errorList[0].element).focus();
            /** (3-2) sweetalert2 alert 메시지*/
            /**new Swal("에러", errorList[0].message, "error").then().finally(() => {
                setTimeout(() => {
                    $(errorList[0].element).val("");
                    $(errorList[0].element).focus();
                }, 300);
            });*/
        }
    },
});
/**(1) 유효성 검사 추가 함수*/
$.validator.addMethod("kor", function (value, element){
    return this.optional(element) || /^[ㄱ-ㅎ가-힣]*$/i.test(value);
});

$.validator.addMethod("phone", function (value, element){
    return this.optional(element) || /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/i.test(value) || /^\d{2,3}\d{3,4}\d{4}$/i.test(value);
});

/** (2)form 태그에 부여한 id 속성에 대한 유효성 검사 함수 호출*/
$("#join_form").validate({
    debug: true,
    /**입력검사 규칙*/
    rules: {
        user_id: {required: true, alphanumeric: true},
        user_pw: {required: true, minlength: 4, maxlength: 20},
        user_pw_re: {required: true, equalTo: "#user_pw"},
        user_name: {required: true, kor: true},
        email: {required: true, email: true},
        tel: {required: true, phone: true},
        birthdate: {required: true, date: true},
        gender: "required",
    },
    /**규칙이 맞지 않을 경우의 메시지*/
    messages:{
        user_id: {required: "아이디를 입력하세요", alphanumeric: "아이디는 영어, 숫자만 입력 가능합니다."},
        user_pw: {required: "비밀번호를 입력하세요", minlength: "비밀번호는 4글자 이상 입력하셔야 합니다.", maxlength: "비밀번호는 최대 20자까지 가능합니다."},
        user_pw_re: {required: "비밀번호 확인값을 입력하세요.", aqualTo: "비밀번호 확인이 잘못되었습니다."},
        user_name: {required: "이름을 입력하세요", kor: "이름은 한글만 입력 가능합니다."},
        email: {required: "이메일을 입력하세요", email: "이메일 형식이 잘못되었습니다."},
        tel: {required: "연락처를 입력하세요", phone: "연락처 형식이 잘못되었습니다."},
        birthdate: {required: "생년월일을 입력하세요", date: "생년월일의 형식이 잘못되었습니다."},
        gender: "성별을 선택해 주세요.",
    },
});
