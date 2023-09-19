/**
 * 회원가입 유효검사
 */

var form = document.joinForm;

function join() {
	// value를 조건식 안에서 사용하면
	// 값이 있을때 true, 값이 없을때 false
	if(!form.id.value) {
		alert("아이디를 입력해주세요!");
		form.id.focus();
		return;
	}
	if(form.id.value.length < 4 || form.id.value.length > 16) {
		alert("아이디는 4자이상 16자 이하로 입력해주세요");
		form.id.focus();
		return;
	}
	if(!form.name.value) {
		alert("이름을 입력해주세요.");
		form.name.foucs();
		return;
	}
	if(!form.password.value) {
		alert("비밀번호를 입력해주세요");
		form.password.focus();
		return;
	}
}